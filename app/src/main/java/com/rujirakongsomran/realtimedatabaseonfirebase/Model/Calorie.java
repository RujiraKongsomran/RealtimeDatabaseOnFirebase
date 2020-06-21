package com.rujirakongsomran.realtimedatabaseonfirebase.Model;

public class Calorie {
    private String name;
    private String category;
    private int kcal;
    private String img;

    public Calorie() {
    }

    public Calorie(String name, String category, int kcal, String img) {
        this.name = name;
        this.category = category;
        this.kcal = kcal;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
