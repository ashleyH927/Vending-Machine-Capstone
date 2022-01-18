package com.techelevator.models;

import com.techelevator.logger.VendingLogger;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Change {
    final static BigDecimal COIN_MULTIPLIER = new BigDecimal("100");
    final static BigDecimal QUARTER = new BigDecimal("25");
    final static BigDecimal DIME = new BigDecimal("10");
    final static BigDecimal NICKEL = new BigDecimal("5");
    private static VendingLogger changeLogger = new VendingLogger("Log.txt");

    public static String makeChange(BigDecimal changeToMake) {
        BigDecimal changeRemainder = changeToMake.multiply(COIN_MULTIPLIER).setScale(0);

        BigDecimal quarterRemainder = changeRemainder.remainder(QUARTER);
        BigDecimal quarterPortion = changeRemainder.subtract(quarterRemainder);
        BigDecimal quartersReturned = quarterPortion.divide(QUARTER, 0, RoundingMode.HALF_DOWN);

        BigDecimal dimeRemainder = quarterRemainder.remainder(DIME);
        BigDecimal dimePortion = quarterRemainder.subtract(dimeRemainder);
        BigDecimal dimesReturned = dimePortion.divide(DIME, 0, RoundingMode.HALF_DOWN);

        BigDecimal nickelsReturned = dimeRemainder.divide(NICKEL, 0, RoundingMode.HALF_DOWN);

        changeLogger.write(CurrentTime.nowToString(" GIVE CHANGE ", Cash.getCurrentBalance().setScale(2), new BigDecimal("0.00")));
        return ("$" + changeToMake.toString() + " was dispensed as:\nQuarters: " + quartersReturned.toString() + "\nDimes: " + dimesReturned.toString() + "\nNickels: " + nickelsReturned.toString());
    }
}


//Original double/INT math  -  CONVERTED TO BidDecimal Math Above
//Double changeRequired = changeToMake.doubleValue();
//  // = changeRequired.doubleValue(); WAS COMMENT
/* int changeInCoins = (int) (changeRequired * COIN_MULTIPLIER);  //500
        double changeRemainder = changeInCoins;  //the actual value for math

        int quartersReturned = (int) (changeInCoins / QUARTER);
        changeRemainder -= (double) (quartersReturned * QUARTER);  //5.00 - 5*25

        int dimesReturned = (int) (changeRemainder / DIME);
        changeRemainder -= (double) (dimesReturned * DIME);

        int nickelsReturned = (int) (changeRemainder / NICKEL);*/
