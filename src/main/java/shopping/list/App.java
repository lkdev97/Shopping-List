/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package shopping.list;

import io.javalin.Javalin;



public class App {

    public static void main(String[] args) {
        Javalin app = Javalin.create()
            .enableStaticFiles("/public")
            .start(80);
        
        app.post("/listhtml", ctx -> {
            ctx.result(HTMLGenerator.getListHTML());
        });

        app.get("/close", ctx -> {
            int id = ListManager.splitId(ctx.queryParam("id"));
            HTMLGenerator.setLastList(id);
            HTMLGenerator.undo();
            ListManager.removeList(id);
            //ctx.result(Integer.toString(HTMLGenerator.Counter));
        });

        app.post("/article", ctx -> {
            int id = ListManager.splitId(ctx.formParam("id"));
            String name = ctx.formParam("name");
            if(!ListManager.containsName(id, name)) ctx.result(HTMLGenerator.getArticleHTML(name));
            ListManager.addArticle(id, name);
        });

        app.post("/save", ctx -> {
            int id = ListManager.splitId(ctx.formParam("id"));
            ctx.result(HTMLGenerator.getListOpenHTML(id, ctx.formParam("name")));
        });
 
        app.post("/remove", ctx -> {
            HTMLGenerator.undo();
            ListManager.removeArticle(ListManager.splitId(ctx.formParam("id")), ctx.formParam("name"));
        });

        app.post("/open", ctx -> {
            //ctx.result(ListManager.getHTML(Integer.parseInt(ctx.formParam("id"))));
            ctx.result(HTMLGenerator.getListHTMLbyId(Integer.parseInt(ctx.formParam("id")), ctx.formParam("name")));
        });
    }
}
