package com.udacity.sandwichclub.utils;

import com.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.sandwichclub.model.Name;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String LOG_TAG = JsonUtils.class.getSimpleName();

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
            JSONObject nameObj = jsonObj.optJSONObject("name");
            String mainName = nameObj.optString("mainName");
            JSONArray alsoKnownAsJsonArray = nameObj.optJSONArray("alsoKnownAs");
            List<String> alsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJsonArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsJsonArray.optString(i));
            }
            Name nameModel = new Name(mainName, alsoKnownAsList);

            // Get other content
            String placeOfOrigin = jsonObj.optString("placeOfOrigin");
            String description = jsonObj.optString("description");
            String image = jsonObj.optString("image");
            JSONArray ingredientsJsonArray = jsonObj.optJSONArray("ingredients");
            List<String> ingredientsList = new ArrayList<>();
            for (int i = 0; i < ingredientsJsonArray.length(); i++) {
                ingredientsList.add(ingredientsJsonArray.optString(i));
            }

            sandwichModel = new Sandwich(nameModel, placeOfOrigin, description, image, ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwichModel;
    }

    public static Sandwich parseSandwichJsonWithGson(String json) {
        Log.d(LOG_TAG, "parseSandwichJson: json=" + json);
        // Parse JSON String
        Gson gson = new GsonBuilder().create();
        Sandwich sandwich = gson.fromJson(json, Sandwich.class);
        return sandwich;
    }

/*
    public void processGitHubRequestUrl1(String msg) throws IOException {
        Log.d(LOG_TAG, "processGitHubRequest: currentThread = " + Thread.currentThread() + ", url = " + SANDWICH_WIKI_URL);
        HttpURLConnection urlConnection = null;
        try {
            URL myUrl = new URL(SANDWICH_WIKI_URL);
            urlConnection = (HttpURLConnection) myUrl.openConnection();
            InputStream inputStream = urlConnection.getInputStream();

            int responseCode = urlConnection.getResponseCode();
            Log.d(LOG_TAG, "Response Code : " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");

                if (scanner.hasNext()) {
                    String response = scanner.next();

                    Log.d(LOG_TAG, "Response2 : " + response);
                    Gson gson = new GsonBuilder().create();

                    // Parse response
                    Gson gson = new GsonBuilder().create();
                    Sandwich sandwich = gson.fromJson(response, Sandwich.class);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
*/

}
