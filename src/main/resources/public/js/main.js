document.addEventListener('DOMContentLoaded', () => {
    initUI();
    registerEvents();

    window.onload = onLoad;
});

function initUI() {
    addListBtn = document.getElementById("add-list");
    
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
    sendToServer('/article', "name="+ this.previousSibling.value +"&id=" + this.parentElement.id ).then((response) => {
        response.text().then(function(responseText) {
            document.getElementById(me.parentElement.id).insertAdjacentHTML('beforeend', responseText);
            registerEvents();
        })
    });
}

function saveShoppingList() {
    me = this;
    sendToServer('/save', "id=" + this.parentElement.id + "&name=" + this.parentElement.children[1].value).then((response) => {
        response.text().then(function(responseText) {
            me.parentElement.parentElement.insertAdjacentHTML('afterbegin', responseText);
            me.parentElement.remove();
            registerEvents();
        })
    })
}

function removeArticle() {
    me = this;
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

function onLoad() {
    sendToServer("/load").then((response) => {
        response.text().then(function(responseText) {
            document.getElementById("emotion").insertAdjacentHTML('beforeend', responseText);
            registerEvents();
        })
    })
}