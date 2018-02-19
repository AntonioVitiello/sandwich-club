package com.udacity.sandwichclub.model;

import java.util.List;

/**
 * Created by Antonio on 19/02/2018.
 */
public class DetailActivityModel {
    private String name;
    private String placeOfOrigin;
    private String description;
    private String ingredients;
    private String alsoKnownAs;

    public DetailActivityModel(Sandwich sandwich) {
        name = sandwich.getName().getMainName();
        placeOfOrigin = sandwich.getPlaceOfOrigin();
        description = sandwich.getDescription();
        ingredients = formatList(sandwich.getIngredients());
        alsoKnownAs = formatList(sandwich.getName().getAlsoKnownAs());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
