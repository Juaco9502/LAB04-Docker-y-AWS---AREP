package edu.eci.arep.tarea4;

import edu.eci.arep.tarea4.persistencia.Conexion;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        port(getPort());

        get("/results", (req, res) -> resultsPage(req, res));
    }


    private static JSONObject resultsPage(Request req, Response res) {
        System.out.println(req.queryParams("String"));
        Conexion conexion = new Conexion();
        return conexion.messageLog(req.queryParams("String"));
    }


    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     * <p>
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
