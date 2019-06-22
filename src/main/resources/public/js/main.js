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
    addArticleBtn = document.getElementById("add-article");
    shoppingList = document.getElementById("shopping-list");
    saveBtn = document.getElementById("save");
    closeBtn = document.getElementById("close");
}

function registerEvents() {
    addListBtn.addEventListener('click', addList);
    addArticleBtn.addEventListener('click', addArticle);
    saveBtn.addEventListener('click', saveShoppingList);
    closeBtn.addEventListener('click', closeList);
}

function addList() {
    // shoppingList.classList.remove('is--hidden');
    sendToServer('/listhtml').then((response) => {
        response.text().then(function(responseText) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
        })
    });
}

function closeList() {
    sendToServer('/close').then((response) => {
        response.text().then(function(responseText) {
            //Divs hören nicht auf events nachdem hinzufügen und findet id nicht in document!!!
            document.getElementById("list-" + responseText).remove();
        })
    });
}
 

function addArticle() {
    sendToServer('')
}

function saveShoppingList() {
    console.log("save");
    sendRequestGET('/save', 'listName=' + document.getElementById("list-name").value);
}