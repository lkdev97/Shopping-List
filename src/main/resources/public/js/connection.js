var http = new XMLHttpRequest();

function sendRequestGET(path = '', query = '') {
    http.open('GET', path + '?' + query);
    http.send();
}

function sendToServer(target, query = '') {
    return fetch(target, {body: query, method : "POST"}).then(response => response).catch(console.error);
}

http.onreadystatechange = function() {
    if(this.readyState == 4 && this.status == 200) {
        console.log(this);
    }
}