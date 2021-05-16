package com.inditex.retail.pricing.prices.core.model;

public enum Currency {
    EUR("€", "Euro", 2),
    USD("$", "Dollar", 2),
    GBP("£", "Pound Sterling", 2);

    private String symbol;
    private String name;
    private Integer decimalPlaces;

    Currency(String symbol, String name, Integer decimalPlaces) {
        this.symbol = symbol;
        this.name = name;
        this.decimalPlaces = decimalPlaces;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }
}
