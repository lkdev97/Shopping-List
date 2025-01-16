var http = new XMLHttpRequest();
var data = "";

function sendRequestGET(path = '', query = '') {
    http.open('GET', path + '?' + query);
    http.send();
}
