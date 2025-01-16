function sendToServer(target, query = '') {
    return fetch(target, {body: query, method : "POST"}).then(response => response).catch(console.error);
}
