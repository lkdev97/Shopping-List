/open ListManager.java
/open HTMLGenerator.java


String listId = "list-1";

assert true : "P1 should be Hans";

assert ListManager.splitId(listId) == 1: "splitId should return 1";
int id = ListManager.splitId(listId);
assert !ListManager.listAvailable(id) : "No List should be Available";

ListManager.addList(id);
assert ListManager.listAvailable(id) : "List with Id 1 should be Available";

String article = "Apfel";
assert !ListManager.containsName(id, article) : "List shouldnt contain Apfel";
ListManager.addArticle(id, article);
assert ListManager.containsName(id, article) : "List should contain Apfel";

ListManager.removeArticle(id, article);
assert !ListManager.containsName(id, article) : "List shouldnt contain Apfel";

//This should not effect the List!
ListManager.addList(id);
assert ListManager.getSize(id) == 1 : "List isn't size 1";
//ListManager.removeList(id);

assert false : "Lalala";
assert false : "False + " + ListManager.getSize(id) + "LIST: + " + ListManager.getSize(id);