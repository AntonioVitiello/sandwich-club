package com.udacity.sandwichclub.model_2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Antonio on 17/02/2018.
 */

class Name {
    @SerializedName("mainName")
    @Expose
    private String mainName;
    @SerializedName("alsoKnownAs")
    @Expose
    private List<Object> alsoKnownAs = null;

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public List<Object> getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(List<Object> alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

}
