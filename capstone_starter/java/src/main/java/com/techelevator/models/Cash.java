package com.techelevator.models;


import com.techelevator.logger.VendingLogger;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;

public abstract class Cash {
    private static BigDecimal currentBalance = new BigDecimal("0.00");
    private static BigDecimal sales;
    private static BigDecimal purchase;
    private static VendingLogger cashLogger = new VendingLogger("Log.txt");


    public static BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public static void setCurrentBalance(BigDecimal newBalance) {
        currentBalance = newBalance;
    }

    public static BigDecimal getSales() {
        return sales;
    }

    public static BigDecimal getPurchase() {
        return purchase;
    }

    public static void setPurchase(BigDecimal purchase) {
        purchase = purchase;
    }

     /*public static void setSales(BigDecimal sales) {
        //this.sales = sales; add purchase amount
        //for optional Sales Report
    }*/

    public static void dispenseChange() {
        UserOutput.displayLine(Change.makeChange(getCurrentBalance()));
        //log action
        setCurrentBalance(new BigDecimal("0.00"));
    }

    public static void increaseBalance(String billChoice) {
        BigDecimal amountToAdd = new BigDecimal(billChoice);
        currentBalance = currentBalance.add(amountToAdd);
        cashLogger.write(CurrentTime.nowToString("FEED MONEY", amountToAdd, currentBalance));
        UserOutput.displayMessage("You have $" + getCurrentBalance().toString() + " to spend");
    }

    public static void dispenseItem(String slotName) {
        int balanceComparison;
        if (!slotName.equals("DNE")) {
            for (InventoryItem item : Inventory.getInventory()) {
                if (slotName.equals(item.getSlotID())) {
                    balanceComparison = (getCurrentBalance().compareTo(item.getItemPrice()));
                    if (balanceComparison >= 0) {
                        checkIfSoldOut(item);
                    } else {
                        UserOutput.displayMessage("Insufficient funds to purchase this item.");
                    }
                }
            }
        } else {
            UserOutput.displayMessage("Sorry, the selected item does not exist.");
        }
    }

    public static void checkIfSoldOut(InventoryItem item) {
        if (!item.qtyCheck().equals("SOLD OUT")) {
            UserOutput.displayMessage(item.getDispenseMessage());
            cashLogger.write(CurrentTime.nowToString(item.getItemName(), currentBalance, (currentBalance.subtract(item.getItemPrice()))));
            setCurrentBalance(getCurrentBalance().subtract(item.getItemPrice()));
            item.sellItem();
        } else {
            UserOutput.displayMessage("Sorry, your selected item is sold out.");
        }
    }
}

// if the price of the item is greater than the balance

// return a message that says heck no, girl!
// else it will dispense the item and alter the balance




