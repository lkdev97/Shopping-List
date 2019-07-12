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
    - [Dokumentation des implementierten WebAPIs](#Dokumentation-des-implementierten-WebAPIs)
        - [1. Allgemein](#1-Allgemein)
        - [2. Laden des Einkaufszettels (listhtml)](#2-laden-des-einkaufszettels)
            - [Request](#Request-2)
            - [Response](#Response-2)
        - [3. Artikel zu dem Einkaufszettel hinzufügen](#3-Artikel-zu-dem-Einkaufszettel-hinzufügen)
            - [Request](#Request-3)
            - [Response](#Response-3)
        - [4. Artikel von einem Einkaufszettel entfernen](#4-Artikel-von-einem-Einkaufszettel-entfernen)
            - [Request](#Request-4)
            - [Response](#Response-4)
        - [5. Einkaufszettel schließen ohne zu speichern](#5-Einkaufszettel-schließen-ohne-zu-speichern)
            - [Request](#Request-5)
            - [Response](#Response-5)
        - [6. Einkaufszettel schließen mit speichern](#6-Einkaufszettel-schließen-mit-speichern)
            - [Request](#Request-6)
            - [Response](#Response-6)
        - [7. Einen gespeicherten Einkaufszettel öffnen](#7-Einen-gespeicherten-Einkaufszettel-öffnen)
            - [Request](#Request-7)
            - [Response](#Response-7)
    - [Technischer Anspruch (TA) und Umsetzung der Features](#Technischer-Anspruch-TA-und-Umsetzung-der-Features)
        - [Bootstrap](#Bootstrap)
        - [Session Handling](#Session-Handling)
    - [Quellennachweis](#Quellennachweis)
        - [1. Quellen](#1-Quellen)




## Kurzbeschreibung inkl. Screenshot

>Mittels des Programms kann der Nutzer einen bzw. mehrere digitale Einkaufszettel erstellen. Jedem dieser Einkaufszettel kann man frei einen Namen zuweisen. 
Auserdem kann man jedem Einkaufszettel beliebig viele Artikel zuweisen und nach Belieben auch wieder entfernen, sollte man diesen Artikel erworben haben.
Einkaufszettel kann man speichern und nachträglich erneut öffnen und die dazugehörigen Artikel bearbeiten.
Sollte man alle Einkäufe von einem Einkaufszettel erledigt haben, kann man diesen dann auch wieder komplett entfernen.




![Screenshot](screenshots/list.png)


---



## Beschreibung des Projektaufbaus

### Abgabedateien (LOC)

Verlinkter Dateiname | Dateiart | LOC
---------------------|----------|-----
**[App.java](/src/main/java/shopping/list/App.java)** | Java | 43
**[ListManager.java](/src/main/java/shopping/list/ListManager.java)** | Java | 65
**[HTMLGenerator.java](/src/main/java/shopping/list/HTMLGenerator.java)** | Java | 59
**[Session.java](/src/main/java/shopping/list/Session.java)** | Java | 21
**[connection.js](src/main/resources/public/js/connection.js)** | JavaScript | 3
**[main.js](src/main/resources/public/js/main.js)** | JavaScript | 82
**[index.html](src/main/resources/public/index.html)** | HTML | 37
**[all.css](src/main/resources/public/css/all.css)** | CSS | 2
**[main.css](src/main/resources/public/css/main.css)** | CSS | 58
**[variables.css](src/main/resources/public/css/variables.css)** | CSS | 9
 <br> | <br> | *= 379* 


### Testdateien (TST)

Verlinkter Dateiname | Testart | Anzahl der Tests
---------------------|---------|-----------------
**[ListTest.java](/src/main/java/shopping/list/ListTest.java)** | Asserts | 

Die Tests werden wie folgt ausgeführt: Im Terminal wird auf der Ebene der `ListTest.java` (src/main/java/shopping/list) die Eingabe `jshell -R-ea ListTest.java` getätigt.



### Aufbau der Anwendung 

![Aufbau der Anwendung](screenshots/structure.png)


| Datei | Inhalt |
| ----- | ----- |
**[App.java](/src/main/java/shopping/list/App.java)** | 
**[ListManager.java](/src/main/java/shopping/list/ListManager.java)** | 
**[HTMLGenerator.java](/src/main/java/shopping/list/HTMLGenerator.java)** | 
**[Session.java](/src/main/java/shopping/list/Session.java)** | 
**[connection.js](src/main/resources/public/js/connection.js)** | 
**[main.js](src/main/resources/public/js/main.js)** | 
**[index.html](src/main/resources/public/index.html)** | 
**[all.css](src/main/resources/public/css/all.css)** | 
**[main.css](src/main/resources/public/css/main.css)** | 
**[variables.css](src/main/resources/public/css/variables.css)** | 

<br> 

Der Ordner `resources` beinhaltet den Code für das GUI (`.html` und `.css`) und die beiden JavaScript Dateien zum Senden von HTTP-Requests und Verarbeiten der HTTP-Responses des Servers. <br>

## Dokumentation des implementierten WebAPIs

### 1. Allgemein

Für die implementierten WebAPIs wurde zum einen JavaScript für die Request
und Javascript für die Response genommen. Die Funktion für die Javascript Request findet man somit in der `connection.js` die dann in der `main.js` verwendet werden.
Für die Request wurde die Methode `POST` verwendet.

In Java werden die Request über Javalin `app.post` angesprochen.

Über die `connection.js` wird ein Request wie folgt definiert:
```javascript
function sendToServer(target, query = '') {
    return fetch(target, {body: query, method : "POST"}).then(response => response).catch(console.error);
}
```

### 2. Laden des Einkaufszettels (listhtml)
In der `main.js` wird in der Zeile 37 über die Funktion `sendToServer` ein Request mit dem Namen "listhtml" gestellt welcher den Namen des Zettels an den Server `App.java` übergibt
und als Response von dem Server das HTML von dem Einkaufszettel erwartet.


##### Request

```javascript
sendToServer('/listhtml', "name=" + listName).then((response) => {
    response.text().then(function(responseText) {
        document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
        registerEvents();
    })
});
```

##### Response

```java
app.post("/listhtml", ctx -> {
    ctx.result(ListManager.addList(ctx.formParam("name")));
});
```

### 3. Artikel zu dem Einkaufszettel hinzufügen

##### Request

```javascript
me = this;
sendToServer('/article', "name="+ this.previousSibling.value +"&id=" + this.parentElement.id ).then((response) => {
    response.text().then(function(responseText) {
        document.getElementById(me.parentElement.id).insertAdjacentHTML('beforeend', responseText);
        registerEvents();
    })
});
```

##### Response

```java
app.post("/article", ctx -> {
    int id = ListManager.splitId(ctx.formParam("id"));
    String name = ctx.formParam("name");
    ctx.result(ListManager.addArticle(id, name));
});
```

### 4. Artikel von einem Einkaufszettel entfernen

##### Request

```javascript
me = this;
sendToServer('/remove', "id=" + this.parentElement.parentElement.id + "&name=" + this.previousSibling.firstChild.data).then((response) => {
    me.parentElement.remove();
})
```

##### Response

```java
app.post("/remove", ctx -> {
    ListManager.removeArticle(ListManager.splitId(ctx.formParam("id")), ctx.formParam("name"));
});
```

### 5. Einkaufszettel schließen ohne zu speichern

##### Request

```javascript
sendToServer('/close', "id=" + this.parentElement.id);
document.getElementById(this.parentElement.id).remove();
```

##### Response

```java
app.post("/close", ctx -> {
    int id = ListManager.splitId(ctx.formParam("id"));
    ListManager.removeList(id);
});
```

### 6. Einkaufszettel schließen mit speichern

##### Request

```javascript
me = this;
sendToServer('/save', "id=" + this.parentElement.id + "&name=" + this.parentElement.children[1].value).then((response) => {
    response.text().then(function(responseText) {
        me.parentElement.parentElement.insertAdjacentHTML('afterbegin', responseText);
        me.parentElement.remove();
        registerEvents();
    })
})
```

##### Response

```java
app.post("/save", ctx -> {
    int id = ListManager.splitId(ctx.formParam("id"));
    ctx.result(HTMLGenerator.getListOpenHTML(id, ctx.formParam("name")));
    ctx.sessionAttribute("list", ListManager.getArticlesById(id));
    ctx.sessionAttribute("id", id);
    ctx.sessionAttribute("name", ctx.formParam("name"));
});
```

### 7. Einen gespeicherten Einkaufszettel öffnen

##### Request

```javascript
me = this;
sendToServer('/open', "id=" + this.id + "&name=" + this.innerHTML).then((response) => {
    response.text().then(function(responseText) {
        document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
        me.remove();
        registerEvents();
    })
})
```

##### Response

```java
app.post("/open", ctx -> {
    ctx.result(HTMLGenerator.getListHTMLbyId(Integer.parseInt(ctx.formParam("id")), ctx.formParam("name")));
});
```



## Technischer Anspruch (TA) und Umsetzung der Features

Ich habe folgende Features verwendet. Die verlinkte Datei zeigt beispielhaft den Einsatz dieses Features in den angegebenen Zeilen im Quellcode.

1. Bootstrap. **[index.html](src/main/resources/public/index.html)** (13-41)
2. Session Handling **[Session.java](src/main/java/public/Session.java)**

<Ihre Dokumentation zu den Features>


## Quellennachweis
### Quellen

<br> https://www.w3schools.com/ <br>
https://stackoverflow.com/ <br>
<br> https://git.thm.de/dhzb87/JbX <br>
https://javalin.io/documentation <br>
https://javalin.io/tutorials/ <br>
<br>https://moodle.thm.de/course/view.php?id=4223 <br>
http://openbook.rheinwerk-verlag.de/javainsel/ <br>
**[Session.java](/src/main/java/shopping/list/Session.java)**  https://javalin.io/tutorials/jetty-session-handling-java






