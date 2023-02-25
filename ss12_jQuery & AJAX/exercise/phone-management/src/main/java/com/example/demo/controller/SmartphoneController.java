package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.impl.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("smartPhones")
@CrossOrigin("*")
public class SmartphoneController {
    @Autowired
    private SmartphoneService service;

    @GetMapping(value = "")
    public ResponseEntity<?> allPhones() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("phones", service.findAll());
        return modelAndView;
    }



    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(service.save(smartphone), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = service.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.remove(id);
        return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Smartphone> find(@PathVariable Long id) {
        Optional<Smartphone> phoneOptional = service.findById(id);
        if (!phoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phoneOptional.get(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Smartphone> editPhone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(service.save(smartphone), HttpStatus.OK);
    }
}
