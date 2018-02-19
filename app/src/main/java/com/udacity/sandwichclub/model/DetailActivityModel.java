package com.udacity.sandwichclub.model;

import java.util.List;

/**
 * Created by Antonio on 19/02/2018.
 */
public class DetailActivityModel {
    private String placeOfOrigin;
    private String description;
    private String ingredients;
    private String alsoKnownAs;

    public DetailActivityModel(Sandwich sandwich) {
        String value = sandwich.getPlaceOfOrigin();
        if(!isBlank(value)) {
            placeOfOrigin = value;
        }

        value = sandwich.getDescription();
        if(!isBlank(value)) {
            description = value;
        }

        value = formatList(sandwich.getIngredients());
        if(!isBlank(value)) {
            ingredients = value;
        }

        value = formatList(sandwich.getName().getAlsoKnownAs());
        if(!isBlank(value)) {
            alsoKnownAs = value;
        }
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(String alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
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

    private boolean isBlank(String description) {
        return description == null || description.length() == 0;
    }

}
