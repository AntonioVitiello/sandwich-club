package com.udacity.sandwichclub;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.databinding.ActivityDetailBinding;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private static final String LOG_PREFIX = "Antonio";
    private static final String LOG_TAG = LOG_PREFIX + DetailActivity.class.getSimpleName();

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;
    private ActivityDetailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

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
                .into(mBinding.imageIv);

        setTitle(sandwich.getName().getMainName());

        String description = sandwich.getDescription();
        if(isBlank(description)){
            mBinding.descriptionLbl.setVisibility(View.GONE);
            mBinding.descriptionTv.setVisibility(View.GONE);
        } else {
            mBinding.descriptionTv.setText(description);
        }

        List<String> ingredients = sandwich.getIngredients();
        if(ingredients.size() == 0) {
            mBinding.alsoKnownLbl.setVisibility(View.GONE);
            mBinding.ingredientsTv.setVisibility(View.GONE);
        } else {
            mBinding.ingredientsTv.setText(formatList(ingredients));
        }

        String placeOfOrigin = sandwich.getPlaceOfOrigin();
        if(isBlank(placeOfOrigin)) {
            mBinding.originLbl.setVisibility(View.GONE);
            mBinding.originTv.setVisibility(View.GONE);
        } else {
            mBinding.originTv.setText(placeOfOrigin);
        }

        List<String> alsoKnownAs = sandwich.getName().getAlsoKnownAs();
        if(alsoKnownAs.size() == 0) {
            mBinding.alsoKnownLbl.setVisibility(View.GONE);
            mBinding.alsoKnownTv.setVisibility(View.GONE);
        } else {
            mBinding.alsoKnownTv.setText(formatList(alsoKnownAs));
        }
    }

}
