package com.sdworks.dispenser.app.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CoinValidatorService {

    public static final List<BigDecimal> validCoins = Arrays.asList(
            BigDecimal.valueOf(0.05),
            BigDecimal.valueOf(0.10),
            BigDecimal.valueOf(0.20),
            BigDecimal.valueOf(0.50),
            BigDecimal.valueOf(1.00),
            BigDecimal.valueOf(2.00));

    public static boolean isValidCoin(double coin) {
        BigDecimal coinBigDecimal = BigDecimal.valueOf(coin);
        return validCoins.contains(coinBigDecimal);
    }
}
