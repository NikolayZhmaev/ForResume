package net.thumbtack.school.springRest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Recording {
    @NotNull
    private String artist;
    @NotNull
    private String nameOfComposition;
    private String nameOfAlbum;
    private String linkToCover;
    @NotNull
    private String genre;

    private  String linkToAudioFile;
    private String linkToVideoFile;
    @Min(1970)
    private int year;
    @NotNull
    private int time;

    public Recording() {
        this.artist = "Кипелов";
        this.nameOfComposition = "Беспечный ангел";
        this.nameOfAlbum = "Беспечный ангел";
        this.linkToCover = "album Беспечный ангел";
        this.genre = "рок";
        this.time = 20;
        this.linkToAudioFile = "audio Беспечный ангел";
        this.linkToVideoFile = "video Беспечный ангел";
        this.year = 1999;
    }

    public Recording(String artist, String nameOfComposition, String nameOfAlbum, int year, String linkToCover, String genre, int time, String linkToAudioFile, String linkToVideoFile) {
        this.artist = artist;
        this.nameOfComposition = nameOfComposition;
        this.nameOfAlbum = nameOfAlbum;
        this.year = year;
        this.linkToCover = linkToCover;
        this.genre = genre;
        this.time = time;
        this.linkToAudioFile = linkToAudioFile;
        this.linkToVideoFile = linkToVideoFile;
    }

    public Recording(String artist, String nameOfComposition, String nameOfAlbum, String linkToCover, String genre, String linkToAudioFile, int year, int time) {
        this.artist = artist;
        this.nameOfComposition = nameOfComposition;
        this.nameOfAlbum = nameOfAlbum;
        this.linkToCover = linkToCover;
        this.genre = genre;
        this.linkToAudioFile = linkToAudioFile;
        this.year = year;
        this.time = time;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getNameOfComposition() {
        return nameOfComposition;
    }

    public void setNameOfComposition(String nameOfComposition) {
        this.nameOfComposition = nameOfComposition;
    }

    public String getNameOfAlbum() {
        return nameOfAlbum;
    }

    public void setNameOfAlbum(String nameOfAlbum) {
        this.nameOfAlbum = nameOfAlbum;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLinkToCover() {
        return linkToCover;
    }

    public void setLinkToCover(String linkToCover) {
        this.linkToCover = linkToCover;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getLinkToAudioFile() {
        return linkToAudioFile;
    }

    public void setLinkToAudioFile(String linkToAudioFile) {
        this.linkToAudioFile = linkToAudioFile;
    }

    public String getLinkToVideoFile() {
        return linkToVideoFile;
    }

    public void setLinkToVideoFile(String linkToVideoFile) {
        this.linkToVideoFile = linkToVideoFile;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "artist='" + artist + '\'' +
                ", nameOfComposition='" + nameOfComposition + '\'' +
                ", nameOfAlbum='" + nameOfAlbum + '\'' +
                ", linkToCover='" + linkToCover + '\'' +
                ", genre='" + genre + '\'' +
                ", linkToAudioFile='" + linkToAudioFile + '\'' +
                ", linkToVideoFile='" + linkToVideoFile + '\'' +
                ", year=" + year +
                ", time=" + time +
                '}';
    }
}
