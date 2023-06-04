package com.example.music.baitap.service;

import com.example.music.baitap.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    Music findOne(int id);

    Music save(Music music);

}
