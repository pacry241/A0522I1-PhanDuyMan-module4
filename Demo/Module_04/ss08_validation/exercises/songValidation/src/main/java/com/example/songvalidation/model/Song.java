package com.example.songvalidation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSong;

    @Size(max = 800)
    @NotEmpty
    private String nameSong;

    @NotEmpty
    @Size(max = 300)
    private String author;

    @NotEmpty
    @Size(max = 1000)
    private String genre;

    public Song() {
    }

    public Song(int idSong, String nameSong, String author, String genre) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.author = author;
        this.genre = genre;
    }
}
