package test.farhan.cleanarchitecture.model;

import com.google.gson.annotations.SerializedName;


public class OwnerModel {

    @SerializedName("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
