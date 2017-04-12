package test.farhan.cleanarchitecture.model;

import com.google.gson.annotations.SerializedName;



public class ApiResponseModel {

    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String full_name;
    @SerializedName("owner")
    private OwnerModel ownerModel;
    @SerializedName("size")
    private int size;
    @SerializedName("description")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public OwnerModel getOwnerModel() {
        return ownerModel;
    }

    public void setOwnerModel(OwnerModel ownerModel) {
        this.ownerModel = ownerModel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
