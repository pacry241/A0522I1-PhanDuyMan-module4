package com.example.listenmusic.service.impl;

import com.example.listenmusic.model.Music;
import com.example.listenmusic.repository.impl.HebernateMusicRepositoryImpl;
import com.example.listenmusic.service.IMusicService;
import com.example.listenmusic.model.Music;
import com.example.listenmusic.repository.impl.HebernateMusicRepositoryImpl;
import com.example.listenmusic.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MusicServiceImpl implements IMusicService {
    @Autowired
    HebernateMusicRepositoryImpl musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findOne(int id) {
        return musicRepository.findOne(id);
    }

    @Override
    public Music save(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public List<Music> save(List<Music> music) {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public List<Music> findAll(List<Integer> ids) {
        return null;
    }

    /*@Override
    public List<Music> findAll(List<int> ids) {
        return null;
    }*/

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Music music) {

    }

    @Override
    public void delete(List<Music> music) {

    }

    @Override
    public void deleteAll() {

    }
}
