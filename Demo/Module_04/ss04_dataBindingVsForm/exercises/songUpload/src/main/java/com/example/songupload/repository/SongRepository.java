package com.example.songupload.repository;

import com.example.songupload.model.Song;

import java.util.LinkedList;
import java.util.List;

public class SongRepository {
    private static List<Song> music;
    static{
        music = new LinkedList<>();
        music.add(new Song("Sao Nỡ Quên Đi","Danh Vũ Linh","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/sao-no-quen-di-danh-vu-linh.X0pO9OI0zTXY.html"));
        music.add(new Song("Người Kế Nhiệm","Anh Khoa","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/nguoi-ke-nhiem-anh-khoa-tre.xSojugtvdTuN.html"));
        music.add(new Song("Có Một Người ","Kha Nhỉ","Nhạc trẻ","https://www.nhaccuatui.com/bai-hat/co-mot-nguoi-kha-nhi.OHSK4uQ2k2zA.html"));
    }

    public List<Song> showAll(){
        return music;
    }

    public void addMusic(Song musicObj){
        music.add(musicObj);
    }
}
