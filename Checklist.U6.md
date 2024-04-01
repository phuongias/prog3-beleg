y# Übung 6
Erweitern Sie das CLI als io.Client-io.Server-Lösung. Der io.Client soll dabei die Oberfläche zur Bedienung realisieren und der io.Server die Geschäftslogik enthalten.

Die Berücksichtigung von Skalierbarkeit, Sicherheit und Transaktionskontrollen ist nicht gefordert.

Die Observer müssen nicht im Netzwerk funktionieren.

Clients und Servers haben jeweils eine eigene main-Methode (IntelliJ kann mehrere Applikationen parallel ausführen).

Weitere Informationen stehen im Anforderungsdokument unter der Überschrift net.

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
- [x] JUnit5 und Mockito als Testframeworks (soweit verwendet)
- [x] keine weiteren Bibliotheken außer JavaFX
- [x] keine Umlaute, Sonderzeichen, etc. in Datei- und Pfadnamen
- [x] kompilierbar
- [x] Trennung zwischen Test- und Produktiv-Code
- [x] main-Methoden nur im default package des module belegProg3
- [x] ausführbar
- [ ] CRUD für eine Kuchensorte via TCP oder UDP
- [ ] saubere Trennung zwischen Oberfläche (io.Client) und Geschäftslogik (io.Server)

### empfohlene Realisierungen als Vorbereitung auf den Beleg
werden überprüft (aber nicht bewertet), wenn hier in der vorgegebenen Reihenfolge als bearbeitet angegeben
- [ ] je ein Stellvertreter-Test für Einfügen und Anzeigen pro io.Server
- [ ] Implementierung von io.Client und io.Server für TCP und UDP
- [ ] Unterstützung mehrerer konkurierender Clients pro io.Server (TCP oder UDP)
