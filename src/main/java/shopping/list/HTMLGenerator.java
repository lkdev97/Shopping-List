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

    public static String getListHTMLbyId(int id, String name) {
        return generateArticleListHTML(id, ListManager.getArticlesById(id), name);
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
        return "\t<button id=\"" + id + "\" type=\"button\" class=\"btn btn-secondary open\">" + name +"</button>";
    }

    private static String generateArticleListHTML(int id, ArrayList<String> articles, String name) {
        StringBuilder article = new StringBuilder();

        for(int i = 0; i < articles.size(); i++) {
           article.append(getArticleHTML(articles.get(i)));
        }

        return "\t<div id=\"list-"+ id +"\" class=\"shopping-list\">"
                + "<span id=\"close\" class=\"close\">X</span>"
                + "<input id=\"list-name\" value=\" "+ name +"\">"
                + "<input id=\"article\" placeholder=\"Name des Artikels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary add-article\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success save\">Speichern</button>"
                + article.toString()
                + "</div>\n";
    }
}