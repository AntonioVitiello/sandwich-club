package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Name;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String LOG_PREFIX = "Antonio";
    private static final String LOG_TAG = LOG_PREFIX + JsonUtils.class.getSimpleName();

    /**
     * For parsing JSON like this:
         {"name":{"mainName":
            "Ham and cheese sandwich",
            "alsoKnownAs":[]},
            "placeOfOrigin":"",
            "description":"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread..",
            "image":"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG",
            "ingredients":["Sliced bread",
                "Cheese",
                "Ham"]}
     * @param json
     * @return
     */
    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichModel = null;

        try {
            // Find the main JSON object
            JSONObject jsonObj = new JSONObject(json);

            // Get name object
            JSONObject nameObj = jsonObj.getJSONObject("name");
            String mainName = nameObj.getString("mainName");
            JSONArray alsoKnownAsJsonArray = nameObj.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsJsonArray.getString(i));
            }
            Name nameModel = new Name(mainName, alsoKnownAsList);

            // Get other content
            String placeOfOrigin = jsonObj.getString("placeOfOrigin");
            String description = jsonObj.getString("description");
            String image = jsonObj.getString("image");
            JSONArray ingredientsJsonArray = jsonObj.getJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredientsList.add(ingredientsJsonArray.getString(i));
            }

            sandwichModel = new Sandwich(nameModel, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwichModel;
    }

}
