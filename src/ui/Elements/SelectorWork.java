package ui.Elements;

import java.util.Scanner;

public abstract class SelectorWork {
    private void Menu() {
        System.out.println("---------  Work menu ---------");
        System.out.println("1. Show all");
        System.out.println("2. Add");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("0. return to main menu");
    }

    public void show(Scanner scanner) {
        int answer;

        do {
            Menu();
            answer = scanner.nextInt();

            switch (answer) {
                case 1: {
                    view();
                    break;
                }

                case 2: {
                    add(scanner);
                    break;
                }

                case 3: {
                    update(scanner);
                    break;
                }

                case 4: {
                    delete(scanner);
                    break;
                }
            }
        } while (answer != 0);
    }
    protected abstract void view();
    protected abstract void add(Scanner scanner);
    protected abstract void update(Scanner scanner);
    protected abstract void delete(Scanner scanner);
}
