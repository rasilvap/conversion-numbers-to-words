package com.numbers.conversion.service;


import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;

/**
 * NumberToWordService Interface.
 * @author rodolfo Silva.
 *
 */
public interface NumbersToWordsService {
    /**
     * Convert English number into Words.
     * @param numberDTO input param.
     * @return number in words as string.
     */
    String convertNumbersToEnglishWords(NumberDTO numberDTO) throws NumbersToWordsException;
}
