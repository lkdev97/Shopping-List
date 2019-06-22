package shopping.list;

public class HTMLGenerator {

    static int Counter = 1;

    public static String getListHTML() {
        StringBuilder listString = new StringBuilder();

        if(Counter < 5) {
            listString.append(generateHTML());
            Counter++;
        };

        return listString.toString();
    }

    public static void undo() {
        Counter--;
    }

    private static String generateHTML() {
        System.out.println("Mein Counter " + Counter);
        return "\t<div id=\"shopping-list list-"+ Counter +"\" class=\"shopping-list\">"
                + "<span id=\"close\">X</span>"
                + "<input id=\"list-name\" placeholder=\"Name des Einkaufszettels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success\">Speichern</button>"
                + "</div>\n";
    }
}