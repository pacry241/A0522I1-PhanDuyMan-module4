package com.example.finalmusic.service;

import com.example.finalmusic.model.Music;

import java.util.List;

public interface IService {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
    void update(Music music);
    void delete(Music music);
}
