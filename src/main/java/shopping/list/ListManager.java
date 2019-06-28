package shopping.list;

import java.util.*;

public class ListManager {

    private static HashMap<Integer, ArrayList<String>> ShoppingList = new HashMap<>();
	
    public static void addList(int id) {
        ArrayList<String> article = new ArrayList<>();
        ShoppingList.put(id, article);
    }

    public static void removeList(int id) {
        ShoppingList.remove(id);    
    }

    public static ArrayList<String> getList(int id) {
        return ShoppingList.get(id);
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
}