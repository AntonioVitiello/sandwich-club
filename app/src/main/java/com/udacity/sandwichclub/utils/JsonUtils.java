package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udacity.sandwichclub.model.Sandwich;

public class JsonUtils {
    private static final String LOG_PREFIX = "Antonio";
    private static final String LOG_TAG = LOG_PREFIX + JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
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
