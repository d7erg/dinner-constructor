package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByType;
    Random rnd = new Random();

    DinnerConstructor() {
        dishesByType = new HashMap<>();
    }

    void addNewDish(String dishType, String dishName) {
        if (!dishesByType.containsKey(dishType)) {
            dishesByType.computeIfAbsent(dishType, k -> new ArrayList<>()).add(dishName);
        }
        ArrayList<String> dishes = dishesByType.get(dishType);
        if (!dishes.contains(dishName)) {
            dishes.add(dishName);
        }
    }

    void generateDishCombo(int numberOfCombos, ArrayList<String> dishesTypes) {
        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> dishCombo = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String dishType : dishesTypes) {
                ArrayList<String> dishes = dishesByType.get(dishType);
                int index = rnd.nextInt(dishes.size());
                String randomDish = dishes.get(index);
                dishCombo.add(randomDish);
            }
            System.out.println(dishCombo);
        }
    }

    boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }
}
