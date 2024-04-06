package DekoGui;

import dekorationsmuster.*;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import impl.Parser;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.util.Callback;
import kuchen.Allergen;

import java.net.URL;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class DekoGuiController {

    DekorationsKuchenAutomat automat = new DekorationsKuchenAutomat(10);


    @FXML
    private TextField info;


    @FXML
    private TableView<DekorationsKuchen> kuchenListTableView; //https://www.youtube.com/watch?v=A5fQbsJ-iF8

    @FXML
    private TableColumn<DekorationsKuchen, KuchenBoden> kuchenBodenColumn;

    @FXML
    private TableColumn<DekorationsKuchen, Integer> kuchenFachnummerColumn;

    @FXML
    private TableColumn<DekorationsKuchen, HerstellerImpl> kuchenHerstellerTableColumn;

   @FXML
   private TableColumn<DekorationsKuchen, Belag> kuchenBelagColumn;


    @FXML
    private TableView<HerstellerImpl> herstellerTableView;

    @FXML
    private TableColumn<HerstellerImpl, String> herstellerNamenColumn;


    @FXML
    ObservableList<DekorationsKuchen> kuchenObservableList = FXCollections.observableArrayList();
    //Quellen: https://www.youtube.com/watch?v=A5fQbsJ-iF8
    //https://www.youtube.com/watch?v=fnU1AlyuguE
    //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm

    @FXML
    ObservableList<HerstellerImpl> herstellerObservableList = FXCollections.observableArrayList();


    public void initialize(URL url, ResourceBundle resourceBundle) { //https://www.youtube.com/watch?v=A5fQbsJ-iF8
        kuchenBodenColumn.setCellValueFactory(new PropertyValueFactory<DekorationsKuchen, KuchenBoden>("kuchenBoden"));
        kuchenFachnummerColumn.setCellValueFactory(new PropertyValueFactory<DekorationsKuchen, Integer>("fachnummer"));
        kuchenHerstellerTableColumn.setCellValueFactory(new PropertyValueFactory<DekorationsKuchen, HerstellerImpl>("hersteller"));
        kuchenBelagColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DekorationsKuchen, Belag>, ObservableValue<Belag>>() {
            @Override
            public ObservableValue<Belag> call(TableColumn.CellDataFeatures<DekorationsKuchen, Belag> cellData) {
                DekorationsKuchen kuchen = cellData.getValue();
                Set<Belag> belaege = kuchen.getBelaege();
                // Wählen Sie hier den richtigen Belag aus Ihrem Set aus, den Sie anzeigen möchten
                Belag belag = belaege.iterator().next(); // Hier wählen wir den ersten Belag aus dem Set aus
                return new SimpleObjectProperty<>(belag);
            }
        });


        herstellerNamenColumn.setCellValueFactory(new PropertyValueFactory<HerstellerImpl, String>("name"));


        herstellerTableView.setItems(herstellerObservableList);
        kuchenListTableView.setItems(kuchenObservableList); //die table view soll dann mit der Obersever liste verknüpft werden

    }

    public void listHerstellerListButton(ActionEvent e) { //Quelle: https://www.youtube.com/watch?v=Pqfd4hoi5cc
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        if (herstellerObservableList != null) {
            herstellerObservableList.clear();
            if (automat != null && herstellerListe != null) {
                for (HerstellerImpl hersteller : herstellerListe) { //geht durch ganze herstellerliste um jeden hersteller aufzulisten
                    herstellerTableView.getItems().add(hersteller); //https://stackoverflow.com/questions/72965755/how-to-save-and-load-a-listview-in-javafx
                }
            }
        }
    }

    public void deleteHerstellerButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String deletedHersteller = info.getText();
        boolean checkIfHerstellerDeleted = herstellerListe.remove(new HerstellerImpl(deletedHersteller));
        if (checkIfHerstellerDeleted) {
            info.clear();
            herstellerObservableList.remove(new HerstellerImpl(deletedHersteller));
        }
    }

    public void addHerstellerButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String addedHersteller = info.getText();
        boolean checkIfHerstellerAdded = herstellerListe.add(new HerstellerImpl(addedHersteller));
        herstellerObservableList.add(new HerstellerImpl(addedHersteller));
        if (checkIfHerstellerAdded) {
            info.clear();
        }
    }


    public void deleteKuchenButton(ActionEvent e) {
        int deletedKuchenById = Integer.parseInt(info.getText());

        if (deletedKuchenById >= 0 && deletedKuchenById < automat.getMaxkapazitaet()) {
            boolean kuchenGone = automat.deleteKuchenById(deletedKuchenById);
            if (kuchenGone) {
                kuchenObservableList.remove(deletedKuchenById);
                info.clear();
            }
        }
        listHerstellerListButton(e);


    }

    public void addKuchenButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String addedKuchen = info.getText();
        DekorationsKuchen createdKuchen = DekoKuchenParser.parseDekoKuchenInfo(addedKuchen);

        boolean checkHersteller = herstellerListe.contains(createdKuchen.getHersteller());
        //System.out.println(checkHersteller);
        if (checkHersteller) {
            DekorationsKuchen kuchen = automat.addDekoKuchen(addedKuchen);
            if (kuchen != null) {
                kuchenObservableList.add(kuchen);
                info.clear();
            }
        }
        listHerstellerListButton(e);


    }

}
