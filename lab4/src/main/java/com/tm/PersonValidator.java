package com.tm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by tudor.maier on 28/11/2017.
 */
public class PersonValidator {

    private static List<Integer> genderDigits = new ArrayList<>(Arrays.asList(1, 2, 5, 6));

    public static boolean isPersonValid(Person person) {
        return isNameValid(person.getFirstName()) &&
                isNameValid(person.getLastName()) &&
                isNameValid(person.getLastName()) &&
                isCNPValid(person.getCNP()) &&
                isEmailValid(person.getEmail());
    }

    private static boolean isEmailValid(String email) {
        return true;
    }

    private static boolean isCNPValid(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }
        int[] digits = getDigits(cnp);
        if (digits == null) {
            return false;
        } else {
            if (!genderDigits.contains(digits[0])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNameValid(String name) {
        return name != null && name.length() >= 2;
    }

    private static int[] getDigits(String cnp) {
        int[] digits = new int[13];
        for (int i = 0; i < 13; i++) {
            char c = cnp.charAt(i);
            if (!Character.isDigit(c)) {
                return null;
            }
            digits[i] = (byte) Character.digit(c, 10);
        }
        return digits;
    }

    public static Person convertPersonFromRaw(String readObject) {

        Person person = new Person();

        String[] fields = readObject.split("~");
        if (fields.length == 5) {
            person.setFirstName(fields[0]);
            person.setLastName(fields[1]);
            person.setMiddleName(fields[2]);
            person.setCNP(fields[3]);
            person.setEmail(fields[4]);
        }

        return person;
    }
}
