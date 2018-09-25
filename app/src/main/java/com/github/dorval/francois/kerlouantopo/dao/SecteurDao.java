package com.github.dorval.francois.kerlouantopo.dao;

import android.app.Activity;
import android.util.Log;

import com.github.dorval.francois.kerlouantopo.model.voie.Cotation;
import com.github.dorval.francois.kerlouantopo.model.voie.Secteur;
import com.github.dorval.francois.kerlouantopo.model.voie.Voie;
import com.github.dorval.francois.kerlouantopo.util.JsonFileLoader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecteurDao {

    private static String SECTEUR_DIR = "secteurs";
    private static String SECTEUR_FILE = "secteur.json";




    /**
     *
     * @param activity
     * @param id
     * @return
     * @throws Exception
     */
    public Secteur getSecteur(Activity activity, Secteur.ID id) throws Exception {
        JSONObject jsonObject = JsonFileLoader.loadJSONFromAsset(activity, SECTEUR_DIR + "/" + id+"/"+SECTEUR_FILE);

        Gson gson = new GsonBuilder().create();
        Secteur sec = gson.fromJson(jsonObject.toString(), Secteur.class);
        relocateImages(SECTEUR_DIR + "/" + id+"/", sec);
        Log.i(this.getClass().getName(), "sec "+sec);
        return sec;

    }

    /**
     * ajout d'un préfixe
     * @param prefix
     * @param sec
     */
    private void relocateImages(String prefix, Secteur sec) {
        if (StringUtils.isNotEmpty(sec.getMap())){
            sec.setMap(prefix+sec.getMap());
        }
        if (sec.getVoies()!=null){
            for (int i = 0; i < sec.getVoies().size(); i++) {
                Voie voie = sec.getVoies().get(i);
                if (StringUtils.isNotEmpty(voie.getPhoto())){
                    voie.setPhoto(prefix+voie.getPhoto());
                }
            }
        }

    }

    /**
     *
     * @param jsonArray
     * @return
     * @throws JSONException
     */
    private List<Voie> getVoies(JSONArray jsonArray) throws JSONException {
        List<Voie> result = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            result.add(getVoie(jsonArray.getJSONObject(i)));
        }
        return result;
    }

    private Voie getVoie(JSONObject jsonObject) {

        Gson gson = new GsonBuilder().create();
        Voie voie = gson.fromJson(jsonObject.toString(), Voie.class);
        return voie;
    }
}
