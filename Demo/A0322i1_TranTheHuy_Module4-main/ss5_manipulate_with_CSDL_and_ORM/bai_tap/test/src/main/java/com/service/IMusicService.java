package com.service;

import com.models.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void  save(Music music);

    Music findById(int id);

    void update( Music music);

    void remove(Music music);
}
