package com.sdworks.dispenser.app.service;

import com.sdworks.dispenser.core.DispenserMachine;
import com.sdworks.dispenser.core.Drink;

public class BuyDrinkService {
    public static void buyDrink(DispenserMachine dispenserMachine, String drinkName) {
        Drink drink = dispenserMachine.getDrinks().stream()
                .filter(d -> d.getName().equals(drinkName)).findFirst()
                .orElse(null);

        if (drink != null) {
            System.out.println("Selected drink -> " + drink.getName());
            if (dispenserMachine.getBalance() >= drink.getPrice()) {
                dispenserMachine.setBalance(dispenserMachine.getBalance() - drink.getPrice());
                System.out.println("Enjoy your " + drink.getName());
                System.out.println("Your amount is " + dispenserMachine.getBalance());
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Invalid drink");
        }
    }
}
