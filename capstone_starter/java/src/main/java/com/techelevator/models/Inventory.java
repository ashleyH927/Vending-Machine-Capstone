package com.techelevator.models;

import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Inventory {
    private static List<InventoryItem> inventory = new ArrayList<>();
    private static String inventoryFilePath = "vendingmachine.csv";
    private static File inventoryFile = new File(inventoryFilePath);
    private static Scanner fileScanner;

    public static List<InventoryItem> getInventory() {
        return inventory;
    }

    public static String getInventoryFilePath() {
        return inventoryFilePath;
    }

    public static File getInventoryFile() {
        return inventoryFile;
    }

    public static Scanner getFileScanner() {
        return fileScanner;
    }

    public static void initializeInventory() {
        try {
            fileScanner = new Scanner(inventoryFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                String[] vendingInfoLines = line.split("\\|");

                String slotID = vendingInfoLines[0].trim();
                String itemName = vendingInfoLines[1].trim();
                BigDecimal big = new BigDecimal(vendingInfoLines[2].trim());
                String itemType = vendingInfoLines[3].trim();

                addInventory(slotID, itemName, big, itemType);
            }
        } catch (FileNotFoundException e) {
            UserOutput.displayLine("Error Reading File");
        }
    }

    private static void addInventory(String slotID, String itemName, BigDecimal price, String type) {
        if (type.startsWith("Ch")) {
            Chips chip = new Chips(slotID, itemName, price);
            inventory.add(chip);
        }
        if (type.startsWith("Ca")) {
            Candy candy = new Candy(slotID, itemName, price);
            inventory.add(candy);

        }
        if (type.startsWith("Dr")) {
            Beverage drink = new Beverage(slotID, itemName, price);
            inventory.add(drink);
        }
        if (type.startsWith("Gu")) {
            Gum gum = new Gum(slotID, itemName, price);
            inventory.add(gum);
        }
    }
}
