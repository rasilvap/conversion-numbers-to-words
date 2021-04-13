package com.numbers.conversion.utils;

/**
 * Constants file to be used through the Application.
 */
public class Constants {

    private Constants() { }

    // Units of Mapping in words.
    public static final String QUINTILLION = " quintillion";
    public static final String QUADRILLION = " quadrillion";
    public static final String TRILLION = " trillion";
    public static final String BILLION = " billion";
    public static final String MILLION = " million";
    public static final String THOUSAND = " thousand";
    public static final String HUNDRED = " hundred";

    // Units of Mapping in number format.
    public static final Long UNIT_MAPPER_QUINTILLION = 1000000000000000000L;
    public static final Long UNIT_MAPPER_QUADRILLION = 1000000000000000L;
    public static final Long UNIT_MAPPER_TRILLION = 1000000000000L;
    public static final int UNIT_MAPPER_BILLION = 1000000000;
    public static final int UNIT_MAPPER_MILLION = 1000000;
    public static final int UNIT_MAPPER_THOUSAND = 1000;
    public static final int UNIT_MAPPER_HUNDRED = 100;

    // Words separator.
    public static final String AND_SEPARATOR = " and ";
    public static final String SEPARATOR = " ";

    // Maximum allowed value.
    public static final Long MAXIMUM_VALUE_ALLOWED = 9223372036854775807L;

    // Numbers from Zero to nineteen in words format.
    public static final String[] NUMBERS_UP_TO_19 = { "zero", "one", "two",
            "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };

    // Multiples of 10.
    public static final String[] MULTIPLES_OF_10 = { "", "", "twenty", "thirty",
            "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    // Error message to be shown to the user.
    public static final String ERROR_NUMBER_MESSAGE = "The input number exceed allowed value or is not a Number.";
    public static final String STATUS_LABEL = "status";
    public static final String TIMESTAMP_LABEL = "timestamp";
    public static final String MESSAGE_LABEL = "message";


    // Error message to be shown to the user.
    public static final String NEGATIVE_NUMBER= "negative";
}
