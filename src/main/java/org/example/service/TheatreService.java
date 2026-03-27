package org.example.service;

import org.example.entity.City;
import org.example.entity.Theatre;
import org.example.repository.TheatreRepository;

public class TheatreService {
    private City c;
    private TheatreRepository tr;

    public TheatreService(City c, TheatreRepository tr) {
        this.c = c;
        this.tr = tr;
    }

    public void addTheatre(){
        Theatre t = new Theatre();
        tr.addTheatreToRepo(c,t);
    }
}
