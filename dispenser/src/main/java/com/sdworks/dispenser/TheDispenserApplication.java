package com.sdworks.dispenser;

import com.sdworks.dispenser.app.controller.DispenserMachineController;
import com.sdworks.dispenser.core.Drink;

public class TheDispenserApplication {

	public static void main(String[] args) {
		DispenserMachineController dispenserMachine = new DispenserMachineController();

		Drink coca = new Drink("Coca-Cola", 1.00);
		Drink redbull = new Drink("RedBull", 1.25);
		Drink water = new Drink("Water", 0.50);
		Drink orangeJuice = new Drink("Orange Juice", 1.95);

		// Given a dispenser machine with drinks
		dispenserMachine.addDrink(coca);
		dispenserMachine.addDrink(redbull);
		dispenserMachine.addDrink(water);
		dispenserMachine.addDrink(orangeJuice);

		// Should display available drinks
		dispenserMachine.displayStock();

		// When user inserts coins
		dispenserMachine.insertCoin(1.00);
		dispenserMachine.insertCoin(0.50);

		// Then user buys a drink
		dispenserMachine.buyDrink("RedBull");

		// Given same user whom has inserted more coins
		dispenserMachine.insertCoin(1.00);

		// When user cancels order THEN it will return the total amount of coins
		// inserted
		dispenserMachine.cancelOrder();
	}

}
