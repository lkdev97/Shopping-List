let addListBtn;
let addArticleBtn;
let shoppingList;
let saveBtn; 

//Startpunkt
document.addEventListener('DOMContentLoaded', () => {
    addListBtn = document.getElementById("add-list");
    addArticleBtn = document.getElementById("add-article");
    shoppingList = document.getElementById("shopping-list");
    saveBtn = document.getElementById("save");

    console.log("success");
    
    registerEvents();
});

function registerEvents() {
    addListBtn.addEventListener('click', addList);
    addArticleBtn.addEventListener('click', addArticle);
    saveBtn.addEventListener('click', saveShoppingList);
}

function addList() {
    shoppingList.classList.remove('is--hidden');
}

function addArticle() {

}

function saveShoppingList() {
    console.log("save");
    sendRequestGET('/save', 'listName=' + document.getElementById("list-name").value);
}