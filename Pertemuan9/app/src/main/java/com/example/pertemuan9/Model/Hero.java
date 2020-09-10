package com.example.pertemuan9.Model;

public class Hero {
    private int image;
    private String name, team;

    public Hero(){}

    public Hero(int image, String name, String team) {
        this.image = image;
        this.name = name;
        this.team = team;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
