package com.numbers.conversion.utils;


import com.numbers.conversion.exception.NumbersToWordsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.numbers.conversion.utils.Constants.*;

public class NumbersToWordsConverter {
    private final long number;
    private StringBuffer result = new StringBuffer();
    static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);

    public static String convertNumberToWords(final long number) throws NumbersToWordsException {
        logger.info("Starting number transformation to words with input number: {}", number);
        return capitalize(new NumbersToWordsConverter(number).convertNumberToWords());
    }

    private NumbersToWordsConverter(final long number) {
        logger.info("Number to be converted to words: {}", number);
        this.number = number;
    }

    private String convertNumberToWords() throws NumbersToWordsException {
        if (number > MAXIMUM_VALUE_ALLOWED) {
            logger.error("The number {} exceed the allowed value: {}", number, MAXIMUM_VALUE_ALLOWED);
            throw new NumbersToWordsException(ERROR_MESSAGE_EXCEEDED_ALLOWED_VALUE);
        }

        final long billions = number / UNIT_MAPPER_BILLION;
        int remainder = (int) (number % UNIT_MAPPER_BILLION);

        final long millions = remainder / UNIT_MAPPER_MILLION;
        remainder = (int) (number % UNIT_MAPPER_MILLION);
        final int thousands = remainder / UNIT_MAPPER_THOUSAND;
        remainder = remainder % UNIT_MAPPER_THOUSAND;
        final int hundreds = remainder / UNIT_MAPPER_HUNDRED;
        final int tensAndUnits = remainder % UNIT_MAPPER_HUNDRED;

        appendBillions(billions);
        appendMillions(millions);
        appendThousands(thousands);
        appendHundreds(hundreds);
        appendTensAndUnits(tensAndUnits);
        return result.toString();
    }

    private void appendBillions(final long billions) throws NumbersToWordsException {
        logger.info("Billions: {}", billions);
        if (billions > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(billions);
            append(billionsConvertor.convertNumberToWords() + Constants.BILLION);
        }
    }

    private void appendMillions(final long millions) throws NumbersToWordsException {
        logger.info("Millions: {}", millions);
        if (millions > 0) {
            NumbersToWordsConverter millionsConvertor = new NumbersToWordsConverter(millions);
            append(millionsConvertor.convertNumberToWords() + Constants.MILLION);
        }
    }

    private void appendThousands(final int thousands) throws NumbersToWordsException {
        logger.info("Thousands: {}", thousands);
        if (thousands > 0) {
            NumbersToWordsConverter thousandsConvertor = new NumbersToWordsConverter(thousands);
            append(thousandsConvertor.convertNumberToWords() + THOUSAND);
        }
    }

    private void appendHundreds(final int hundreds) {
        logger.info("Hundreds: {}", hundreds);
        if (hundreds > 0) {
            append(NUMBERS_UP_TO_19[hundreds] + HUNDRED);
        }
    }

    private void appendTensAndUnits(final int tensAndUnits) {
        if (tensAndUnits > 0 || result.length() == 0) {
            appendWithAnd(convertTensAndUnits(tensAndUnits));
        }
    }

    private void append(final String words) {
        logger.info("current number to Words: {}", words);
        appendWithSeparator(words, SEPARATOR);
    }

    private void appendWithAnd(final String words) {
        appendWithSeparator(words, AND_SEPARATOR);
    }

    private void appendWithSeparator(final String words, final String separator) {
        if (result.length() > 0) {
            result.append(separator);
        }
        result.append(words);
    }

    private String convertTensAndUnits(final int number) {
        logger.info("Tens and Units: {}", number);
        final int tens = number / 10;
        final int units = number - tens * 10;

        if (number < 20) {
            return NUMBERS_UP_TO_19[number];
        } else if (units == 0) {
            return MULTIPLES_OF_10[tens];
        } else {
            return MULTIPLES_OF_10[tens] + " " + NUMBERS_UP_TO_19[units];
        }
    }

    private static String capitalize(String str) {
        if(str == null || str.isEmpty()) {
            return str;
        }
        String capitalizedWordsNumber = str.substring(0, 1).toUpperCase() + str.substring(1);
        logger.info("Ending program with capitalized number to words: {}", capitalizedWordsNumber);
        return capitalizedWordsNumber;
    }
}
