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

> Namentlich angelehnt an das alt- und auch neugriechische Wort ὁδός (dt. "Reise", beziehungsweise  "Straße" oder "Weg") soll die Fahrtenbuch App **Odos** eine Plattform bieten, welche es ermöglicht einfach, 
digital und überall ein Fahrtenbuch zu führen. <br> Die Applikation ist auf mehrere Benutzer ausgelegt, daher verfügt sie über ein Registrier- und Einloggsystem. Beim Registriervorgang werden die Zugangsdaten und
der aktuelle Kilometerstand gesetzt. Intern wird das Passwort durch Base64-Kodierung verschlüsselt und mit dem zugehörigen Benutzername gespeichert.  <br> Anschließend kann der Benutzer sein digitales Fahrtenbuch führen, der Fortschritt wird gespeichert und es kann beim nächsten Login dort weitergearbeitet werden, wo der Benutzer aufgehört hat. 
<br> Neben den essenziellen Eckdaten einer Fahrt können diese zusätzlich auch mit Notizen versehen werden. Wichtige, beziehungsweise oft auftretende, Fahrten können als Vorlage gespeichert werden, um das Arbeiten zu erleichtern. 
<br> Möchte der Benutzer seine Fahrtentabelle, entweder zum Einreichen oder für sich selber,
speichern oder drucken, kann er dies mithilfe des integrierten Markdown Dokument-Erstellers machen.


![Screenshot](InActionCollage.jpg)

<br> 

**Hinweise**: 
* Ihr Zugang zum Testen der Anwendung: **Benutzername**: *testuser*, **Passwort**: *testuser*. <br> Die Registrier-Funktion kann selbstverständlich trotzdem genutzt werden, um einen neuen Benutzer zu erstellen. 
* Der JavaScript-Code teilt sich, wie mit Professor Herzberg vereinbart, auf **zwei** Dateien auf: `fahrtenscript.js` im `private`Ordner und `indexscript.js` im `public` Ordner, somit wird sauber zwischen der Login-Ansicht und der Fahrtenbuch-Ansicht getrennt. 
* Bei den Tests wurden mehrere Tests in Methoden gekapselt, um die Tests logisch zu unterteilen.


---



## Beschreibung des Projektaufbaus

### Abgabedateien (LOC)

Verlinkter Dateiname | Dateiart | LOC
---------------------|----------|-----
**[Adress.java](src/main/java/pack/Adress.java)** | Java | 14
**[App.java](src/main/java/pack/App.java)** | Java | 110
**[Coder.java](src/main/java/pack/Coder.java)** | Java | 22
**[CreateFiles.java](src/main/java/pack/CreateFiles.java)** | Java | 25
**[Journey.java](src/main/java/pack/Journey.java)** | Java | 83
**[JourneyTemplate.java](src/main/java/pack/JourneyTemplate.java)** | Java | 39
**[MarkdownConverter.java](src/main/java/pack/MarkdownConverter.java)** | Java | 63
**[Sessions.java](src/main/java/pack/Sessions.java)** | Java | 21
**[StoreableHandler.java](src/main/java/pack/StoreableHandler.java)** | Java | 30
**[Storeable.java](src/main/java/pack/Storeable.java)** | Java | 2
**[User.java](src/main/java/pack/User.java)** | Java | 22
**[UserManagement.java](src/main/java/pack/UserManagement.java)** | Java | 32
**[indexscript.js](src/main/resources/public/indexscript.js)** | JavaScript | 18
**[fahrtenbuchscript.js](src/main/resources/private/fahrtenbuchscript.js)** | JavaScript | 56
**[index.html](src/main/resources/public/index.html)** | HTML | 34
**[fahrtenbuch.html](src/main/resources/private/fahrtenbuch.html)** | HTML | 148
**[indexstyles.css](src/main/resources/public/indexstyles.css)** | CSS | 44
**[fahrtenbuchstyles.css](src/main/resources/private/fahrtenbuchstyles.css)** | CSS | 30
**[hintergrundIndex.jpg](src/main/resources/public/hintergrundIndex.jpg)** | JPG | -
**[hintergrundFahrten.jpg](src/main/resources/private/hintergrundFahrten.jpg)** | JPG | -
 <br> | <br> | *= 793* 


### Testdateien (TST)

Verlinkter Dateiname | Testart | Anzahl der Tests
---------------------|---------|-----------------
**[FahrtenbuchTest.java](src/test/java/FahrtenbuchTest.java)** | JUnit4 | 53

Die Tests werden wie folgt ausgeführt: Im Terminal wird auf der Ebene der `build.gradle` die Eingabe `gradle test` getätigt.



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



