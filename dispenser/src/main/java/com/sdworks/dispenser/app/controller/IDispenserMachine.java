package com.sdworks.dispenser.app.controller;

import java.util.List;

import com.sdworks.dispenser.core.Drink;

public interface IDispenserMachine {

    public void addDrink(Drink drink);

    public List<Drink> getDrink();

    public void insertCoin(double coin);

    public boolean isValidCoin(double coin);

    public double getBalance();

    public void displayStock();

}
