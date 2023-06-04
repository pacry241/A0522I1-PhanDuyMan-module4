package com.example.testmodule4.service;

import com.example.testmodule4.model.GiaoDich;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IGiaoDichService {
    GiaoDich findById(Integer id);

    Iterable<GiaoDich> listAll();
}
