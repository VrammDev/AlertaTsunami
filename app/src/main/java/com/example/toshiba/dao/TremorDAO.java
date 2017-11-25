package com.example.toshiba.dao;

import com.example.toshiba.Conexion.conexion_webservice;
import com.example.toshiba.bean.TremorBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by cris_ on 25/11/2017.
 */

public class TremorDAO {
    public ArrayList<TremorBean> ListTremors() {
        ArrayList<TremorBean> list = new ArrayList<TremorBean>();
        String ruta = "http://10.10.0.81/tremor/?op=1";
        try {
            conexion_webservice conexion = new conexion_webservice();

            JSONObject obj1 = conexion.getData(ruta);
            JSONArray arreglo = obj1.getJSONArray("data");
            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject objeto = arreglo.getJSONObject(i+1);
                TremorBean relacion = new TremorBean();
                relacion.setPlace(objeto.getString("place"));
                relacion.setDateTime(objeto.getString("dateTime"));
                relacion.setMagnitude(objeto.getString("magnitude"));
                relacion.setEvaluation(objeto.getString("evaluation"));
                relacion.setReport(objeto.getString("report"));
                list.add(relacion);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
