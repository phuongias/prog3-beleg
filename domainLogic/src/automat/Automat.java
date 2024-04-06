package automat;


import impl.HerstellerImpl;
import impl.KuchenImpl;
import impl.Parser;
import kuchen.Allergen;
import kuchen.Kuchen;

import observerPattern.Observable;
import observerPattern.Observer;

import java.io.Serializable;
import java.time.Duration;
import java.util.*;


public class Automat implements Serializable, Observable {


    private HashMap<Integer, KuchenImpl> kuchenHashMap = new HashMap<Integer, KuchenImpl>();


    private ArrayList<HerstellerImpl> herstellerListe = new ArrayList<>();

    private HashSet<Allergen> allergenListe = new HashSet<>();

    private List<Observer> observerList;


    private int maxkapazitaet;


    public Automat(int maxkapazitaet) {
        this.maxkapazitaet = maxkapazitaet;
        this.observerList = new ArrayList<>();

    }


    //Hilfsmethode
    synchronized int getBelegteFaecher() {
        return kuchenHashMap.size();
    }


    //Hilfsmethode, um nachzupruefen, ob die Faecher voll sind
    synchronized public boolean isFull() {
        if (getBelegteFaecher() == maxkapazitaet) {
            return true;
        } else {
            return false;
        }
    }

    int getNaechstFreieFachnummer() {
        for (int id = 0; id < maxkapazitaet; id++) {
            if (!kuchenHashMap.containsKey(id)) {
                return id;
            }
        }
        return -1;
    }


    //Allergenliste
    public HashSet<Allergen> getAllergenListe() {
        return allergenListe;
    }

    private void updateAllergenToList(Kuchen kuchen) {
        if (!allergenListe.containsAll(kuchen.getAllergene())) {
            for (Allergen allergen : kuchen.getAllergene()) {
                if (!allergenListe.contains(allergen)) {
                    allergenListe.add(allergen);
                }
            }
        }

    }


    //Hilfmethode, um Hersteller in eine Liste hinzuzufügen
    public boolean addHersteller(HerstellerImpl hersteller) {
        if (!herstellerListe.contains(hersteller)) {
            herstellerListe.add(hersteller);
            //this.notifyObserver();
            return true;
        }
        return false;
    }


    public HerstellerImpl deleteHersteller(HerstellerImpl hersteller) {
        if (!herstellerListe.contains(hersteller)) {
            return null;
        }
        for (int i = 0; i < maxkapazitaet; i++) {
            if (kuchenHashMap.containsKey(i) && kuchenHashMap.get(i).getHersteller().equals(hersteller)) {
                kuchenHashMap.remove(i);
            }
        }
        herstellerListe.remove(hersteller);
        return hersteller;
    }


    public boolean checkHerstellerVorhanden(HerstellerImpl hersteller) {
        if (herstellerListe.contains(hersteller)) {
            return true;
        }
        return false;
    }


    //von CRUD -> CREATE
    synchronized public KuchenImpl addKuchen(String kuchenInfo) {
        if (isFull()) { //checkt kapazitaet
            return null;
        }

      /*  if (herstellerListe.contains(kuchen.getHersteller())) { //checkt ob hersteller in liste
            //checkHerstellerVorhanden(kuchen.getHersteller());
            // Der Hersteller ist in der Liste vorhanden, daher return true oder die Verarbeitung fortsetzen.
        } else {
            // Der Hersteller ist nicht in der Liste vorhanden, daher return false und eine entsprechende Nachricht ausgeben.
            return false;
        }*/

         /*for (int id = 0; id < MAXKAPAZITAET; id++) { //geht alle faecher durch
            if (!kuchenHashMap.containsKey(id)) { //wenn das fach nicht belegt ist:
                kuchenHashMap.put(id, kuchen); //kuchen hinzufuegen*/


        KuchenImpl kuchen = Parser.parseKuchenInfo(kuchenInfo);


        if (checkHerstellerVorhanden(kuchen.getHersteller())) {
            int fachnummer = getNaechstFreieFachnummer();
            if (fachnummer != -1) {
                kuchenHashMap.put(fachnummer, kuchen);
                kuchen.setFachnummer(fachnummer);
                updateInspektiosdatum(fachnummer);
                updateAllergenToList(kuchen);

                this.notifyObserver();
                return kuchen;

            } else {
                return null; //kein fach verfügbar

            }
        } else { // hersteller nicht vorhanden
            return null;
        }
    }


