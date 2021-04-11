package com.numbers.conversion.service.impl;

import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;
import com.numbers.conversion.service.NumbersToWordsService;
import com.numbers.conversion.utils.NumbersToWordsConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Service class
 *
 * @author Rodolfo Silva
 *
 */
@Service
public class NumberToWordsServiceImp implements NumbersToWordsService {

    private static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);

    @Override
    public String convertNumbersToEnglishWords(NumberDTO numberDTO) throws NumbersToWordsException {
        logger.info("Calling NumberToWordsService with input params: {}", numberDTO);
        return NumbersToWordsConverter.convertNumberToWords(numberDTO.getNumber());
    }
}
