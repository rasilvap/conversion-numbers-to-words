package com.numbers.conversion.service.impl;

import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;
import com.numbers.conversion.service.NumbersToWordsService;
import com.numbers.conversion.utils.NumbersToWordsConverter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * NumberToWordsService Service class.
 * @author Rodolfo Silva.
 *
 */
@Service
public class NumberToWordsServiceImp implements NumbersToWordsService {

    private final static Logger logger = LogManager.getLogger(NumbersToWordsConverter.class);

    /**
     * This method starts with the conversion flow invoking the convertNumberToWords method.
     * with the input number param.
     * @param numberDTO input number param to be converted to words.
     * @return The number conversion to words.
     * @throws NumbersToWordsException
     */
    @Override
    public String convertNumbersToEnglishWords(NumberDTO numberDTO) throws NumbersToWordsException {
        logger.info("Calling NumberToWordsService with input params: {}", numberDTO);
        return NumbersToWordsConverter.convertNumberToWords(numberDTO.getNumber());
    }
}
