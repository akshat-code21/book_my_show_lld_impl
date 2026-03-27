package org.example.repository;

import org.example.entity.City;
import org.example.entity.Theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheatreRepository {
    private static Map<City, List<Theatre>> cityToTheatreMapping;

    public TheatreRepository(Map<City, List<Theatre>> cityToTheatreMapping) {
        this.cityToTheatreMapping = cityToTheatreMapping;
    }

    public Map<City, List<Theatre>> getCityToTheatreMapping() {
        return cityToTheatreMapping;
    }

    public void setCityToTheatreMapping(Map<City, List<Theatre>> cityToTheatreMapping) {
        this.cityToTheatreMapping = cityToTheatreMapping;
    }

    public void addTheatreToRepo(City c,Theatre t){
        if(!cityToTheatreMapping.containsKey(c)){
            cityToTheatreMapping.put(c,new ArrayList<>());
        }

        cityToTheatreMapping.get(c).add(t);
    }

    public List<Theatre> getTheatres(City c){
        return cityToTheatreMapping.get(c);
    }
}
