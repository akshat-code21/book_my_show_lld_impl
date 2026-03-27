package org.example.repository;

import org.example.entity.Show;

import java.util.HashMap;
import java.util.Map;

public class ShowRepository {
    private final Map<String, Show> showIdToShowMapping;

    public ShowRepository() {
        showIdToShowMapping = new HashMap<>();
    }

    public void addShow(Show show) {
        showIdToShowMapping.put(show.getId(), show);
    }

    public Show getShow(String showId) {
        return showIdToShowMapping.get(showId);
    }
}
