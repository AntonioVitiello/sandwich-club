package com.udacity.sandwichclub.model_2;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Antonio on 17/02/2018.
 */

public class Sandwich {
    @SerializedName("name")
    private Name name;
    @SerializedName("placeOfOrigin")
    private String placeOfOrigin;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("ingredients")
    private List<String> ingredients = null;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

}