    //CRUD -> READ
    synchronized public HashMap<Integer, KuchenImpl> getKuchenHashMap() {
        return kuchenHashMap;
    }

    public ArrayList<HerstellerImpl> getHerstellerListe() {
        return herstellerListe;
    }

    //CRUD -> DELETE
    synchronized public boolean deleteKuchenById(int fachnummer) {
        if (fachnummer >= 0 && kuchenHashMap.containsKey(fachnummer)) {
            KuchenImpl kuchen = kuchenHashMap.remove(fachnummer);
            //Keine Verschiebung der Fachnummern der verbleibenden Kuchen


            this.notifyObserver();
            return true;
        }
        return false;
    }


    //CRUD -> UPDATE
    synchronized public boolean updateInspektiosdatum(int id) { //Inspesktionsdatum ändern
        if (this.kuchenHashMap.containsKey(id)) {//wenn fach belegt
            KuchenImpl kuchen = this.kuchenHashMap.get(id);
            if (kuchen != null) {
                Date newInspektionsdatum = new Date();
                newInspektionsdatum.setTime(System.currentTimeMillis());
                kuchen.setInspektionsdatum(newInspektionsdatum);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    //Methode, um Hersteller + jeweilige Anzahl von deren Kuchen anzugeben
    //durch herstellerliste gehen -> zweite schleife: durch kuchenHashmap -> zaehlen wie oft hersteller vorkommt -> diesen wert in neuen hashmap speichern

    public HashMap<HerstellerImpl, Integer> getHerstellerUndKuchenanzahl() {
        HashMap<HerstellerImpl, Integer> herstellerUndKuchenanzahlHashMap = new HashMap<>();

        /*for (int i = 0; i < herstellerListe.size(); i++) {

            for (int j = 0; j < kuchenHashMap.size(); j++) {
                int anzahl = 0;
                if (herstellerListe.get(i) == kuchenHashMap.get(j).getHersteller()) {
                    anzahl++;
                    herstellerUndKuchenanzahlHashMap.put(herstellerListe.get(i), anzahl);
                }
            }
        }
        return herstellerUndKuchenanzahlHashMap;*/

        for (HerstellerImpl hersteller : herstellerListe) {
            herstellerUndKuchenanzahlHashMap.put(hersteller, 0);
        }

        //Kuchenanzahl für jeden Hersteller
        for (KuchenImpl kuchen : kuchenHashMap.values()) {
            HerstellerImpl hersteller = kuchen.getHersteller();
            int aktuelleAnzahl = herstellerUndKuchenanzahlHashMap.get(hersteller);
            herstellerUndKuchenanzahlHashMap.put(hersteller, aktuelleAnzahl + 1);

            hersteller.setAnzahlKuchen(aktuelleAnzahl + 1);
        }


        return herstellerUndKuchenanzahlHashMap;
    }


    //Allergen anzeigen lassen
    public Collection<Allergen> getAllergenList(HashMap<Integer, KuchenImpl> kuchenHashMap) {

        Set<Allergen> vorhandeneAllergene = new HashSet<>();

        // Alle Kuchen durchgehen und Allergene sammeln
        for (KuchenImpl kuchen : kuchenHashMap.values()) {
            Collection<Allergen> allergeneDesKuchens = kuchen.getAllergene();
            vorhandeneAllergene.addAll(allergeneDesKuchens);
        }
        return vorhandeneAllergene;
    }

    public int getMaxkapazitaet() {
        return maxkapazitaet;
    }
    // Methode zur Umwandlung einer Duration in Tage



    //Observer

    @Override
    public boolean register(Observer observer) {
        if (observer != null) {
            return this.observerList.add(observer);
        }
        return false;
    }

    @Override
    public boolean unregister(Observer observer) {
        return this.observerList.remove(observer);

    }


    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }


}
