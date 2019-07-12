package shopping.list;

import java.util.*;

public class ListManager {

    private static HashMap<Integer, ArrayList<String>> ShoppingList = new HashMap<>();

    static int Counter = 5;

    static int lastSetId;
    //private static Map<Integer, String> ShoppingHTML = new HashMap<>();
	
    public static void addList() {
        if(getListSize() < Counter) {
            ArrayList<String> article = new ArrayList<>();
            ShoppingList.put(getNextId(), article);
        }
    }

    public static void removeList(int id) {
        ShoppingList.remove(id);    
    }

    public static HashMap<Integer, ArrayList<String>> getList() {
        return ShoppingList;
    }

    public static int splitId(String id) {
        String[] tmp = id.split("-");
        return Integer.parseInt(tmp[1]);
    }

    public static boolean listAvailable(int id) {
        return ShoppingList.containsKey(id);
    }

    public static boolean containsName(int id, String name) {
        return ShoppingList.get(id).contains(name);
    }

    public static void addArticle(int id, String name) {
        if(!containsName(id, name)) ShoppingList.get(id).add(name);
    }

    public static void removeArticle(int id, String name) {
        ShoppingList.get(id).remove(name);
    }

    public static ArrayList<String> getArticlesById(int id) {
       return ShoppingList.get(id);
    }

    public static int getListSize() {
        return ShoppingList.size();
    }

    public static int getNextId() {
        for(int i = 1; i < Counter; i++) {
            if(ShoppingList.get(i) == null) {
                setLastSetId(i);
                return i;
            }
        } 
        return 0;
    }
    
    public static void setLastSetId(int id) {
        lastSetId = id;
    }

    public static int getLastSetId() {
        return lastSetId;
    }
   /* public static void saveHTMLbyId(int id, String html) {
        ShoppingHTML.put(id, html);
    }

    public static String getHTML(int id) {
        return ShoppingHTML.get(id);
    }*/
}