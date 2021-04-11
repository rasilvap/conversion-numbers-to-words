package com.numbers.conversion.utils;

public class Constants {

    private Constants() { }

    public static final String BILLION = " billion";
    public static final String MILLION = " million";
    public static final String THOUSAND = " thousand";
    public static final String HUNDRED = " hundred";

    public static final String AND_SEPARATOR = " and ";
    public static final String SEPARATOR = " ";

    public static final int UNIT_MAPPER_BILLION = 1000000000;
    public static final int UNIT_MAPPER_MILLION = 1000000;
    public static final int UNIT_MAPPER_THOUSAND = 1000;
    public static final int UNIT_MAPPER_HUNDRED = 100;

    public static final long MAXIMUM_VALUE_ALLOWED = 999999999999L;

    public static final String[] NUMBERS_UP_TO_19 = { "zero", "one", "two",
            "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };
    public static final String[] MULTIPLES_OF_10 = { "", "", "twenty", "thirty",
            "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    public static final String ERROR_MESSAGE_EXCEEDED_ALLOWED_VALUE = "Number exceed allowed value.";
}
