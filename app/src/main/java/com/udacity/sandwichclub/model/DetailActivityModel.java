package com.udacity.sandwichclub.model;

import java.util.List;

/**
 * Created by Antonio on 19/02/2018.
 */
public class DetailActivityModel {
    private final Sandwich mSandwich;

    public DetailActivityModel(Sandwich sandwich) {
        this.mSandwich = sandwich;
    }

    public String getPlaceOfOrigin() {
        return checkString(mSandwich.getPlaceOfOrigin());
    }

    public String getDescription() {
        return checkString(mSandwich.getDescription());
    }

    public String getIngredients() {
        String ingredients = formatList(mSandwich.getIngredients());
        return checkString(ingredients);
    }

    public String getAlsoKnownAs() {
        String alsoKnownAs = formatList(mSandwich.getName().getAlsoKnownAs());
        return checkString(alsoKnownAs);
    }

    private String formatList(List<String> listItems) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listItems.size(); i++) {
            if(i > 0){
                sb.append(String.format("%n")); // Newline in every SO
            }
            if(listItems.size() > 1){
                sb.append(" - ");
            }
            sb.append(listItems.get(i));
        }
        return sb.toString();
    }

    private String checkString(String aString) {
        if(aString == null || aString.length() > 0){
            return aString;
        } else {
            return null;
        }
    }

}
