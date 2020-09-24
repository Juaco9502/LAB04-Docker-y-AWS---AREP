package edu.eci.arep.tarea4.persistencia;

import java.util.ArrayList;
import java.util.Date;


import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;

public class Conexion {


    public static JSONObject messageLog(String cadena) {
        MongoClient mongo = crearConexion();

        if (mongo != null) {

            MongoDatabase db = mongo.getDatabase("tarea4");

            MongoCollection<Document> table = db.getCollection("Datos");

            Document datos = new Document();
            datos.append("cadena", cadena);
            datos.append("fecha", new Date());
                
            table.insertOne(datos);

            return selectTablas(db, "Datos");


        } else {
            System.out.println("Error: Conexión no establecida");
            return null;
        }
    }

    /**
     * Clase para crear una conexión a MongoDB.
     *
     * @return MongoClient conexión
     */
    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("172.17.0.2", 27017);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongo;
    }


    /**
     * Imprimir en pantalla los trabajadores
     *
     * @param db base de datos
     * @param tabla tabla
     */
    private static JSONObject selectTablas(MongoDatabase db, String tabla) {
        ArrayList<String> listaCadena = new ArrayList<>();
        ArrayList<String> listaFecha = new ArrayList<>();
        MongoCollection<Document> table = db.getCollection(tabla);
        FindIterable<Document> cur = table.find();
        for (Document document : cur) {
            listaCadena.add(document.get("cadena").toString());
            listaFecha.add(document.get("fecha").toString());
        }
        if (listaFecha.size() < 11) {
            return jsonAdd(listaCadena, listaFecha, 0, listaFecha.size());
        } else {
            return jsonAdd(listaCadena, listaFecha, listaFecha.size() - 10, listaFecha.size());
        }

    }

    /**
     * Armar JSON
     *
     * @param listaCadena lista de las cadenas
     * @param listaFecha lista de las fechas
     * @param inicio partida
     * @param fin fin
     * @return json Archivo JSON
     */
    public static JSONObject jsonAdd(ArrayList<String> listaCadena, ArrayList<String> listaFecha, int inicio, int fin) {
        JSONObject json = new JSONObject();
        for (int i = inicio; i < fin; i++) {
            JSONObject datos = new JSONObject();
            datos.append("cadena", listaCadena.get(i));
            datos.append("fecha", listaFecha.get(i));
            json.append("Datos", datos);
        }
        return json;
    }
}
