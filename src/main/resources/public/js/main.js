let addListBtn;
let addArticleBtn;
let shoppingList;
let saveBtn; 

//Startpunkt
document.addEventListener('DOMContentLoaded', () => {
    console.log("success");
    
    initUI();
    registerEvents();
});

function initUI() {
    addListBtn = document.getElementById("add-list");
    addArticleBtn = document.getElementById("add-article");
    shoppingList = document.getElementById("shopping-list");
    saveBtn = document.getElementById("save");
}

function registerEvents() {
    addListBtn.addEventListener('click', addList);
    addArticleBtn.addEventListener('click', addArticle);
    saveBtn.addEventListener('click', saveShoppingList);
    http.onreadystatechange = () => {
        if(http.readyState === 4) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', http.responseText);
        }
    }
}

function addList(callback) {
    shoppingList.classList.remove('is--hidden');
    sendRequestGET('/listhtml');
    console.log(callback);
    if(typeof(callback) === "function") callback(document.getElementById("emotion").insertAdjacentHTML('beforeend', http.responseText));
}

function addArticle() {

}

function saveShoppingList() {
    console.log("save");
    sendRequestGET('/save', 'listName=' + document.getElementById("list-name").value);
}