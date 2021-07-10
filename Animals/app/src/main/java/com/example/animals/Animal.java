package com.example.animals;

public class Animal {
    private String Type;
    private String Sound;
    private int Image;

    public Animal(String type, String sound, int image) {
        Type = type;
        Sound = sound;
        Image = image;
    }

    public String getType() {
        return Type;
    }

    public String getSound() {
        return Sound;
    }

    public int getImage() {
        return Image;
    }
}
