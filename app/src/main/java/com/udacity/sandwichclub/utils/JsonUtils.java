package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = null;

        List<String> ingredientsList = new ArrayList<>();
        List<String> alsoKnownAsList = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(json);
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");

            JSONArray jsonArray = jsonObject.getJSONArray("ingredients");
            for (int i = 0 ; i < jsonArray.length() ; i++){
                ingredientsList.add(jsonArray.getString(i));
            }

            JSONObject namesObject = jsonObject.getJSONObject("name");
            String mainName = namesObject.getString("mainName");

            JSONArray alsoKnownAs =namesObject.getJSONArray("alsoKnownAs");
            for (int i = 0 ; i < alsoKnownAs.length() ; i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }
            
            sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}
