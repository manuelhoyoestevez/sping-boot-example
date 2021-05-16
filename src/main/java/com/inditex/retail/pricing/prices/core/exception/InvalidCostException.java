package com.inditex.retail.pricing.prices.core.exception;

public class InvalidCostException extends RuntimeException {
    public InvalidCostException(Double amount) {
        super("Cost amount must be greater than 0, given: " + amount);
    }
}
