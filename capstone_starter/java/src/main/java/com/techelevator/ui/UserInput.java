package com.techelevator.ui;

import com.techelevator.models.Cash;
import com.techelevator.models.Inventory;
import com.techelevator.models.InventoryItem;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * <p>
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {

        UserOutput.displayMainMenu();

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "display";
            case "2":
                return "purchase";
            case "3":
                return "exit";
            default:
                UserOutput.displayLine("\"Please Select a Valid Option\"");
                return "";
        }
    }

    public static String getPurchaseMenuOption() {
        String option = "";

        UserOutput.displayPurchaseMenu();

        String selectedPurchaseOption = scanner.nextLine();
        option = selectedPurchaseOption.trim().toLowerCase();
        switch (option) {
            case "1":
                option = "Feed Money";
                break;
            case "2":
                option = "Select Product";
                break;
            case "3":
                option = "Finish Transaction";
                break;
            default:
                UserOutput.displayLine("Please Select a Valid Menu Option");
        }
        return option;
    }


    public static String customerBillSelection() {
        boolean continuesLoop = true;
        String choice = "";

        while (continuesLoop) {

            UserOutput.displayLine("Please Insert a Bill (1, 2, 5, or 10) : ");

            String selectedOption = scanner.nextLine();
            String option = selectedOption.trim();

            switch (option) {
                case "1":
                    choice = "1.00";
                    continuesLoop = false;
                    break;
                case "2":
                    choice = "2.00";
                    continuesLoop = false;
                    break;
                case "5":
                    choice = "5.00";
                    continuesLoop = false;
                    break;
                case "10":
                    choice = "10.00";
                    continuesLoop = false;
                    break;
                default:
                    UserOutput.displayLine("Please select valid bill amount");
            }
        }
        return choice;
    }

    public static String getItemSelection() {
        String selectedOption = "DNE";

        UserOutput.displayMessage("Please make a selection: ");

        String userOptionInput = scanner.nextLine();
        String selectedItemSlot = userOptionInput.trim();

        for (InventoryItem item : Inventory.getInventory()) {
            if (selectedItemSlot.equals(item.getSlotID())) {
                selectedOption = userOptionInput.trim();
            }
        }

        return selectedOption;
    }

}
