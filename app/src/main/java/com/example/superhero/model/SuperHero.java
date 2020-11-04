package com.example.superhero.model;

public class SuperHero {
    int id;
    String name;
    String category;
    int power;
    int stamina;
    int charisma;
    boolean canFly;

    public SuperHero(int id, String name, String category, int power, int stamina, int charisma, boolean canFly) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.power = power;
        this.stamina = stamina;
        this.charisma = charisma;
        this.canFly = canFly;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}
