package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getInputString() throws IOException {
        String line;
        while (true) {
            line = reader.readLine();
            if (line.length()>0) {
                return line;
            }
        }
    }

    public static int getInputInt() throws IOException {
        String line;
        String pattern = "[0-9]";
        Pattern ptrn = Pattern.compile(pattern);
        while (true) {
            line = getInputString();
            Matcher matcher = ptrn.matcher(line);
            if ((matcher.find())) {
                int num = Integer.parseInt(line);
                return num;
            }
        }
    }

}
