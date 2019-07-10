var http = new XMLHttpRequest();

function sendRequestGET(path = '', query = '') {
    http.open('GET', path + '?' + query);
    http.send();
}

function sendToServer(target, query = '') {
    return fetch(target, {body: query, method : "POST"}).then(response => response).catch(console.error);
}

function setupWebSocket() {
    console.log("Websocket");
    let ws = new WebSocket ("ws://" + location.hostname + ":" + location.port + "/test");
    ws.onconnect = () => alert("Connection.....");
    ws.onclose = () => alert("Websocket closed...."); 
}