package com.example.mockdemo.messenger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validators
 */
public class Validators {

    public static boolean isNullable(String textToCheck) {
        if(textToCheck != null) return false;
        return true;
    }

    public static boolean isValidURL(String textToCheck){
        int lengthOfEmptyURL = 10;
        String trimmedText = textToCheck.replaceAll("\\s","");
        //Exaple of empty URL: http://.pl
        if((textToCheck.startsWith("http://") || textToCheck.startsWith("https://")) &&
            textToCheck.endsWith(".pl") &&
            trimmedText.length() > lengthOfEmptyURL) return true;

        return false;
    }

    public static boolean isValidMessage(String messageToCheck){
        String trimmedText = messageToCheck.replaceAll("\\s","");

        if (isNullable(messageToCheck) || 
            trimmedText.length() < 3 ||
            !isAlphaNumeric(trimmedText)) return false;
        return true;
    }

    public static boolean isAlphaNumeric(String text){
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        return matcher.matches();
    }
}