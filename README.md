# Projekt: Einkaufszettel (Fr/2, Kr)

Name & Praktikumstermin: Lars Köhler, 5211085 (Fr/2, Kr)


## Inhaltsverzeichnis

- [Projekt: Einkaufszettel (Fr/2, Kr)](#Projekt-Odos---Die-Fahrtenbuch-App-Fr1-Hb)
  - [Inhaltsverzeichnis](#Inhaltsverzeichnis)
  - [Kurzbeschreibung inkl. Screenshot](#Kurzbeschreibung-inkl-Screenshot)
  - [Beschreibung des Projektaufbaus](#Beschreibung-des-Projektaufbaus)
    - [Abgabedateien (LOC)](#Abgabedateien-LOC)
    - [Testdateien (TST)](#Testdateien-TST)
    - [Aufbau der Anwendung](#Aufbau-der-Anwendung)
    - [Technischer Anspruch (TA) und Umsetzung der Features](#Technischer-Anspruch-TA-und-Umsetzung-der-Features)
  - [Quellennachweis](#Quellennachweis)
    - [1. Allgemeine Quellen](#1-Allgemeine-Quellen)
    - [2. Explizite Quellen](#2-Explizite-Quellen)
  - [Skizzen-Entwürfe der grafischen Oberfläche - Erste Design-Ansätze](#Skizzen-Entw%C3%BCrfe-der-grafischen-Oberfl%C3%A4che---Erste-Design-Ans%C3%A4tze)



## Kurzbeschreibung inkl. Screenshot

> Jeder kennt es, dass man einkaufen gehen will und man meint, dass man sich alles was man besorgen will merken kann und dann im Nachhinein doch merkt, etwas vergessen zu haben.
Dafür gibt es Einkaufszettel und diese App ist dafür gedacht, dass man sich digital Einkaufszettel erstellen kann mit allen Artikeln, die man besorgen möchte.
Diese kann man sich dann ausdrucken oder auf das Handy schicken, damit kann dann schnell sehen kann, was man noch einkaufen möchte ohne etliche Papierzettel zu verwenden.




![Screenshot](InActionCollage.jpg)

<br> 

**Hinweise**: 


---



## Beschreibung des Projektaufbaus

### Abgabedateien (LOC)

Verlinkter Dateiname | Dateiart | LOC
---------------------|----------|-----
**[App.java](src/main/java/pack/App.java)** | Java | 110
**[ListManager.java](src/main/java/pack/User.java)** | Java | 22
**[HTMLGenerator.java](src/main/java/pack/UserManagement.java)** | Java | 32
**[connection.js](src/main/resources/public/indexscript.js)** | JavaScript | 18
**[main.js](src/main/resources/private/fahrtenbuchscript.js)** | JavaScript | 56
**[index.html](src/main/resources/public/index.html)** | HTML | 34
**[all.css](src/main/resources/public/indexstyles.css)** | CSS | 44
**[main.css](src/main/resources/private/fahrtenbuchstyles.css)** | CSS | 30
**[variables.css](src/main/resources/public/hintergrundIndex.jpg)** | CSS | 20
 <br> | <br> | *= 793* 


### Testdateien (TST)

Verlinkter Dateiname | Testart | Anzahl der Tests
---------------------|---------|-----------------
**[ListTest.java](src/test/java/FahrtenbuchTest.java)** | Asserts | 53

Die Tests werden wie folgt ausgeführt: Im Terminal wird auf der Ebene der `ListTest.java` (src/main/java/shopping/list) die Eingabe `jshell -R-ea ListTest.java` getätigt.



### Aufbau der Anwendung 

![](FileTree.png)

Der Projektordner `src` teilt sich, wie auch oben anhand des FileTrees veranschaulicht,
in zwei weitere Ordner auf: `main` und `test`. <br> Im `test` Ordner befindet sich eine Datei namens `FahrtenbuchTest.java`, diese enthält alle JUnit4 Tests zum Projekt. Nach Ablauf der Tests wird von Gradle ein Bericht über den Ablauf erstellt, welcher unter dem Pfad: `build/reports/tests/test/index.html` als HTML-Dokument zu finden ist. <br>
Der `main` Ordner enthält den eigentlichen Programmcode der Anwendung im Ordner `java` befinden sich alle `.java` Dateien, der Kern der Anwendung. Die Inhalte aller `.java` Dateien wird in der folgenden Tabelle beschrieben:

<br>


| Datei | Inhalt |
| ----- | ----- |
**[Adress.java](src/main/java/pack/Adress.java)** | Einfache Klasse zur Erstellung von Adressen-Objekten in Java. 
**[App.java](src/main/java/pack/App.java)** | Bildet mit der main-Methode den Einstiegspunkt zum Serverstart. <br>Nimmt alle einkommenden HTTP-Requests entgegen um diese weiter zu verarbeiten.
**[Coder.java](src/main/java/pack/Coder.java)** | Nachdem eine Instanz mit einem `String` als Argument erzeugt wurde, kann dieser `String`, mithilfe der Methoden der Instanz, kodiert oder dekodiert werden.
**[CreateFiles.java](src/main/java/pack/CreateFiles.java)** | Wird mit dem Namen des Benutzers, für welchen ein Dateien-Ordner erstellt werden soll, instanziiert. Anschließend kann, über eine Methode der Instanz, ein Ordner mit den nötigen Dateien erstellt werden.
**[Journey.java](src/main/java/pack/Journey.java)** | *Implementiert [Storeable](src/main/java/pack/Storeable.java).*  Java-Klasse zur Erstellung von Fahrten-Objekten in Java, sie besitzt alle nötigen Parameter einer Fahrt, wie beispielsweise die Adressen und das Datum. Außerdem befinden sich Methoden zur Berechnung von gesamt-gefahrenen Kilometern einer Liste von Fahrten sowie eine Methode zum Parsen von HTML, um die Fahrten darzustellen.
**[JourneyTemplate.java](src/main/java/pack/JourneyTemplate.java)** | *Implementiert [Storeable](src/main/java/pack/Storeable.java).*  Java-Klasse zur Erstellung von Fahrt-Vorlage-Objekten, besitzt alle Parameter wie eine Fahrt, bis auf das Datum. Somit können wiederverwendbare, datumsunabhängige Vorlagen erstellt werden. Wie bei `Journeys.java` befindet sich auch in dieser Klasse eine statische Methode zum Parsen von HTML.
**[MarkdownConverter.java](src/main/java/pack/MarkdownConverter.java)** | Enthält Methoden, welche für eine gegebene Liste von Fahrten eines Benutzers ein individuelles Markdown-Dokument erstellt. Dieses kann unter einem beliebigen Pfad gespeichert werden.
**[Sessions.java](src/main/java/pack/Sessions.java)** | Enthält Methoden zum Erstellen eines SessionHandlers sowie Speicherort für diese Daten. Die statische Methode `fileSessionHandler` wird in der `App.java` beim Starten des Servers aufgerufen.
**[StoreableHandler.java](src/main/java/pack/StoreableHandler.java)** | Enthält zwei statische Methoden, zum Speichern und zum Laden von Java `ArrayLists` in `.tmp` Dateien. Die Methoden nehmen durch die Anwendung von Wildcards nur `ArrayLists` von Typen, welche `Storeable` implementieren, entgegen.
**[Storeable.java](src/main/java/pack/Storeable.java)** | Ein leeres Interface, welches von Klassen implementiert werden kann. Dadurch werden `ArrayLists` von diesen Klassen bei den Methoden in `StoreableHandler.java` ein gültiges Argument sein.
**[User.java](src/main/java/pack/User.java)** | *Implementiert [Storeable](src/main/java/pack/Storeable.java).* Eine Java-Klasse zum Erstellen von User-Objekten, welche Benutzername, kodiertes Passwort und Anfangskilometerstand als Parameter haben. Enthält ebenfalls eine Methode zum Abgleich von angegebenen Strings und den eigentlichen Daten eines Benutzers.
**[UserManagement.java](src/main/java/pack/UserManagement.java)** | Enthält eine statische Methode zum Registrieren eines neuen Benutzers und eine statische Methode zum Einloggen eines bereits registrierten Benutzers.

<br> 

Der Ordner `resources` beinhaltet den Code für das GUI (`.html` und `.css`) und die beiden JavaScript Dateien zum Senden von HTTP-Requests und Verarbeiten der HTTP-Responses des Servers. <br>
Im `private` Ordner befinden sich diese drei Bausteine für die eigentliche Fahrtenbuch-Ansicht und im `public` Ordner für das Login-und Registriersystem.



