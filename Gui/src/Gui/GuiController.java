package Gui;

import automat.Automat;
import impl.HerstellerImpl;
import impl.KuchenImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import impl.Parser;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;


import java.net.URL;
import java.time.Duration;
import java.util.*;

public class GuiController implements Initializable {

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
    private TableColumn<HerstellerImpl, Integer> kuchenAnzahlColumn;

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

        herstellerNamenColumn.setCellValueFactory(new PropertyValueFactory<HerstellerImpl,String>("name"));
        kuchenAnzahlColumn.setCellValueFactory(new PropertyValueFactory<HerstellerImpl, Integer>("kuchenAnzahl"));



        herstellerTableView.setItems(herstellerObservableList);
        kuchenListTableView.setItems(kuchenObservableList); //die table view soll dann mit der Obersever liste verknüpft werden


        // Drag-and-Drop für Kuchenliste
        //Quelle: https://stackoverflow.com/questions/28603224/sort-tableview-with-drag-and-drop-rows
        kuchenListTableView.setRowFactory(tv -> {
            TableRow<KuchenImpl> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard dragboard = row.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(index.toString());
                    dragboard.setContent(content);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard dragboard = event.getDragboard();
                if (dragboard.hasString() && !row.isEmpty()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });

            row.setOnDragDropped(event -> {
                Dragboard dragboard = event.getDragboard();
                if (dragboard.hasString()) {
                    int draggedIndex = Integer.parseInt(dragboard.getString());
                    ObservableList<KuchenImpl> items = kuchenListTableView.getItems();
                    KuchenImpl draggedItem = items.get(draggedIndex);
                    KuchenImpl targetItem = items.get(row.getIndex());

                    //Austausch der Fachnummer
                    int tempFachnummer = draggedItem.getFachnummer();
                    draggedItem.setFachnummer(targetItem.getFachnummer());
                    targetItem.setFachnummer(tempFachnummer);

                    kuchenListTableView.refresh();

                    event.setDropCompleted(true);
                    event.consume();
                }
            });

            return row;
        });

    }


    //listHerstellerListButton eig auch nicht mehr notwendig (durch ObservableList)
    public void listHerstellerListButton(ActionEvent e) { //Quelle: https://www.youtube.com/watch?v=Pqfd4hoi5cc

        /*HashMap<HerstellerImpl, Integer> herstellerUndKuchenanzahl = automat.getHerstellerUndKuchenanzahl();

        if (herstellerObservableList != null && !herstellerUndKuchenanzahl.isEmpty()) {
            herstellerObservableList.clear();
            for (Map.Entry<HerstellerImpl, Integer> entry : herstellerUndKuchenanzahl.entrySet()) {
                HerstellerImpl hersteller = entry.getKey();
                int anzahlKuchen = entry.getValue();
                hersteller.setAnzahlKuchen(anzahlKuchen);
                herstellerObservableList.add(hersteller);
            }
        }*/

        HashMap<HerstellerImpl, Integer> herstellerUndKuchenanzahl = automat.getHerstellerUndKuchenanzahl();

        if (herstellerObservableList != null && !herstellerUndKuchenanzahl.isEmpty()) {
            herstellerObservableList.clear();
            for (Map.Entry<HerstellerImpl, Integer> entry : herstellerUndKuchenanzahl.entrySet()) {
                HerstellerImpl hersteller = entry.getKey();
                int anzahlKuchen = entry.getValue();
                hersteller.setAnzahlKuchen(anzahlKuchen);
                herstellerObservableList.add(hersteller);
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
                kuchenObservableList.addAll(kuchenCollection); //die ganzen kuchen dann in observablelist
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

        if (deletedKuchenById >= 0 && deletedKuchenById < automat.getMaxkapazitaet()) {
            boolean kuchenGone = automat.deleteKuchenById(deletedKuchenById);
            if (kuchenGone) {
                kuchenObservableList.remove(deletedKuchenById);
                kuchenIdToDelete.clear();
            }
        }
        listHerstellerListButton(null);


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
        listHerstellerListButton(null);


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