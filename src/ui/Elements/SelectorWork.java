package ui.Elements;

import utils.InputData;

import java.io.IOException;
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

    public void show() throws IOException {
        int answer;

        do {
            Menu();
            answer = InputData.getInputInt();

            switch (answer) {
                case 1: {
                    view();
                    break;
                }
                case 2: {
                    add();
                    break;
                }
                case 3: {
                    update();
                    break;
                }
                case 4: {
                    delete();
                    break;
                }
            }
        } while (answer != 0);
    }
    protected abstract void view()throws IOException;
    protected abstract void add() throws IOException;
    protected abstract void update()throws IOException;
    protected abstract void delete()throws IOException;
}
