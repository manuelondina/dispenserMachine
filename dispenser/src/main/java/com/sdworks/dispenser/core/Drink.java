package com.sdworks.dispenser.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Drink {
    private String name;
    private Double price;
}
