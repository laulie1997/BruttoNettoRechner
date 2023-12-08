# BruttoNettoRechner
Beispiele für Clean Code
- Aussagekräftige Variablen, Methoden und Konstantenbezeichnungen
- Methoden sind modular aufgebaut und erfüllen jede eine klar abgegrenzte Aufgabe, somit ist auch die Wiederverwendbarkeit des Codes gegeben
- Da die Methoden jede einen klaren Zweck erfüllen, sind sie kurz gehalten
- Die Bedingung "kirchenzugehoerigkeit" wurde in eine Boolean-Methode ausgelagert und in der Methode zu Berechnung der Kirchensteuer referenziert
- Es wurden Konstanten für feste Werte (Steuerwerte, etc.) verwendet, um die Wartbarkeit zu verbessern --> keine Magic Numbers
- Der Code enthält keine unnötigen Kommentare, es befindet sich auch kein Code in den Kommentaren
- Minimierung von Wiederholungen durch Auslagerung in neue Methoden

Das Thema Fehlerbehandlung wurde in diesem Code nicht betrachtet, ist allerdings ein weiterer wichtiger Aspekt von Clean Code!
