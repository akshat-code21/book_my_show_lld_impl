package org.example.entity;

public class City {
    private String id;
    private String cityName;

    public City(String id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
