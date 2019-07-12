function sendToServer(target, query = '') {
    return fetch(target, {body: query, method : "POST"}).then(response => response).catch(console.error);
}

/*function setupWebSocket() {
    console.log("Websocket");
    let ws = new WebSocket ("ws://" + location.hostname + ":" + location.port + "/test");
    ws.onconnect = () => alert("Connection.....");
    ws.onerror = () => alert("Es ist ein Fehler bei der Übertragung aufgetreten.")
    ws.onclose = () => alert("Websocket closed...."); 
}*/