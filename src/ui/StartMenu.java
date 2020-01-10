package ui;

import utils.InputData;

import java.io.IOException;
import java.util.Scanner;

public class StartMenu {
    private SingIn singIn;
    private RegistrationMenu registrationMenu;

    private void printMenu() {
        System.out.println("------------ Star menu -----------");
        System.out.println("1. Sing in");
        System.out.println("2. Registration");
        System.out.println("0. Exit");
    }

    public void show() throws IOException {
        int selection;
        do {
            printMenu();
            selection = InputData.getInputInt();
            switch (selection) {
                case 1: {
                    if (singIn == null) {
                        singIn = new SingIn();
                    }
                    singIn.show();
                    break;
                }

                case 2: {
                    if (registrationMenu != null) registrationMenu = new RegistrationMenu();
                    registrationMenu.show();
                    break;
                }
            }
        } while (selection != 0);

    }





}
