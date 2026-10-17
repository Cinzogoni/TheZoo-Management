package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Validates {

    public static final DateTimeFormatter FMT
            = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    public static boolean isValidDate(String s) {
        try {
            LocalDate.parse(s, FMT);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
