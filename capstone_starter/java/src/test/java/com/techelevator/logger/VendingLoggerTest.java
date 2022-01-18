package com.techelevator.logger;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class VendingLoggerTest {

    @Test
    public void write_First_Line_Scan_In_First_Line() throws IOException {
        VendingLogger vendingLogger = new VendingLogger("loggerTestOneLine.txt");
        File file = new File("loggerTestOneLine.txt");
        Scanner scanner = new Scanner(file);

        vendingLogger.write("First Line");
        String actualString = scanner.nextLine();
        String expectedString = "First Line";
        vendingLogger.close();

        Assert.assertEquals(expectedString, actualString);

    }

    //@Test
    public void write_Second_Line_Scan_In_Second_Line_Appended_After_First_Line() throws IOException {
        VendingLogger vendingLogger = new VendingLogger("loggerTestTwoLines.txt");
        File file = new File("loggerTestTwoLines.txt");
        Scanner scanner = new Scanner(file);
        String actualString = "";

        vendingLogger.write("Second Line");
        while(scanner.hasNextLine()){
            actualString += scanner.nextLine();
        }

        String expectedString = "One Line\nSecond Line";
        vendingLogger.close();

        Assert.assertEquals(expectedString, actualString);

    }
}