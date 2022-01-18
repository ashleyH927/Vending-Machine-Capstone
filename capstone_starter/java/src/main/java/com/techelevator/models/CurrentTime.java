package com.techelevator.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {

    public static String nowToString(String action, BigDecimal firstAmount, BigDecimal secondAmount) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:m:s a");
        return (LocalDate.now().getMonthValue() + "/" +
                LocalDate.now().getDayOfMonth() + "/" +
                LocalDate.now().getYear() + " " +
                LocalTime.now().format(timeFormatter) + " " +
                action + " $" + (firstAmount.setScale(2).toString()) + " $" + (secondAmount.setScale(2).toString()));

                //+ " " + LocalTime.now().format(timeFormatter) + " " + "FEED MONEY $5.00 $5.00");  FORMAT FOR GUIDE
    }
}
