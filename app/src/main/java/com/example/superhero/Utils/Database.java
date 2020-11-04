package com.example.superhero.Utils;

import com.example.superhero.model.SuperHero;

import java.util.ArrayList;
import java.util.Arrays;

public class Database {

    ArrayList<SuperHero> localData = new ArrayList<SuperHero>(Arrays.asList(
            new SuperHero(0, "Superman", "DC", 93, 95, 40, true),
            new SuperHero(1, "Batman", "DC", 65, 75, 80, false),
            new SuperHero(2, "Spider man", "Marvel", 60, 85, 75, false)
    ));

    public ArrayList<SuperHero> getData(String category) {
        if (category.equals("All")) {
            return localData;
        } else {
            ArrayList<SuperHero> heroes = new ArrayList<>();
            for (SuperHero hero : localData) {
                if (hero.getCategory().equals(category)) {
                    heroes.add(hero);
                }
            }
            return heroes;
        }
    }

    public ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("All");
        for (SuperHero hero : localData) {
            if (!categories.contains(hero.getCategory())) {
                categories.add(hero.getCategory());
            }
        }
        return categories;
    }


}
