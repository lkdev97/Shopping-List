package shopping.list;

public class HTMLGenerator {

    static int Counter = 1;

    public static String getListHTML() {
        StringBuilder listString = new StringBuilder();

        if(Counter < 5) {
            listString.append(generateListHTML());
            Counter++;
        };

        return listString.toString();
    }

    public static void undo() {
        Counter--;
    }

    public static String getArticleHTML() {
        StringBuilder articleHTML = new StringBuilder();

        articleHTML.append(generateArticleHTML());

        return articleHTML.toString();
    }

    private static String generateListHTML() {
        return "\t<div id=\"list-"+ Counter +"\" class=\"shopping-list\">"
                + "<span id=\"close\" class=\"close\">X</span>"
                + "<input id=\"list-name\" placeholder=\"Name des Einkaufszettels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary add-article\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success save\">Speichern</button>"
                + "</div>\n";
    }

    private static String generateArticleHTML() {
        return "\t<input>";
    }
}