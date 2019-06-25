package shopping.list;

public class HTMLGenerator {

    static int Counter = 1;

    static Integer last;

    public static String getListHTML() {
        StringBuilder listString = new StringBuilder();

        if(last != null) {
            listString.append(generateListHTML(last));
            last = null;
            Counter++;
            return listString.toString();
        }
        if(Counter < 5) {
            listString.append(generateListHTML(Counter));
            Counter++;
        };

        return listString.toString();
    }

    public static void undo() {
        Counter--;
    }

    public static String getArticleHTML(String name) {
        StringBuilder articleHTML = new StringBuilder();

        articleHTML.append(generateArticleHTML(name));

        return articleHTML.toString();
    }

    public static void setLastList(String id) {
        last = Integer.parseInt(ListManager.splitId(id));
    }

    private static String generateListHTML(int id) {
        return "\t<div id=\"list-"+ id +"\" class=\"shopping-list\">"
                + "<span id=\"close\" class=\"close\">X</span>"
                + "<input id=\"list-name\" placeholder=\"Name des Einkaufszettels\">"
                + "<input id=\"article\" placeholder=\"Name des Artikels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary add-article\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success save\">Speichern</button>"
                + "</div>\n";
    }

    private static String generateArticleHTML(String name) {
        return "\t<p class=\"article\">"+  name +"</p>";
    }
}