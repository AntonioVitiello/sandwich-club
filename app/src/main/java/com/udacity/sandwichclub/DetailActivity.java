package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private static final String LOG_PREFIX = "Antonio";
    private static final String LOG_TAG = LOG_PREFIX + DetailActivity.class.getSimpleName();

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private ImageView ingredientsIv;
    private TextView alsoKnownAsTv;
    private TextView ingredientsTv;
    private TextView placeOriginTv;
    private TextView descriptionTv;
    private View descriptionLbl;
    private View placeOriginLbl;
    private View ingredientsLbl;
    private View alsoKnownAsLbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ingredientsIv = findViewById(R.id.image_iv);
        alsoKnownAsLbl = findViewById(R.id.also_known_lbl);
        alsoKnownAsTv = findViewById(R.id.also_known_tv);
        ingredientsLbl = findViewById(R.id.ingredients_lbl);
        ingredientsTv = findViewById(R.id.ingredients_tv);
        placeOriginLbl = findViewById(R.id.origin_lbl);
        placeOriginTv = findViewById(R.id.origin_tv);
        descriptionLbl = findViewById(R.id.description_lbl);
        descriptionTv = findViewById(R.id.description_tv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);
        Log.d(LOG_TAG, "onCreate: sandwich=" + sandwich);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);

    }

    private boolean isBlank(String description) {
        return description == null || description.length() == 0;
    }

    private String formatList(List<String> listItems) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listItems.size(); i++) {
            switch(i){
                case 0:
                    break;
                default:
                    sb.append(String.format("%n"));
            }
            sb.append(" - ").append(listItems.get(i));
        }
        return sb.toString();
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getName().getMainName());

        String description = sandwich.getDescription();
        if(isBlank(description)){
            descriptionLbl.setVisibility(View.GONE);
            descriptionTv.setVisibility(View.GONE);
        } else {
            descriptionTv.setText(description);
        }

        List<String> ingredients = sandwich.getIngredients();
        if(ingredients.size() == 0) {
            ingredientsLbl.setVisibility(View.GONE);
            ingredientsTv.setVisibility(View.GONE);
        } else {
            ingredientsTv.setText(formatList(ingredients));
        }

        String placeOfOrigin = sandwich.getPlaceOfOrigin();
        if(isBlank(placeOfOrigin)) {
            placeOriginLbl.setVisibility(View.GONE);
            placeOriginTv.setVisibility(View.GONE);
        } else {
            placeOriginTv.setText(placeOfOrigin);
        }

        List<String> alsoKnownAs = sandwich.getName().getAlsoKnownAs();
        if(alsoKnownAs.size() == 0) {
            alsoKnownAsLbl.setVisibility(View.GONE);
            alsoKnownAsTv.setVisibility(View.GONE);
        } else {
            alsoKnownAsTv.setText(formatList(alsoKnownAs));
        }
    }

}
