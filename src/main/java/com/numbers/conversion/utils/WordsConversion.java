package com.numbers.conversion.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public static String capitalizeFinalString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String capitalizedWordsNumber = str.substring(0, 1).toUpperCase() + str.substring(1);
        logger.info("Ending program with capitalized number to words: {}", capitalizedWordsNumber);
        return capitalizedWordsNumber;
    }
}
