package com.example.demo.service.Impl;

import com.example.demo.model.Music;
import com.example.demo.repository.IMusicRepository;
import com.example.demo.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository repository;
    @Override
    public void save(Music music) {
        repository.save(music);
    }

    @Override
    public Music findById(Long id) {
        return repository.findById(id).orElse(new Music());
    }

    @Override
    public Page<Music> getAllWithPage(PageRequest pageRequest) {
        return repository.findAllWithPage(pageRequest);
    }
}
