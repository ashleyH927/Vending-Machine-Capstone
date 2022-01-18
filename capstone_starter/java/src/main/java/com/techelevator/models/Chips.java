package com.techelevator.models;

import java.math.BigDecimal;

public class Chips extends InventoryItem {

    String chipsDispenseMessage = "Crunch Crunch, Yum!";

    public Chips(String slotID, String itemName, BigDecimal itemPrice) {
        super(slotID, itemName, itemPrice);
        super.setDispenseMessage(chipsDispenseMessage);
    }
}
