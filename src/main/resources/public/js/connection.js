var http = new XMLHttpRequest();

function sendRequestGET(path = '', query = '') {
    http.open('GET', path + '?' + query);
    http.send();
}
