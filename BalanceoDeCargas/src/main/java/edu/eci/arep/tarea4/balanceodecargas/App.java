package edu.eci.arep.tarea4.balanceodecargas;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class App {

    private static int i = 0;

    /**
     * Metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        staticFiles.location("/static");
        port(getPort());
        get("/inputdata", (req, res) -> {
            res.redirect("/index.html");
            return null;
        });
        get("/results", (req, res) -> resultsPage(req, res));
    }

    /**
     * Resultados
     * @param req solicitud
     * @param res respuesta
     * @return objeto JSON
     * @throws UnirestException 
     */
    private static JSONObject resultsPage(Request req, Response res) throws UnirestException {
        System.out.println(req.queryParams("String"));

        i = (i > 2) ? 0 : i;

        JSONObject jsonObject = new JSONObject(RoundRobin.get(req.queryParams("String"), i));
        i++;
        return jsonObject;
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
