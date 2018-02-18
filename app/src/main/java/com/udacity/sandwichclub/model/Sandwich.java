package com.udacity.sandwichclub.model;

import java.util.List;

/**
 * For parsing JSON like this:
 {"name":{"mainName":
    "Ham and cheese sandwich",
    "alsoKnownAs":[]},
 "placeOfOrigin":"",
 "description":"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce,tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.",
 "image":"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG",
 "ingredients":["Sliced bread",
    "Cheese","Ham"]}
 */
public class Sandwich {

    private Name name;
    private String placeOfOrigin;
    private String description;
    private String image;
    private List<String> ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwich() {
    }

    public Sandwich(Name name, String placeOfOrigin, String description, String image, List<String> ingredients) {
        this.name = name;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

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
