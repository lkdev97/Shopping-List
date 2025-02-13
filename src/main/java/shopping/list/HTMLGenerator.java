package shopping.list;

import java.util.ArrayList;

public class HTMLGenerator {

    public static String getListHTML(String name) {
        StringBuilder listString = new StringBuilder();

        listString.append(generateListHTML(ListManager.getLastSetId(), name));

        return listString.toString();
    }

    public static String getArticleHTML(String name) {
        //if(name.trim().isEmpty() || ListManager.containsName(id, name)) return "";
        StringBuilder articleHTML = new StringBuilder();

        articleHTML.append(generateArticleHTML(name));

        return articleHTML.toString();
    }

    public static String getListOpenHTML(int id, String name) {
        StringBuilder openHTML = new StringBuilder();

        openHTML.append(generateOpenHTML(id, name));

        return openHTML.toString();
    }

    public static String getListHTMLbyId(int id, String name) {
        return generateArticleListHTML(id, ListManager.getArticlesById(id), name);
    }

    public static String getListHTMLbySession(ArrayList<String> articles, int id, String name) {
        StringBuilder sessionHTML = new StringBuilder();
        
        sessionHTML.append(generateArticleListHTML(id, articles, name));

        return sessionHTML.toString();
    }

    private static String generateListHTML(int id, String name) {
        return "\t<div id=\"list-"+ id +"\" class=\"shopping-list\">"
                + "<span id=\"close\" class=\"close\">X</span>"
                + "<input id=\"list-name\" placeholder=\"Name des Einkaufszettels\" value=\""+name+"\">"
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
       return "\t<button id=\""+ id +"\" type=\"button\" class=\"btn btn-secondary open\">"+ name +"</button>";
    }

    private static String generateArticleListHTML(int id, ArrayList<String> articles, String name) {
        StringBuilder article = new StringBuilder();

        for(int i = 0; i < articles.size(); i++) {
           article.append(getArticleHTML(articles.get(i)));
        }

        return "\t<div id=\"list-"+ id +"\" class=\"shopping-list\">"
                + "<span id=\"close\" class=\"close\">X</span>"
                + "<input id=\"list-name\" value=\""+ name +"\" placeholder=\"Name des Einkaufszettels\">"
                + "<input id=\"article\" placeholder=\"Name des Artikels\">"
                + "<button id=\"add-article\" type=\"button\" class=\"btn btn-secondary add-article\">+</button>"
                + "<button id=\"save\" type=\"button\" class=\"btn btn-success save\">Speichern</button>"
                + article.toString()
                + "</div>\n";
    }
}