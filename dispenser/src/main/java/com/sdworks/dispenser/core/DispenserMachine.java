package com.sdworks.dispenser.core;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DispenserMachine {
    private List<Drink> drinks;
    private double balance;
}
