package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class InventoryItemTest {

    //@Test
    public void qtyCheck() {
        //will write when we implement purchase logic
    }

    @Test
    public void testToString_A11_Test_Chips_100_Return_A11_TestChips_$100_Number_Available_5() {
        BigDecimal testBig = new BigDecimal(100);
        InventoryItem inventoryItem = new InventoryItem("A11", "TestChips", testBig);

        String expected = "A11 TestChips $100 Number Available: 5";
        String actual = inventoryItem.toString();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testToString_No_empty_0_Return_No_empty_$0_Number_Available_5() {
        BigDecimal testBig = new BigDecimal(0);
        InventoryItem inventoryItem = new InventoryItem("No", "empty", testBig);

        String expected = "No empty $0 Number Available: 5";
        String actual = inventoryItem.toString();

        Assert.assertEquals(expected, actual);

    }

}