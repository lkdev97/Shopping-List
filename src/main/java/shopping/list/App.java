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
        
        app.get("/listhtml", ctx -> {
            ctx.result(HTMLGenerator.getListHTML());
        });
    }
}
