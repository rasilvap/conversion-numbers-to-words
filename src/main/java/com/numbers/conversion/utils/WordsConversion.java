package com.numbers.conversion.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.numbers.conversion.utils.Constants.NEGATIVE_NUMBER;
import static com.numbers.conversion.utils.Constants.SEPARATOR;

/**
 * This class contains the methods  to make words transformations.
 */
public class WordsConversion {

    static Logger logger = LogManager.getLogger(WordsConversion.class);

    /**
     * Capitalize the final words converted from the input number. Just the initial word.
     * @param str
     * @return
     */
    public static String capitalizeAndFormatFinalString(String str, boolean isNegative) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (isNegative) {
            str = NEGATIVE_NUMBER + SEPARATOR + str;
        }
        String capitalizedWordsNumber = str.substring(0, 1).toUpperCase() + str.substring(1);
        logger.info("Ending program with capitalized number to words: {}", capitalizedWordsNumber);
        return capitalizedWordsNumber;
    }
}
