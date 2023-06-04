package com.example.music.baitap.repository;

import com.example.music.baitap.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMusicRepository extends JpaRepository<Music, Integer> {
}
