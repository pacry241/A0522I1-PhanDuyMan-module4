package com.example.music.baitap.service;

import com.example.music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findOne(int id);

    Music save(Music music);

    List<Music> save(List<Music> music);

    boolean exists(int id);

    List<Music> findAll(List<Integer> ids);

    long count();

    void delete(int id);

    void delete(Music music);

    void delete(List<Music> music);

    void deleteAll();
}
