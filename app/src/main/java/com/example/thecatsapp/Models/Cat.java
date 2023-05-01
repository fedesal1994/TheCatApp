package com.example.thecatsapp.Models;

public class Cat {
    private String breedNameCat;
    private String origin;
    private int affectionLevel;
    private int intelligence;
    private String imageUrl;

    public Cat(String breedNameCat, String origin, int affectionLevel, int intelligence, String imageUrl) {
        this.breedNameCat = breedNameCat;
        this.origin = origin;
        this.affectionLevel = affectionLevel;
        this.intelligence = intelligence;
        this.imageUrl = imageUrl;
    }

    public String getBreedNameCat() {
        return breedNameCat;
    }

    public void setBreedNameCat(String breedNameCat) {
        this.breedNameCat = breedNameCat;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

