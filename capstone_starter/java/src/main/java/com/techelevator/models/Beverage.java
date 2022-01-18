package com.techelevator.models;

import java.math.BigDecimal;

public class Beverage extends InventoryItem {

    private String bevDispenseMessage = "Glug Glug, Yum!";

    public Beverage(String slotID, String itemName, BigDecimal itemPrice) {
        super(slotID, itemName, itemPrice);
        super.setDispenseMessage(bevDispenseMessage);
    }
}
