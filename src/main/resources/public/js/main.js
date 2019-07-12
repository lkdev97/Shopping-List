/*let addListBtn;
let addArticleBtn;
let shoppingList;
let saveBtn; 
let closeBtn;
let removeBtn;*/

//Startpunkt
document.addEventListener('DOMContentLoaded', () => {
    initUI();
    registerEvents();

   // window.onload = setupWebSocket;
});

function initUI() {
    addListBtn = document.getElementById("add-list");
    //addArticleBtn = document.getElementById("add-article");
    //shoppingList = document.getElementById("shopping-list");
    //saveBtn = document.getElementById("save");
    
    removeBtn = document.getElementsByClassName("remove");
    saveBtn = document.getElementsByClassName("save");
    closeBtn = document.getElementsByClassName("close"); 
    addArticleBtn = document.getElementsByClassName("add-article");
    openBtn = document.getElementsByClassName("open");
}

function registerEvents() {
    addListBtn.addEventListener('click', addList);

    registerHelper(openBtn, "click", openList);
    registerHelper(removeBtn, "click", removeArticle);
    registerHelper(closeBtn, "click", closeList);
    registerHelper(saveBtn, "click", saveShoppingList);
    registerHelper(addArticleBtn, "click", addArticle);
}

function registerHelper(el, event, fnc) {
    for(let i = 0; i < el.length; i++) {
        el[i].addEventListener(event, fnc);
    }
}

function addList() {
    listName = prompt("Geben Sie den Namen von ihrem Einkaufszettel an!");
    sendToServer('/listhtml', "name=" + listName).then((response) => {
        response.text().then(function(responseText) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
            registerEvents();
        })
    });
}

function closeList() {
    sendToServer('/close', "id=" + this.parentElement.id);
    document.getElementById(this.parentElement.id).remove();
}
 

function addArticle() {
    me = this;
    //console.log(this.previousSibling.value);
    //TODO add popup? to add article
    sendToServer('/article', "name="+ this.previousSibling.value +"&id=" + this.parentElement.id ).then((response) => {
        response.text().then(function(responseText) {
            document.getElementById(me.parentElement.id).insertAdjacentHTML('beforeend', responseText);
            registerEvents();
        })
    });
}

function saveShoppingList() {
    me = this;
    //array to string !
    //sendRequestGET("/save", "id=" + this.parentElement.id + "&test=test");
    sendToServer('/save', "id=" + this.parentElement.id + "&name=" + this.parentElement.children[1].value).then((response) => {
        response.text().then(function(responseText) {
            me.parentElement.parentElement.insertAdjacentHTML('afterbegin', responseText);
            me.parentElement.remove();
            registerEvents();
            // add something to open the List again ... button ? dropdown? id should be enough to get list with listManager
            // List.get(id)
            // add function in HTMLGenerator.. GenerateListHTMLbyList
        })
    })
}

function removeArticle() {
    me = this;
    // Todo Counter wieder reseten ! 
    // nach remove wird keine liste mehr mit der id erzeugt..so lassen ? dann halt beim öffnen
    sendToServer('/remove', "id=" + this.parentElement.parentElement.id + "&name=" + this.previousSibling.firstChild.data).then((response) => {
        me.parentElement.remove();
    })
}

function openList() {
    me = this;
    sendToServer('/open', "id=" + this.id + "&name=" + this.innerHTML).then((response) => {
        response.text().then(function(responseText) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
            me.remove();
            registerEvents();
        })
    })
}