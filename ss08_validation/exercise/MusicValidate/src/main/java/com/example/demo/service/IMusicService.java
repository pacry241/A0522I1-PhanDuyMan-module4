package com.example.demo.service;

import com.example.demo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IMusicService {

    void save(Music music);

    Music findById(Long id);

    Page<Music> getAllWithPage(PageRequest pageRequest);
}
