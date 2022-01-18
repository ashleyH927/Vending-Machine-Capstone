package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends InventoryItem {

    private String candyDispenseMessage = "Munch Munch, Yum!" ;

    public Candy(String slotID, String itemName, BigDecimal itemPrice) {
        super(slotID, itemName, itemPrice);
        super.setDispenseMessage(candyDispenseMessage);
    }


}
