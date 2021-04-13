package com.numbers.conversion.utils;

import com.numbers.conversion.exception.NumbersToWordsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.numbers.conversion.utils.Constants.*;
import static com.numbers.conversion.utils.WordsConversion.capitalizeAndFormatFinalString;

/**
 * NumbersToWordsConverter is the utility class which convert the input number to is equivalent in words.
 */
public class NumbersToWordsConverter {
    private final Long number;
    private StringBuffer result = new StringBuffer();
    static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);
    static boolean isNegativeNumber;

    /**
     *
     * @param number input number to be converted to English words.
     * @return the input number in its equivalent English words.
     * @throws NumbersToWordsException
     */
    public static String convertNumberToWords(final Long number) throws NumbersToWordsException {
        isNegativeNumber = (number < 0) ? true : false;
        logger.info("Starting number transformation to words with input number: {}", number);
        return capitalizeAndFormatFinalString(new NumbersToWordsConverter(number).convertNumberToWords(), isNegativeNumber);
    }

    /**
     * This constructor set the current number to be converted to the global number variable.
     */
    private NumbersToWordsConverter(final Long number) {
        logger.info("Number to be converted to words: {}", number);
        this.number = Math.abs(number);
    }

    /**
     * This is the main method in with the number to words logic,
     * it is called for each append number method with the current number to be converted.
     * @return
     * @throws NumbersToWordsException
     */
    private String convertNumberToWords() throws NumbersToWordsException {
        Long remainder = 0L;
        final Long quintillion = number / UNIT_MAPPER_QUINTILLION;
        remainder =  (number % UNIT_MAPPER_QUINTILLION);

        final Long quadrillion = remainder / UNIT_MAPPER_QUADRILLION;
        remainder =  (number % UNIT_MAPPER_QUADRILLION);

        final Long trillions = remainder / UNIT_MAPPER_TRILLION;
        remainder =  (number % UNIT_MAPPER_TRILLION);

        final Long billions = remainder / UNIT_MAPPER_BILLION;
        remainder =  (number % UNIT_MAPPER_BILLION);
        final long millions = remainder / UNIT_MAPPER_MILLION;
        remainder =  (number % UNIT_MAPPER_MILLION);
        final Long thousands =  (remainder / UNIT_MAPPER_THOUSAND);
        remainder = remainder % UNIT_MAPPER_THOUSAND;
        final int hundreds = (int) (remainder / UNIT_MAPPER_HUNDRED);
        final int tensAndUnits = (int) (remainder % UNIT_MAPPER_HUNDRED);

        appendQuintillion(quintillion);
        appendQuadrillion(quadrillion);
        appendTrillions(trillions);
        appendBillions(billions);
        appendMillions(millions);
        appendThousands(thousands);
        appendHundreds(hundreds);
        appendTensAndUnits(tensAndUnits);
        return result.toString();
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param quintillion  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendQuintillion(final long quintillion) throws NumbersToWordsException {
        logger.info("Quadrillions: {}", quintillion);
        if (quintillion > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(quintillion);
            append(billionsConvertor.convertNumberToWords() + QUINTILLION);
        }
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param quadrillion  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendQuadrillion(final long quadrillion) throws NumbersToWordsException {
        logger.info("Quadrillions: {}", quadrillion);
        if (quadrillion > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(quadrillion);
            append(billionsConvertor.convertNumberToWords() + Constants.QUADRILLION);
        }
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param trillions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendTrillions(final long trillions) throws NumbersToWordsException {
        logger.info("Trillions: {}", trillions);
        if (trillions > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(trillions);
            append(billionsConvertor.convertNumberToWords() + Constants.TRILLION);
        }
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
    private void appendThousands(final Long thousands) throws NumbersToWordsException {
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
