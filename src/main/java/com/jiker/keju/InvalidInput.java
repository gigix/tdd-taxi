package com.jiker.keju;

public class InvalidInput extends RuntimeException {
    public InvalidInput(String text) {
        super(text);
    }
}
