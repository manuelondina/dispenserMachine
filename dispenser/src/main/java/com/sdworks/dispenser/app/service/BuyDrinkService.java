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
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Invalid drink");
        }
    }
    // XXX:
    // Please note that I did not implement the case to ask the user if he
    // wants to buy another drink. If not then he would receive the change, in this
    // case user
    // will only receive remaining coins if he cancels the order. Reason is because
    // in the requirements it says that we don't want any interactive keyboard
    // input.
}
