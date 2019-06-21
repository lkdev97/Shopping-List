package shopping.list;

public class HTMLGenerator {

    public static String getListHTML() {
        StringBuilder listString = new StringBuilder();

        listString.append(generateHTML());
        return listString.toString();
    }

    private static String generateHTML() {

        return "\t<div id=\"shopping-list\" class=\"shopping-list\">"
                + "<input id=\"list-name\" placeholder=\"Name des Einkaufszettels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success\">Speichern</button>"
                + "</div>\n";
    }
}