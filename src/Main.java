import db.DBConnect;
import ui.StartMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("------------ Hello -----------");

            DBConnect.getConnection();
        new StartMenu().show();
	// write your code here
    }
}
