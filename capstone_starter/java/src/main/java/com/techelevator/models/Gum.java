package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends InventoryItem {

    private String gumDispenseMessage = "Chew Chew, Yum!" ;

    public Gum(String slotID, String itemName, BigDecimal itemPrice) {
        super(slotID, itemName, itemPrice);
        super.setDispenseMessage(gumDispenseMessage);
    }
}
