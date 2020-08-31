package com.example.firebaselatihan;

public class AnimeStudio {
    String idStudio;
    String animeName;
    String studio;

    public AnimeStudio(){

    }

    public AnimeStudio(String idStudio, String animeName, String studio) {
        this.idStudio = idStudio;
        this.animeName = animeName;
        this.studio = studio;
    }

    public String getIdStudio() {
        return idStudio;
    }

    public String getAnimeName() {
        return animeName;
    }

    public String getStudio() {
        return studio;
    }
}
