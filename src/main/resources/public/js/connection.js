var http = new XMLHttpRequest();

function sendRequestGET(path = '', query = '') {
    http.open('GET', path + '?' + query);
    http.send();
}

function sendtoServer(target, data = {}) {
    return fetch(target, { method : "GET"}).then(response => response).catch(console.error);
}