# Übung 2
Erstellen Sie ein prototypisches CLI.CLI für den Beleg mit einem einfachen event-System welches Benutzeroberfläche und Geschäftslogik verbindet und außerdem einen Beobachter.
Legen Sie dafür die entsprechenden Module an. (siehe auch https://www.jetbrains.com/help/idea/creating-and-managing-modules.html#add-new-module)

Eine prototypische Lösung würde 4 Befehle (und keine Modi) kennen: ein Befehl zum Einfügen eines (vordefinierten) Kuchen, ein Befehl zum Anzeigen der Kuchen, ein Befehl zum Inspizieren eines Kuchens und ein Befehl zum Entfernen eines Kuchens.

Der Persistenzmodus sowie die Ausführung als io.Client bzw. io.Server sind nicht Teil der Übung.

## Abgabeanforderungen
Die Abgabe hat als zip-Datei zu erfolgen, die ein lauffähiges IntelliJ-IDEA-Projekt enthält. Sie sollte die befüllte Checkliste im root des Projektes (neben der iml-Datei) enthalten in der der erreichte Stand bezüglich des Bewertungsschemas vermerkt ist.

Änderungen an der Checkliste sind grundsätzlich nicht zulässig. Davon ausgenommen ist das Befüllen der Checkboxen und ergänzende Anmerkungen die _kursiv gesetzt_ sind.

## Quellen
Zulässige Quellen sind suchmaschinen-indizierte Internetseiten. Werden mehr als drei zusammenhängende Anweisungen übernommen ist die Quelle in den Kommentaren anzugeben. Ausgeschlossen sind Quellen, die auch als Beleg oder Übungsaufgabe abgegeben werden oder wurden. Zulässig sind außerdem die über moodle bereitgestellten Materialien, diese können für die Übungsaufgaben und den Beleg ohne Quellenangabe verwendet werden.
Flüchtige Quellen, wie Sprachmodelle, sind per screen shot zu dokumentieren.

## Bewertung
1 Punkt für die Erfüllung des Pflichtteils

### Pflichtteil
- [x] Quellen angegeben
- [x] zip Archiv
- [x] IntelliJ-Projekt (kein Gradle, Maven o.ä.)
- [x] JUnit5 und Mockito als Testframeworks (soweit verwendet) _Tests aus der 1. Übung wurden auskommentiert, weil Methoden teils umgeschrieben wurden_
- [x] keine weiteren Bibliotheken außer JavaFX
- [x] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [x] kompilierbar
- [x] Trennung zwischen Test- und Produktiv-Code
- [x] main-Methoden nur im default package des module belegProg3
- [x] ausführbar
- [x] Benutzeroberfläche und Geschäftslogik korrekt aufgeteilt
- [x] prototypisches CLI.CLI (nicht notwendig, wenn umfangreicheres  CLI.CLI realisiert ist)

### empfohlene Realisierungen als Vorbereitung auf den Beleg
werden überprüft (aber nicht bewertet), wenn hier in der vorgegebenen Reihenfolge als bearbeitet angegeben
- [x] event-System für die Kommunikation vom CLI.CLI zur GL realisiert
- [ ] Beobachter realisiert
- [x] event-System für die Kommunikation von der GL zum CLI.CLI realisiert
- [ ] angemessene Aufzählungstypen verwendet
- [ ] zwei Tests für Beobachter realisiert
- [ ] zwei Tests für listener realisiert
- [ ] nach MVC strukturiert
- [ ] vollständiger Befehlssatz

