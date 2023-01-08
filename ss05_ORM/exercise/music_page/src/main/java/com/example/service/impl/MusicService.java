package com.example.service.impl;


import com.example.model.Music;
import com.example.repository.impl.MusicRepository;
import com.example.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private MusicRepository repository;

    @Override
    public List<Music> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Music music) {
        repository.save(music);
    }

    @Override
    public Music findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Music music) {
        repository.update(music);
    }

    @Override
    public void delete(Music music) {
        repository.delete(music);
    }
}
