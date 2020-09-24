package edu.eci.arep.tarea4.balanceodecargas;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RoundRobin {
    /**
     * Metodo get
     * @param data informaciÃ³n
     * @param port puerto
     * @throws UnirestException 
     */
    public static String get(String data, int port) throws UnirestException {

        HttpResponse<String> response = null;

        response = Unirest.get("http://ec2-54-224-219-156.compute-1.amazonaws.com:3500" + port + "/results?String=" + data)
                .asString();

        return response.getBody();
    }
}
