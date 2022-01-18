package com.techelevator.models;

import java.math.BigDecimal;

public class InventoryItem {
    private String itemName;
    private BigDecimal itemPrice;
    private String dispenseMessage;
    private String slotID;
    private int currentStock;
    private final int STOCKQTY = 5;
    private BigDecimal itemTotalSale = new BigDecimal(0.00);

    public InventoryItem(String slotID, String itemName, BigDecimal itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.slotID = slotID;
        this.currentStock = STOCKQTY;
    }

    public BigDecimal getItemTotalSale() {
        return itemTotalSale;
    }

    public void setItemTotalSale(BigDecimal itemTotalSale) {
        this.itemTotalSale = itemTotalSale;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }

    public String getSlotID() {
        return slotID;
    }

    public void setDispenseMessage(String dispenseMessage) {
        this.dispenseMessage = dispenseMessage;
    }

    public String qtyCheck() {
        if (getCurrentStock() == 0) {
            return "SOLD OUT";
        }
        return Integer.toString(getCurrentStock());
    }

    public String toString() {
        //return("%-15s %30s $%45s Number Available: %40s\n", this.getSlotID(), this.getItemName(), this.getItemPrice().toString(),this.getCurrentStock());
        return (this.getSlotID() + " " + this.getItemName() + " $" + this.getItemPrice().toString() + " Number Available: " + this.getCurrentStock());
    }

    public void sellItem() {
        if (currentStock > 0) {
            currentStock -= 1;
        }
    }

} //class
