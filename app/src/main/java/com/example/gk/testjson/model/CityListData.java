
package com.example.gk.testjson.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityListData {

    @SerializedName("placeCode")
    @Expose
    private String placeCode;
    @SerializedName("placeName")
    @Expose
    private String placeName;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("stateName")
    @Expose
    private String stateName;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("roadDistanceMultiplier")
    @Expose
    private Double roadDistanceMultiplier;
    @SerializedName("cityImagePath")
    @Expose
    private String cityImagePath;
    @SerializedName("cityIntro")
    @Expose
    private String cityIntro;

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getRoadDistanceMultiplier() {
        return roadDistanceMultiplier;
    }

    public void setRoadDistanceMultiplier(Double roadDistanceMultiplier) {
        this.roadDistanceMultiplier = roadDistanceMultiplier;
    }

    public String getCityImagePath() {
        return cityImagePath;
    }

    public void setCityImagePath(String cityImagePath) {
        this.cityImagePath = cityImagePath;
    }

    public String getCityIntro() {
        return cityIntro;
    }

    public void setCityIntro(String cityIntro) {
        this.cityIntro = cityIntro;
    }

}
