package com.example.demo.repository;

import com.example.demo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music, Long> {
    @Query(value = "select * from musics", nativeQuery = true)
    Page<Music> findAllWithPage(PageRequest pageRequest);
}
