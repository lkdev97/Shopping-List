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
**[App.java](/src/main/java/shopping/list/App.java)** | Java | 33
**[ListManager.java](/src/main/java/shopping/list/ListManager.java)** | Java | 40
**[HTMLGenerator.java](/src/main/java/shopping/list/HTMLGenerator.java)** | Java | 74
**[connection.js](src/main/resources/public/js/connection.js)** | JavaScript | 3
**[main.js](src/main/resources/public/js/main.js)** | JavaScript | 80
**[index.html](src/main/resources/public/index.html)** | HTML | 45
**[all.css](src/main/resources/public/css/all.css)** | CSS | 2
**[main.css](src/main/resources/public/css/main.css)** | CSS | 56
**[variables.css](src/main/resources/public/css/variables.css)** | CSS | 9
 <br> | <br> | *= 793* 


### Testdateien (TST)

Verlinkter Dateiname | Testart | Anzahl der Tests
---------------------|---------|-----------------
**[ListTest.java](/src/main/java/shopping/list/ListTest.java)** | Asserts | 53

Die Tests werden wie folgt ausgeführt: Im Terminal wird auf der Ebene der `ListTest.java` (src/main/java/shopping/list) die Eingabe `jshell -R-ea ListTest.java` getätigt.



### Aufbau der Anwendung 

![](FileTree.png)

Der Projektordner `src` teilt sich, wie auch oben anhand des FileTrees veranschaulicht,
in zwei weitere Ordner auf: `main` und `test`. <br> Im `test` Ordner befindet sich eine Datei namens `FahrtenbuchTest.java`, diese enthält alle JUnit4 Tests zum Projekt. Nach Ablauf der Tests wird von Gradle ein Bericht über den Ablauf erstellt, welcher unter dem Pfad: `build/reports/tests/test/index.html` als HTML-Dokument zu finden ist. <br>
Der `main` Ordner enthält den eigentlichen Programmcode der Anwendung im Ordner `java` befinden sich alle `.java` Dateien, der Kern der Anwendung. Die Inhalte aller `.java` Dateien wird in der folgenden Tabelle beschrieben:

<br>


| Datei | Inhalt |
| ----- | ----- |
**[App.java](/src/main/java/shopping/list/App.java)** | LoremIpsum
**[ListManager.java](/src/main/java/shopping/list/ListManager.java)** | LoremIpsum
**[HTMLGenerator.java](/src/main/java/shopping/list/HTMLGenerator.java)** | LoremIpsum
**[connection.js](src/main/resources/public/js/connection.js)** | LoremIpsum
**[main.js](src/main/resources/public/js/main.js)** | LoremIpsum
**[index.html](src/main/resources/public/index.html)** | LoremIpsum
**[all.css](src/main/resources/public/css/all.css)** | LoremIpsum
**[main.css](src/main/resources/public/css/main.css)** | LoremIpsum
**[variables.css](src/main/resources/public/css/variables.css)** | LoremIpsum

<br> 

Der Ordner `resources` beinhaltet den Code für das GUI (`.html` und `.css`) und die beiden JavaScript Dateien zum Senden von HTTP-Requests und Verarbeiten der HTTP-Responses des Servers. <br>

## Technischer Anspruch (TA) und Umsetzung der Features

Ich habe folgende Features verwendet. Die verlinkte Datei zeigt beispielhaft den Einsatz dieses Features in den angegebenen Zeilen im Quellcode.

1. Bootstrap. **[index.html](src/main/resources/public/index.html)** (13-41)

<Ihre Dokumentation zu den Features>


## Quellennachweis
### Allgemeine Quellen

<br> https://www.w3schools.com/ <br>
https://stackoverflow.com/ <br>
<br> https://git.thm.de/dhzb87/JbX <br>
https://javalin.io/documentation <br>
https://javalin.io/tutorials/ <br>
<br>https://moodle.thm.de/course/view.php?id=4223 <br>
http://openbook.rheinwerk-verlag.de/javainsel/





