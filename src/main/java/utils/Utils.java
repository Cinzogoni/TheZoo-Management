package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {

    public static String checkInputString(String desc, Scanner scan,
            String mode, String defaultValue) {

        while (true) {
            System.out.print(desc);
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                if ("modeA".equalsIgnoreCase(mode)) {
                    System.out.println("Khong duoc bo trong!");
                    continue;
                } else if ("modeB".equalsIgnoreCase(mode)) {
                    return null;
                } else if ("modeC".equalsIgnoreCase(mode)) {
                    return defaultValue;
                }
            }
            return input;
        }
    }

    public static LocalDate checkInputDate(String desc, Scanner scan,
            String mode, LocalDate defaultValue) {

        while (true) {
            System.out.print(desc);
            String input = scan.nextLine().trim();

            if (input.isEmpty()) {
                if ("modeAa".equalsIgnoreCase(mode)) {
                    System.out.println("Khong duoc bo trong!");
                    continue;
                } else if ("modeBb".equalsIgnoreCase(mode)) {
                    return defaultValue;
                }
            }

            if (Validates.isValidDate(input)) {
                return LocalDate.parse(input, Validates.FMT);
            }
            System.out.println("Ngau sinh khong jop le!");
        }
    }
}
