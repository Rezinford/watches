package ui;

import ui.Elements.CountriesMenu;
import ui.Elements.CustomersMenu;
import ui.Elements.VendorMenu;
import ui.Elements.WatchesMenu;
import utils.InputData;

import java.io.IOException;
import java.util.Scanner;

public class SelectorElementMenu {
    private CountriesMenu countriesMenu;
    private VendorMenu vendorMenu;
    private CustomersMenu customersMenu;
    private WatchesMenu watchesMenu;

    private void viewMenu() {
        System.out.println("------------ Main menu -----------");
        System.out.println("1. Countries");
        System.out.println("2. Vendors");
        System.out.println("3. Customers");
        System.out.println("4. Watches");
        System.out.println("5. Orders");
        System.out.println("0. return to main menu");
    }

    public void show() throws IOException {
        int selection;
        do {
            viewMenu();
            selection =InputData.getInputInt();
            switch (selection) {
                case 1: {
                    if (countriesMenu == null) countriesMenu = new CountriesMenu();
                    countriesMenu.show();
                    break;
                }
                case 2: {
                    if (vendorMenu == null) vendorMenu = new VendorMenu();
                    vendorMenu.show();
                    break;
                }
                case 3: {
                    if (countriesMenu == null) countriesMenu = new CountriesMenu();
                    customersMenu.show();
                    break;
                }
                case 4: {
                    if (watchesMenu == null) watchesMenu = new WatchesMenu();
                    watchesMenu.show();
                    break;
                }
                case 5: {
                    //todo: add orders menu
                    break;
                }
            }
        } while (selection != 0);

    }
}
