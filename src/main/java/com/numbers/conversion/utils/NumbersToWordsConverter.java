package com.numbers.conversion.utils;

import com.numbers.conversion.exception.NumbersToWordsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;

import static com.numbers.conversion.utils.Constants.*;
import static com.numbers.conversion.utils.WordsConversion.capitalizeAndFormatFinalString;

/**
 * NumbersToWordsConverter is the utility class which convert the input number to is equivalent in words.
 */
public class NumbersToWordsConverter {
    private final BigInteger number;
    private StringBuffer result = new StringBuffer();
    static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);
    static boolean isNegativeNumber;

    /**
     *
     * @param number input number to be converted to English words.
     * @return the input number in its equivalent English words.
     * @throws NumbersToWordsException
     */
    public static String convertNumberToWords(final BigInteger number) throws NumbersToWordsException {
        isNegativeNumber = (number.signum() == -1) ? true : false;
        logger.info("Starting number transformation to words with input number: {}", number);
        return capitalizeAndFormatFinalString(new NumbersToWordsConverter(number).convertNumberToWords(), isNegativeNumber);
    }

    /**
     * This constructor set the current number to be converted to the global number variable.
     */
    private NumbersToWordsConverter(final BigInteger number) {
        BigInteger bigintegerNumber=new BigInteger(number.toString());
        logger.info("Number to be converted to words: {}", bigintegerNumber);
        this.number = bigintegerNumber.abs();
    }

    /**
     * This is the main method in with the number to words logic,
     * it is called for each append number method with the current number to be converted.
     * @return
     * @throws NumbersToWordsException
     */
    private String convertNumberToWords() throws NumbersToWordsException {
        BigInteger remainder;
        final BigInteger quintillion = number.divide(new BigInteger(UNIT_MAPPER_QUINTILLION.toString()));
        remainder =  number.mod(new BigInteger(UNIT_MAPPER_QUINTILLION.toString()));

        final Long quadrillion = remainder.longValue() / UNIT_MAPPER_QUADRILLION;
        remainder =  number.mod(new BigInteger(UNIT_MAPPER_QUADRILLION.toString()));

        final Long trillions = remainder.longValue() / UNIT_MAPPER_TRILLION;
        remainder =  number.mod(new BigInteger(UNIT_MAPPER_TRILLION.toString()));

        final Long billions = remainder.longValue() / UNIT_MAPPER_BILLION;
        remainder =  number.mod(new BigInteger(UNIT_MAPPER_BILLION.toString()));
        final long millions = remainder.longValue() / UNIT_MAPPER_MILLION;
        remainder =  number.mod(new BigInteger(UNIT_MAPPER_MILLION.toString()));
        final Long thousands =  remainder.longValue() / UNIT_MAPPER_THOUSAND;
        remainder = number.mod(new BigInteger(UNIT_MAPPER_THOUSAND.toString()));
        final Long hundreds =  remainder.longValue() / UNIT_MAPPER_HUNDRED;
        final Long tensAndUnits = remainder.mod(new BigInteger(UNIT_MAPPER_HUNDRED.toString())).longValue();

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
    private void appendQuintillion(final BigInteger quintillion) throws NumbersToWordsException {
        logger.info("Quadrillions: {}", quintillion);
        if (quintillion.signum() > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(quintillion);
            append(billionsConvertor.convertNumberToWords() + QUINTILLION);
        }
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param quadrillion  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendQuadrillion(final Long quadrillion) throws NumbersToWordsException {
        logger.info("Quadrillions: {}", quadrillion);
        if (quadrillion > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(new BigInteger(quadrillion.toString()));
            append(billionsConvertor.convertNumberToWords() + Constants.QUADRILLION);
        }
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param trillions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendTrillions(final Long trillions) throws NumbersToWordsException {
        logger.info("Trillions: {}", trillions);
        if (trillions > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(new BigInteger(trillions.toString()));
            append(billionsConvertor.convertNumberToWords() + Constants.TRILLION);
        }
    }

    /**
     * This method appends the billion number to the final equivalent string in words.
     * @param billions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendBillions(final Long billions) throws NumbersToWordsException {
        logger.info("Billions: {}", billions);
        if (billions > 0) {
            NumbersToWordsConverter billionsConvertor = new NumbersToWordsConverter(new BigInteger(billions.toString()));
            append(billionsConvertor.convertNumberToWords() + Constants.BILLION);
        }
    }

    /**
     * This method appends the million number to the final equivalent string in words.
     * @param millions  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendMillions(final Long millions) throws NumbersToWordsException {
        logger.info("Millions: {}", millions);
        if (millions > 0) {
            NumbersToWordsConverter millionsConvertor = new NumbersToWordsConverter(new BigInteger(millions.toString()));
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
            NumbersToWordsConverter thousandsConvertor = new NumbersToWordsConverter(new BigInteger(thousands.toString()));
            append(thousandsConvertor.convertNumberToWords() + THOUSAND);
        }
    }

    /**
     * This method appends the hundred number to the final equivalent string in words.
     * @param hundreds  the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendHundreds(final Long hundreds) {
        logger.info("Hundreds: {}", hundreds);
        if (hundreds > 0) {
            append(NUMBERS_UP_TO_19[hundreds.intValue()] + HUNDRED);
        }
    }

    /**
     * This method appends the tens and units numbers to the final equivalent string in words.
     * @param tensAndUnits the current billion number to be converted to words.
     * @throws NumbersToWordsException
     */
    private void appendTensAndUnits(final Long tensAndUnits) {
        if (tensAndUnits > 0 || result.length() == 0) {
            appendWithAnd(convertTensAndUnits(tensAndUnits.intValue()));
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
