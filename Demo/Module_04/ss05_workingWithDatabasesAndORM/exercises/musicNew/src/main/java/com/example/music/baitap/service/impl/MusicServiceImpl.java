package com.example.music.baitap.service.impl;

import com.example.music.baitap.model.Music;
import com.example.music.baitap.repository.IMusicRepository;
import com.example.music.baitap.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MusicServiceImpl implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findOne(int id) {
        return musicRepository.getOne(id);
    }

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }


}
