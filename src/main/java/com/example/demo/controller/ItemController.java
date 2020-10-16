package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@CrossOrigin(origins = "*", maxAge = 3600L)
@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(itemService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/{id}",
            method = RequestMethod.GET,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseEntity<Item> getItem(@PathVariable("id") Long id) {
        return new ResponseEntity<>(itemService.findById(id), new HttpHeaders(), HttpStatus.OK);
    }

}
