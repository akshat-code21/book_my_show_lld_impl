package org.example.entity;

import java.util.List;

public class Theatre {
    private String id;
    private City c;
    List<Screen> screens;

    public Theatre(String id, City c, List<Screen> screens) {
        this.id = id;
        this.c = c;
        this.screens = screens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public City getC() {
        return c;
    }

    public void setC(City c) {
        this.c = c;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
