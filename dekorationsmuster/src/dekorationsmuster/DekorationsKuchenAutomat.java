package dekorationsmuster;

import impl.HerstellerImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DekorationsKuchenAutomat { //Methoden groeßtenteils von Automatenklasse der DL uebernommen

    private HashMap<Integer, DekorationsKuchen> kuchenHashMap = new HashMap<Integer, DekorationsKuchen>();

    public ArrayList<HerstellerImpl> getHerstellerListe() {
        return herstellerListe;
    }

    private ArrayList<HerstellerImpl> herstellerListe = new ArrayList<>();


    private int maxkapazitaet;


    public DekorationsKuchenAutomat(int maxkapazitaet) {
        this.maxkapazitaet = maxkapazitaet;
    }

    public HashMap<Integer, DekorationsKuchen> getKuchenHashMap() {
        return kuchenHashMap;
    }


    synchronized int getBelegteFaecher() {
        return kuchenHashMap.size();
    }


    synchronized public boolean isFull() {
        if (getBelegteFaecher() == maxkapazitaet) {
            return true;
        } else {
            return false;
        }
    }

    private int getNaechstFreieFachnummer() {
        for (int id = 0; id < maxkapazitaet; id++) {
            if (!kuchenHashMap.containsKey(id)) {
                return id;
            }
        }
        return -1;
    }


    //Hilfmethode, um Hersteller in eine Liste hinzuzufügen
    public boolean addHersteller(HerstellerImpl hersteller) {
        if (!herstellerListe.contains(hersteller)) {
            herstellerListe.add(hersteller);
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



    public DekorationsKuchen addDekoKuchen(String kuchenInfo) {
        if (isFull()) {
            return null;
        }

        DekorationsKuchen dekoKuchen = DekoKuchenParser.parseDekoKuchenInfo(kuchenInfo);

        if (herstellerListe.contains(dekoKuchen.getHersteller())) {
            int fachnummer = getNaechstFreieFachnummer();
            if (fachnummer != -1) {
                kuchenHashMap.put(fachnummer, dekoKuchen);
                dekoKuchen.setFachnummer(fachnummer);
                updateInspektiosdatum(fachnummer);

                return dekoKuchen;

            } else {
                return null; //kein fach verfügbar

            }

        }else {
            return null; //wenn kein hersteller vorhanden
        }
    }


     public boolean deleteKuchenById(int fachnummer) {
        if (fachnummer >= 0 && kuchenHashMap.containsKey(fachnummer)) {
            DekorationsKuchen kuchen = kuchenHashMap.remove(fachnummer);
            //Keine Verschiebung der Fachnummern der verbleibenden Kuchen

            return true;
        }
        return false;
    }


    //CRUD -> UPDATE
    public boolean updateInspektiosdatum(int id) { //Inspesktionsdatum ändern
        if (this.kuchenHashMap.containsKey(id)) {//wenn fach belegt
            DekorationsKuchen kuchen = this.kuchenHashMap.get(id);
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

    public int getMaxkapazitaet() {
        return maxkapazitaet;
    }
}