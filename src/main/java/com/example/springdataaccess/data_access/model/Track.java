package com.example.springdataaccess.data_access.model;

public class Track {
    private int trackId;
    private String name;

    public Track() {
    }

    public Track(int trackId, String name) {
        this.trackId = trackId;
        this.name = name;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
