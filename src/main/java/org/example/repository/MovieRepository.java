package org.example.repository;

import org.example.entity.City;
import org.example.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    private Map<City, List<Movie>> cityToMovieMapping;

    public MovieRepository(Map<City, List<Movie>> cityToMovieMapping) {
        this.cityToMovieMapping = cityToMovieMapping;
    }

    public Map<City, List<Movie>> getCityToMovieMapping() {
        return cityToMovieMapping;
    }

    public void setCityToMovieMapping(Map<City, List<Movie>> cityToMovieMapping) {
        this.cityToMovieMapping = cityToMovieMapping;
    }

    public void addMovieToRepo(City c,Movie m){
        if(!cityToMovieMapping.containsKey(c)){
            cityToMovieMapping.put(c,new ArrayList<>());
        }
        cityToMovieMapping.get(c).add(m);
    }

    public List<Movie> getMovies(City c){
        return cityToMovieMapping.get(c);
    }
}
