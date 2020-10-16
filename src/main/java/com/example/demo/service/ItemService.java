package com.example.demo.service;

import com.example.demo.model.Item;

import java.util.List;

public interface ItemService {

    public List<Item> findAll();

    public Item findById(Long id);

}
