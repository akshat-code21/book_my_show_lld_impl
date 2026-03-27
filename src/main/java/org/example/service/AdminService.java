package org.example.service;

public class AdminService {
    private final MovieService ms;
    private final TheatreService tr;
    private final MovieShowService mss;

    public AdminService(MovieService ms, TheatreService tr, MovieShowService mss) {
        this.ms = ms;
        this.tr = tr;
        this.mss = mss;
    }

}
