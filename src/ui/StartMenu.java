package ui;

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

    public void show(Scanner scanner) {
        int selection;
        do {
            printMenu();
            selection = scanner.nextInt();

            switch (selection) {
                case 1: {
                    if (singIn != null) singIn = new SingIn();
                    singIn.show(scanner);
                    break;
                }

                case 2: {
                    if (registrationMenu != null) registrationMenu = new RegistrationMenu();
                    registrationMenu.show(scanner);
                    break;
                }
            }
        } while (selection != 0);

    }





}
