package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChangeTest {

    @Test
    public void makeChange_pass_in_1_15_return_4_quarters_1_dime_1_nickel() {
        BigDecimal testBigDecimal = new BigDecimal("1.15");

        String actual = Change.makeChange(testBigDecimal);
        String expected = "$1.15 was dispensed as:\nQuarters: 4\nDimes: 1\nNickels: 1";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeChange_pass_in_0_return_0_quarters_0_dimes_0_nickels() {
        BigDecimal testBigDecimal = new BigDecimal("0.00");

        String actual = Change.makeChange(testBigDecimal);
        String expected = "$0.00 was dispensed as:\nQuarters: 0\nDimes: 0\nNickels: 0";

        Assert.assertEquals(expected, actual);
    }
}