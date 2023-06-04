package com.example.songupload.model;

public class Song {
    private String name;
    private String singer;
    private String kind;
    private String link;

    public Song() {
    }

    public Song(String name, String singer, String kind, String link) {
        this.name = name;
        this.singer = singer;
        this.kind = kind;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
