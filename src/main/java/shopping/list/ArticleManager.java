package shopping.list;

import java.util.*;

public class ArticleManager {

    private ArrayList<String> article = new ArrayList<>();

    //note: macht sinn aber wie machen!?!?!?????????????ß
    public ArticleManager(String name) {
        this.article.add(name);
    }

    public ArrayList<String> getArticle() {
        return article;
    }

    public void setArticle(String name) {
        article.add(name);
    }

    public void removeArticle(String name) {
        article.remove(name);
    }
}