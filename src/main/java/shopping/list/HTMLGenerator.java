package shopping.list;

import java.util.ArrayList;

public class HTMLGenerator {

    static int Counter = 1;

    static Integer last;

    public static String getListHTML() {
        StringBuilder listString = new StringBuilder();

        if(last != null) {
            listString.append(generateListHTML(last));
            last = null;
            ListManager.addList(Counter);
            Counter++;
            return listString.toString();
        }
        if(Counter < 5) {
            listString.append(generateListHTML(Counter));
            ListManager.addList(Counter);
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

    public static void setLastList(int id) {
        last = id;
    }

    public static String getListOpenHTML(int id, String name) {
        StringBuilder openHTML = new StringBuilder();

        openHTML.append(generateOpenHTML(id, name));

        return openHTML.toString();
    }

    public static String getListHTMLbyId(int id) {
        StringBuilder listHTML = new StringBuilder();

        ArrayList<String> articles = ListManager.getArticlesById(id);
        listHTML.append(generateListHTML(id));
        for(int i = 0; i < articles.size(); i++) {
            listHTML.append(generateArticleHTML(articles.get(i)));
        }
        //listHTML.append(generateArticleListHTML(id, articles)); <- die funktion muss noch ausgearbetiet werden
        return listHTML.toString();
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
        return "\t<div class=\"article-box\">"
                + "<p class=\"article\">"+ name +"</p>"
                + "<span id=\"remove\" class=\"remove\">X</span>"
                + "</div>\n";
    }

    private static String generateOpenHTML(int id, String name) {
        return "\t<button id=\""+ id +"\" type=\"button\" class=\"btn btn-secondary open\">" + name +"</button>";
    }

    //@TODO ! add rekursiv function
    private static String generateArticleListHTML(int id, ArrayList<String> articles) {
        String article = "";
        for(int i = 0; i <= articles.size(); i++) {
           article += articles.get(i);
        }
        return article;
    }
}