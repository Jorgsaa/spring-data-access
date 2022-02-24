package com.example.springdataaccess.data_access.model;

public class TrackArtistAlbum {
    private String trackName;
    private String artistName;
    private String albumName;

    public TrackArtistAlbum() {
    }

    public TrackArtistAlbum(String trackName, String artistName, String albumName) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

}
