package com.numbers.conversion.utils;

import com.numbers.conversion.exception.NumbersToWordsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.numbers.conversion.utils.Constants.*;
import static com.numbers.conversion.utils.WordsConversion.capitalizeFinalString;

/**
 * NumbersToWordsConverter is the utility class which convert the input number to is equivalent in words.
 */
public class NumbersToWordsConverter {
    private final long number;
    private StringBuffer result = new StringBuffer();
    static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);

    /**
     *
     * @param number input number to be converted to English words.
     * @return the input number in its equivalent English words.
     * @throws NumbersToWordsException
     */
    public static String convertNumberToWords(final long number) throws NumbersToWordsException {
        logger.info("Starting number transformation to words with input number: {}", number);
        return capitalizeFinalString(new NumbersToWordsConverter(number).convertNumberToWords());
    }

    /**
     * This constructor set the current number to be converted to the global number variable.
     */
    private NumbersToWordsConverter(final long number) {
        logger.info("Number to be converted to words: {}", number);
        this.number = number;
    }

    /**
     * This is the main method in with the number to words logic,
     * it is called for each append number method with the current number to be converted.
     * @return
     * @throws NumbersToWordsException
     */
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

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param billions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendBillions(final long billions) throws NumbersToWordsException {
        logger.info("Billions: {}", billions);
        if (billions > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(billions);
            append(billionsConvertor.convertNumberToWords() + Constants.BILLION);
        }
    }

    /**
     * This method appends the million number to the final equivalent string in words.
     * @param millions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendMillions(final long millions) throws NumbersToWordsException {
        logger.info("Millions: {}", millions);
        if (millions > 0) {
            NumbersToWordsConverter millionsConvertor = new NumbersToWordsConverter(millions);
            append(millionsConvertor.convertNumberToWords() + Constants.MILLION);
        }
    }

    /**
     * This method appends the thousand number to the final equivalent string in words.
     * @param thousands  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendThousands(final int thousands) throws NumbersToWordsException {
        logger.info("Thousands: {}", thousands);
        if (thousands > 0) {
            NumbersToWordsConverter thousandsConvertor = new NumbersToWordsConverter(thousands);
            append(thousandsConvertor.convertNumberToWords() + THOUSAND);
        }
    }

    /**
     * This method appends the hundred number to the final equivalent string in words.
     * @param hundreds  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendHundreds(final int hundreds) {
        logger.info("Hundreds: {}", hundreds);
        if (hundreds > 0) {
            append(NUMBERS_UP_TO_19[hundreds] + HUNDRED);
        }
    }

    /**
     * This method appends the tens and units numbers to the final equivalent string in words.
     * @param tensAndUnits the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendTensAndUnits(final int tensAndUnits) {
        if (tensAndUnits > 0 || result.length() == 0) {
            appendWithAnd(convertTensAndUnits(tensAndUnits));
        }
    }

    /**
     * This method append the new word number with a space separator.
     */
    private void append(final String words) {
        logger.info("current number to Words: {}", words);
        appendWithSeparator(words, SEPARATOR);
    }

    /**
     * This method append the new word number with an and space separator.
     * @param words the current accumulated of words converted from the number.
     */
    private void appendWithAnd(final String words) {
        appendWithSeparator(words, AND_SEPARATOR);
    }

    /**
     *
     * @param words the current accumulated of words converted from the number.
     * @param separator the separator could be a space or an and.
     */
    private void appendWithSeparator(final String words, final String separator) {
        if (result.length() > 0) {
            result.append(separator);
        }
        result.append(words);
    }

    /**
     * Converts the Tens and units part to its equivalent in words.
     * @param number
     * @return
     */
    private String convertTensAndUnits(final int number) {
        logger.info("Tens and Units to be converted: {}", number);
        final int tens = number / 10;
        final int units = number - tens * 10;

        if (number < 20) {
            return NUMBERS_UP_TO_19[number];
        } else if (units == 0) {
            return MULTIPLES_OF_10[tens];
        } else {
            return MULTIPLES_OF_10[tens] + SEPARATOR + NUMBERS_UP_TO_19[units];
        }
    }


}
