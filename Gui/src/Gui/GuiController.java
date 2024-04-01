package Gui;

import impl.Automat;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import impl.Parser;


import java.net.URL;
import java.time.Duration;
import java.util.*;

public class GuiController implements Initializable{

    private Automat automat = new Automat(10);


    @FXML
    private TextField kuchenInfo;

    @FXML
    private TextField kuchenIdToDelete;

    @FXML
    private TextField kuchenIdToUpdate;

    @FXML
    private TextField addHersteller;

    @FXML
    private TextField deleteHersteller;

    @FXML
    private TableView<KuchenImpl> kuchenListTableView; //https://www.youtube.com/watch?v=A5fQbsJ-iF8

    @FXML
    private TableColumn<KuchenImpl, String> kuchensorteColumn;

    @FXML
    private TableColumn<KuchenImpl, Integer> kuchenFachnummerColumn;

    @FXML
    private TableColumn<KuchenImpl, HerstellerImpl> kuchenHerstellerTableColumn;

    @FXML
    private TableColumn<KuchenImpl, Duration> kuchenHaltbarkeitColumn;

    @FXML
    TableColumn<KuchenImpl, Date> kuchenInspektionsdatumColumn;


    @FXML
    private TableView<HerstellerImpl> herstellerTableView;

    @FXML
    private TableColumn<HerstellerImpl, String> herstellerNamenColumn;

    @FXML
    ObservableList<KuchenImpl> kuchenObservableList = FXCollections.observableArrayList();
    //Quellen: https://www.youtube.com/watch?v=A5fQbsJ-iF8
    //https://www.youtube.com/watch?v=fnU1AlyuguE
    //https://docs.oracle.com/javafx/2/ui_controls/table-view.htm

    @FXML
    ObservableList<HerstellerImpl> herstellerObservableList = FXCollections.observableArrayList();


    public void initialize(URL url, ResourceBundle resourceBundle) { //https://www.youtube.com/watch?v=A5fQbsJ-iF8
        kuchensorteColumn.setCellValueFactory(new PropertyValueFactory<KuchenImpl, String>("kuchensorte"));
        kuchenFachnummerColumn.setCellValueFactory(new PropertyValueFactory<KuchenImpl, Integer>("fachnummer"));
        kuchenHerstellerTableColumn.setCellValueFactory(new PropertyValueFactory<KuchenImpl, HerstellerImpl>("hersteller"));
        kuchenHaltbarkeitColumn.setCellValueFactory(new PropertyValueFactory<KuchenImpl, Duration>("haltbarkeit"));
        kuchenInspektionsdatumColumn.setCellValueFactory(new PropertyValueFactory<KuchenImpl, Date>("inspektionsdatum"));

        herstellerNamenColumn.setCellValueFactory(new PropertyValueFactory<HerstellerImpl, String>("name"));

        herstellerTableView.setItems(herstellerObservableList);
        kuchenListTableView.setItems(kuchenObservableList); //die table view soll dann mit der Obersever liste verknüpft werden




    }


    //listHerstellerListButton eig auch nicht mehr notwendig (durch ObservableList)
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



public void listKuchenListButton(ActionEvent e) { //eigentlich nicht mehr notwendig, weil ersetzt durch ObservableList
        if (kuchenObservableList != null) {
            kuchenListTableView.getItems().clear(); //um "neue" liste zu generieren
            if (automat != null && automat.getKuchenHashMap() != null) {
                for (Map.Entry<Integer, KuchenImpl> entry : automat.getKuchenHashMap().entrySet()) { //Quelle: https://sentry.io/answers/iterate-hashmap-java/
                 //ODER AUCH MIT FOR EACH: automat.getKuchenHashMap().forEach((key, value) -> { https://stackoverflow.com/questions/4234985/how-to-for-each-the-hashmap
                    KuchenImpl kuchen = entry.getValue(); //nimmt nur das value auf
                    kuchenListTableView.getItems().add(kuchen);
                    }
                }


            kuchenObservableList.clear();

            if (automat != null && automat.getKuchenHashMap() != null) {
                Collection<KuchenImpl> kuchenCollection = automat.getKuchenHashMap().values(); //alle kuchenobjekte aus der kuchenhashmap sollen rausgeholt werden und als collection abgespeichert werden
                kuchenObservableList.addAll(kuchenCollection); //die ganzen kuchen sollen dann in die Oberserverliste hinzugeügt werden
            }
        }
    }



    public void deleteHerstellerButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String deletedHersteller = deleteHersteller.getText();
        boolean checkIfHerstellerDeleted = herstellerListe.remove(new HerstellerImpl(deletedHersteller));
        if (checkIfHerstellerDeleted) {
            deleteHersteller.clear();
            herstellerObservableList.remove(new HerstellerImpl(deletedHersteller));
        }
    }

    public void addHerstellerButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String addedHersteller = addHersteller.getText();
        boolean checkIfHerstellerAdded = herstellerListe.add(new HerstellerImpl(addedHersteller));
        herstellerObservableList.add(new HerstellerImpl(addedHersteller));
        if (checkIfHerstellerAdded) {
            addHersteller.clear();
        }
    }


    public void deleteKuchenButton(ActionEvent e) {
        int deletedKuchenById = Integer.parseInt(kuchenIdToDelete.getText());

        if (deletedKuchenById >= 0 && deletedKuchenById < automat.maxkapazitaet) {
            boolean kuchenGone = automat.deleteKuchenById(deletedKuchenById);
            if (kuchenGone) {
                kuchenObservableList.remove(deletedKuchenById);
                kuchenIdToDelete.clear();
            }
        }

    }

    public void addKuchenButton(ActionEvent e) {
        List<HerstellerImpl> herstellerListe = automat.getHerstellerListe();
        String addedKuchen = kuchenInfo.getText();
        KuchenImpl createdKuchen = Parser.parseKuchenInfo(addedKuchen);

        boolean checkHersteller = herstellerListe.contains(createdKuchen.getHersteller());
        //System.out.println(checkHersteller);
        if (checkHersteller) {
            KuchenImpl kuchen = automat.addKuchen(addedKuchen);
            if (kuchen != null) {
                kuchenObservableList.add(kuchen);
                kuchenInfo.clear();
            }
        }

    }

    public void updateKuchenButton() {
        int updatedKuchenById = Integer.parseInt(kuchenIdToUpdate.getText());
        boolean aktuellesDatumUpdated = automat.updateInspektiosdatum(updatedKuchenById);
        if (aktuellesDatumUpdated) {
            kuchenIdToUpdate.clear();
            kuchenListTableView.refresh();
        }
    }

}
