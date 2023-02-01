package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String name;

    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    private String singer;

    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9\\,]*$")
    private String kind;

    public Music() {
    }

    public Music(long id, @NotEmpty @Max(value = 800) @Pattern(regexp = "^[a-zA-Z0-9]*$") String name, @NotEmpty @Max(value = 300) @Pattern(regexp = "^[a-zA-Z0-9]*$") String singer, @NotEmpty @Max(value = 300) @Pattern(regexp = "^[a-zA-Z0-9\\,]*$") String kind) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kind = kind;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
