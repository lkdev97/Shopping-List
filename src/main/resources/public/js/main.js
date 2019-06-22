let addListBtn;
let addArticleBtn;
let shoppingList;
let saveBtn; 
let closeBtn;

//Startpunkt
document.addEventListener('DOMContentLoaded', () => {
    initUI();
    registerEvents();
});

function initUI() {
    addListBtn = document.getElementById("add-list");
    //addArticleBtn = document.getElementById("add-article");
    //shoppingList = document.getElementById("shopping-list");
    //saveBtn = document.getElementById("save");
    
    saveBtn = document.getElementsByClassName("save");
    closeBtn = document.getElementsByClassName("close"); 
    addArticleBtn = document.getElementsByClassName("add-article");
}

function registerEvents() {
    addListBtn.addEventListener('click', addList);

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
    //shoppingList.classList.remove('is--hidden');
    sendToServer('/listhtml').then((response) => {
        response.text().then(function(responseText) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
            registerEvents();
        })
    });
}

function closeList() {
    sendToServer('/close');
    document.getElementById(this.parentElement.id).remove();
}
 

function addArticle() {
    sendToServer('/article').then((response) => {
        response.text().then(function(responseText) {

        })
    });
}

function saveShoppingList() {
    console.log("save");
    sendToServer("/save").then((response) => {
        response.text().then(function(responseText) {

        })
    })
}