package com.example.finalmusic.service.impl;

import com.example.finalmusic.model.Music;
import com.example.finalmusic.repository.IRepository;
import com.example.finalmusic.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IRepository iRepository;

    @Override
    public List<Music> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(Music music) {
        iRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public void update(Music music) {
        iRepository.update(music);
    }

    @Override
    public void delete(Music music) {
        iRepository.delete(music);
    }
}
