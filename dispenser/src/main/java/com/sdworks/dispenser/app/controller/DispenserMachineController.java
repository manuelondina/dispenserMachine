package com.sdworks.dispenser.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.sdworks.dispenser.app.service.BuyDrinkService;
import com.sdworks.dispenser.app.service.CoinValidatorService;
import com.sdworks.dispenser.core.DispenserMachine;
import com.sdworks.dispenser.core.Drink;

@Controller
public class DispenserMachineController implements IDispenserMachine {

    DispenserMachine dispenserMachine = DispenserMachine.builder()
            .drinks(new ArrayList<>())
            .balance(0.0)
            .build();

    public void addDrink(Drink drink) {
        dispenserMachine.getDrinks().add(drink);
    }

    public List<Drink> getDrink() {
        return dispenserMachine.getDrinks();
    }

    public void insertCoin(double coin) {
        if (isValidCoin(coin)) {
            System.out.println("Inserted coin -> " + coin + " EUR");
            dispenserMachine.setBalance(dispenserMachine.getBalance() + coin);
        } else {
            throw new IllegalArgumentException("Invalid coin");
        }
    }

    public boolean isValidCoin(double coin) {
        return CoinValidatorService.isValidCoin(coin);
    }

    public double getBalance() {
        return dispenserMachine.getBalance();
    }

    public void displayStock() {
        System.out.println("#### Available Drinks: ####");
        dispenserMachine.getDrinks().forEach(d -> System.out.println(d.getName() + " -> " + d.getPrice() + " EUR"));
    }

    public void buyDrink(String drinkName) {
        BuyDrinkService.buyDrink(dispenserMachine, drinkName);
    }

    public void cancelOrder() {
        if (dispenserMachine.getBalance() > 0) {
            System.out.println("Canceling order...");
            System.out.println("Returning " + dispenserMachine.getBalance() + " EUR");
            dispenserMachine.setBalance(0.0);
        } else {
            throw new IllegalArgumentException("No money to return");
        }
    }
}
