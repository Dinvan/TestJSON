
package com.example.gk.testjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ToDoAttractionsList {

    @SerializedName("attractionId")
    @Expose
    private Integer attractionId;
    @SerializedName("placeCode")
    @Expose
    private String placeCode;
    @SerializedName("attractionName")
    @Expose
    private String attractionName;
    @SerializedName("attractionImageURL")
    @Expose
    private String attractionImageURL;
    @SerializedName("attractionsShortText")
    @Expose
    private String attractionsShortText;
    @SerializedName("attractionOpenTime")
    @Expose
    private String attractionOpenTime;
    @SerializedName("attractionCost")
    @Expose
    private String attractionCost;
    @SerializedName("attractionIdealTime")
    @Expose
    private String attractionIdealTime;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;

    public Integer getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(Integer attractionId) {
        this.attractionId = attractionId;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAttractionImageURL() {
        return attractionImageURL;
    }

    public void setAttractionImageURL(String attractionImageURL) {
        this.attractionImageURL = attractionImageURL;
    }

    public String getAttractionsShortText() {
        return attractionsShortText;
    }

    public void setAttractionsShortText(String attractionsShortText) {
        this.attractionsShortText = attractionsShortText;
    }

    public String getAttractionOpenTime() {
        return attractionOpenTime;
    }

    public void setAttractionOpenTime(String attractionOpenTime) {
        this.attractionOpenTime = attractionOpenTime;
    }

    public String getAttractionCost() {
        return attractionCost;
    }

    public void setAttractionCost(String attractionCost) {
        this.attractionCost = attractionCost;
    }

    public String getAttractionIdealTime() {
        return attractionIdealTime;
    }

    public void setAttractionIdealTime(String attractionIdealTime) {
        this.attractionIdealTime = attractionIdealTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
