package com.numbers.conversion.utils;

/**
 * Constants file to be used through the Application.
 */
public class Constants {

    private Constants() { }

    // Units of Mapping in words.
    public static final String BILLION = " billion";
    public static final String MILLION = " million";
    public static final String THOUSAND = " thousand";
    public static final String HUNDRED = " hundred";

    // Units of Mapping in number format.
    public static final int UNIT_MAPPER_BILLION = 1000000000;
    public static final int UNIT_MAPPER_MILLION = 1000000;
    public static final int UNIT_MAPPER_THOUSAND = 1000;
    public static final int UNIT_MAPPER_HUNDRED = 100;

    // Words separator.
    public static final String AND_SEPARATOR = " and ";
    public static final String SEPARATOR = " ";

    // Maximum allowed value.
    public static final long MAXIMUM_VALUE_ALLOWED = 999999999999L;

    // Numbers from Zero to nineteen in words format.
    public static final String[] NUMBERS_UP_TO_19 = { "zero", "one", "two",
            "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };

    // Multiples of 10.
    public static final String[] MULTIPLES_OF_10 = { "", "", "twenty", "thirty",
            "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    // Error message to be shown to the user.
    public static final String ERROR_MESSAGE_EXCEEDED_ALLOWED_VALUE = "Number exceed allowed value.";
}
