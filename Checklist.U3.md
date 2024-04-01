# Übung 3
Erstellen Sie die Simulationen für den Beleg. Jede Simulation soll eine eigene main-Methode haben.

Für die zufällig zu erzeugenden Kuchen kann auch eine Liste mit verschiedenen Instanzen bzw. Eigenschaften erzeugt werden, aus der zufällig ausgewählt wird.

## Abgabeanforderungen
Die Abgabe hat als zip-Datei zu erfolgen, die ein lauffähiges IntelliJ-IDEA-Projekt enthält. Sie sollte die befüllte Checkliste im root des Projektes (neben der iml-Datei) enthalten in der erreichte Stand bezüglich des Bewertungsschemas vermerkt ist.

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
- [x] JUnit5 und Mockito als Testframeworks (soweit verwendet)
- [x] keine weiteren Bibliotheken außer JavaFX
- [x] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [x] kompilierbar
- [x] Trennung zwischen Test- und Produktiv-Code
- [x] main-Methoden nur im default package des module belegProg3
- [x] ausführbar
- [x] Simulation 1
- [x] Trennung zwischen GL und Simulationslogik
- [x] kritische Bereiche/atomare Operationen verwendet
- [x] Aktionen der threads produzieren Ausgaben auf der Konsole

### empfohlene Realisierungen als Vorbereitung auf den Beleg
werden überprüft (aber nicht bewertet), wenn hier in der vorgegebenen Reihenfolge als bearbeitet angegeben
- [ ] keine Verwendung von Thread.sleep o.Ä. bzw. nur mit 0-Werten
- [ ] Änderungen an der Geschäftslogik produzieren Ausgaben auf der Konsole
- [ ] deterministische Funktionalität testbar
- [ ] Simulation 2
- [ ] mindestens je ein Test für alle in der Simulation verwendeten Methoden die auf die Geschäftslogik zugreifen
- [ ] alle Tests sind deterministisch
- [ ] Simulation 3

