package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ItemNotFoundException extends RuntimeException {

    private final String id;

    public ItemNotFoundException(String message, String id) {
        super(message);
        this.id = id;
    }

    public static ItemNotFoundException from(String message, String id) {
        return new ItemNotFoundException(message, id);
    }
}