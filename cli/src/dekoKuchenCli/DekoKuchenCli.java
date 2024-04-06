package dekoKuchenCli;

import dekorationsmuster.DekorationsKuchen;
import dekorationsmuster.DekorationsKuchenAutomat;
import impl.HerstellerImpl;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DekoKuchenCli {


        private DekorationsKuchenAutomat dekorationsKuchenAutomat;
        Scanner scanner = new Scanner(System.in);

        public DekoKuchenCli(DekorationsKuchenAutomat dekorationsKuchenAutomat) {
            this.dekorationsKuchenAutomat = dekorationsKuchenAutomat;

        }

        //Hilfsmethode, um die Kuchen aus der Liste auszuprinten -> UI
        public void printKuchenList() {
            HashMap<Integer, DekorationsKuchen> kuchenHashMap = dekorationsKuchenAutomat.getKuchenHashMap();

            for (int id = 0; id < dekorationsKuchenAutomat.getMaxkapazitaet(); id++) {
                if (kuchenHashMap.containsKey(id)) {
                    System.out.println("Kuchen: " + kuchenHashMap.get(id).getKuchenBoden());
                    System.out.println("Preis: " + kuchenHashMap.get(id).gesamtpreisBerechnen());
                    System.out.println("Fachnummer: " + kuchenHashMap.get(id));
                    System.out.println("Fachnummer:" + kuchenHashMap.get(id).getFachnummer());
                    System.out.println("Hersteller: " + kuchenHashMap.get(id).getHersteller().getName());
                    System.out.println("Haltbarkeit: " + kuchenHashMap.get(id).getHaltbarkeit());
                    System.out.println("Naehrwert: " + kuchenHashMap.get(id).gesamtNaehrwert());
                    System.out.println("Allergene: " + kuchenHashMap.get(id).gesamtAllergene());
                /*System.out.println("Obstsorte: " + automat.kuchenHashMap.get(id).getObstsorte());
                System.out.println("Kremsorte: " + kuchenHashMap.get(id).getKremsorte());*/
                    System.out.println("Inspektionsdatum: " + kuchenHashMap.get(id).getInspektionsdatum());
                    System.out.println();
                }
            }
        }

        public void printHerstellerList() {
            List<HerstellerImpl> herstellerListe = dekorationsKuchenAutomat.getHerstellerListe();
            for (int i = 0; i < herstellerListe.size(); i++) {
                System.out.println(herstellerListe.get(i).getName());
            }
        }


        public void execute() {
            while (true) {
                System.out.println("Menü: ");
                System.out.println("c - Einfügemodus ");
                System.out.println("d - Löschmodus ");
                System.out.println("r - Anzeigemodus");
                System.out.println("u - Änderungsmodus");

                try {
                    char choice = scanner.next().charAt(0); //choice, um zu entscheiden welchen menü-punkt man auswählen will
                    scanner.nextLine();

                    switch (choice) {
                        case 'c': //Einfügemodus

                            System.out.println("Einfügemodus ");
                            System.out.println("h - Hersteller hinzufügen:");
                            System.out.println("k - Kuchen hinzufügen: ");

                            char innerChoice = scanner.next().charAt(0);
                            switch (innerChoice) {
                                case 'h':
                                    System.out.println("Geben Sie den Hersteller an den sie hinzufügen möchten: ");
                                    String addedHersteller = scanner.next();
                                    boolean herstellerAdded = dekorationsKuchenAutomat.addHersteller(new HerstellerImpl(addedHersteller));

                                    if (herstellerAdded) {
                                        System.out.println("Hersteller erfolgreich hinzugefügt.");
                                    } else {
                                        System.out.println("Hersteller konnte nicht hinzugefügt werden.");
                                    }
                                    break;

                                case 'k':
                                    System.out.println("Geben Sie die Kucheninformation in folgender Reihenfolge an: [Kochenboden(Muerteig/Hefeteig)] [Hersteller] [Belag]");
                                    scanner.nextLine();
                                    String kuchenInfo = scanner.nextLine();

                                    DekorationsKuchen kuchenAdded = dekorationsKuchenAutomat.addDekoKuchen(kuchenInfo);


                                    if (kuchenAdded != null) {
                                        boolean checkHersteller = dekorationsKuchenAutomat.getHerstellerListe().contains(kuchenAdded.getHersteller());
                                        System.out.println(checkHersteller);
                                        if (checkHersteller) {
                                            if (kuchenAdded != null) {
                                                System.out.println("Kuchen erfolgreich hinzugefügt.");
                                            } else {
                                                System.out.println("Kuchen konnte nicht hinzugefügt werden.");
                                            }
                                        } else {
                                            System.out.println("Hersteller nicht vorhanden. Kuchen konnte somit nicht hinzugefügt werden.");
                                        }
                                    }
                                    break;
                            }
                            break;


                        case 'd': //Löschmodus
                            System.out.println("Löschmodus ");
                            System.out.println("h - Hersteller löschen:");
                            System.out.println("k - Kuchen löschen: ");

                            char innerChoice2 = scanner.next().charAt(0);
                            switch (innerChoice2) {
                                case 'h':
                                    System.out.println("Geben Sie den Hersteller an den Sie löschen wollen: ");
                                    String deletedHersteller = scanner.next();
                                    HerstellerImpl herstellerDeleted = dekorationsKuchenAutomat.deleteHersteller(new HerstellerImpl(deletedHersteller));

                                    if (herstellerDeleted != null) {
                                        System.out.println("Hersteller erfolgreich gelöscht.");
                                    } else {
                                        System.out.println("Hersteller konnte nicht gelöscht werden.");
                                    }

                                    break;

                                case 'k':
                                    System.out.println("Bitte geben Sie die Fachnummer vom Kuchen ein, welches Sie löschen wollen: ");
                                    int deletedKuchenById = scanner.nextInt();

                                    if (deletedKuchenById >= 0 && deletedKuchenById < dekorationsKuchenAutomat.getMaxkapazitaet()) {
                                        boolean kuchenDeleted = dekorationsKuchenAutomat.deleteKuchenById(deletedKuchenById);

                                        if (kuchenDeleted) {
                                            System.out.println("Kuchen erfolgreich gelöscht.");
                                        } else {
                                            System.out.println("Kuchen konnte nicht gelöscht werden.");
                                        }

                                    } else {
                                        System.out.println("Ungültige Fachnummer!");
                                    }
                                    break;
                            }
                            break;


                        case 'r': //Anzeigemodus
                            System.out.println("Anzeigemodus ");
                            System.out.println("k - Kuchenliste anzeigen: ");
                            System.out.println("h - Hersteller: ");

                            char innerChoice3 = scanner.next().charAt(0);
                            switch (innerChoice3) {
                                case 'k':
                                    System.out.println("Kuchenliste: ");
                                    printKuchenList();
                                    break;

                                case 'h':
                                    System.out.println("Herstellerliste: ");
                                    printHerstellerList();
                                    break;
                            }
                            break;


                        case 'u':
                            System.out.println("Geben Sie die Fachnummer vom dem Kuchen an von dem sie das Inspektionsdatum updaten möchten: ");
                            int updatedKuchenById = scanner.nextInt();
                            boolean aktuellesDatum = dekorationsKuchenAutomat.updateInspektiosdatum(updatedKuchenById);
                            if (aktuellesDatum) {
                                System.out.println("Das Inspektionsdatum vom ausgewählten Kuchen wurde erfolgreich geändert.");
                            } else {
                                System.out.println("Das Inspektionsdatum vom ausgewählten Kuchen konnte nicht geändert werden.");
                            }
                            break;

                        case 'p':
                            System.out.println("Persistenzmodus:");
                            break;
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Ungültiger Eintrag!");
                    scanner.nextLine();
                }

            }
        }
    }












