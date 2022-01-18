package com.techelevator.application;

import com.techelevator.logger.VendingLogger;
import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import com.techelevator.models.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {


    VendingLogger logger = new VendingLogger("inventoryTest.txt");


    public void run() {
        Inventory.initializeInventory();

        while (true) {
            UserOutput.displayHomeScreen();     // this is just the banner
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                UserOutput.displayItems();
            } else if (choice.equals("purchase")) {
                runPurchaseMenu();
            } else if (choice.equals("exit")) {
                logger.write("\\'\\'\\'");
                try {
                    logger.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Good Bye!");
                break;
            }
        }
    }

    public static void runPurchaseMenu() {
        boolean doesLoop = true;

        while (doesLoop) {
            String option = UserInput.getPurchaseMenuOption();
            if (option.equals("Feed Money")) {
                String billChoice = UserInput.customerBillSelection();
                Cash.increaseBalance(billChoice);
            } else if (option.equals("Select Product")) {
                UserOutput.displayItems();
                Cash.dispenseItem(UserInput.getItemSelection());
            } else if (option.equals("Finish Transaction")) {
                completeTransaction();
                doesLoop = false;
            } else {
                UserOutput.displayLine("Please Select a Valid Menu Option");
            }
        }
    }

    private static void completeTransaction() {
        if (Cash.getCurrentBalance().compareTo(BigDecimal.ZERO) != 0) {
            UserOutput.displayMessage(Change.makeChange(Cash.getCurrentBalance()));
            Cash.setCurrentBalance(new BigDecimal(0.00));
        } else {
            UserOutput.displayMessage("No remaining balance. Have a great day!");
        }
    }


} //class
