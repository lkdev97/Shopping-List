package shopping.list;

public class ListManager {

    public static void addList(String name) {

    }

    public static void removeList(String name) {

    }

    public static String getList(String name) {
        String List = "Todo";
        
        
        return List;
    }

    public static String splitId(String id) {
        String[] tmp = id.split("-");
        return tmp[1];
    }

    public static boolean listAvailable(String name) {

        return true;
    }
}