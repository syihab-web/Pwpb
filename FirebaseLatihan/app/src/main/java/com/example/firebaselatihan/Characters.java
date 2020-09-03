package com.example.firebaselatihan;

public class Characters {
    private String charaId;
    private String charaName;
    private int charaRating;

    public Characters(){

    }

    public Characters(String charaId, String charaName, int charaRating) {
        this.charaId = charaId;
        this.charaName = charaName;
        this.charaRating = charaRating;
    }

    public String getCharaId() {
        return charaId;
    }

    public String getCharaName() {
        return charaName;
    }

    public int getCharaRating() {
        return charaRating;
    }
}
