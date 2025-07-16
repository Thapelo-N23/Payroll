package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;

public class Helper {
    public static boolean isNullOrEmpty(String str) {
        if (str.isEmpty() || str == null)
            return true;
        return false;
    }

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
    return true;
        } else {
return false;        }
    }

    public static LocalDate getDateOfBirth(String id){
    int year = Integer.parseInt(id.substring(0,2));
    int month = Integer.parseInt(id.substring(2,4));
    int day = Integer.parseInt(id.substring(4,6));
    LocalDate date = LocalDate.of(year, month, day);
    return date;
    }
}