package com.numbers.conversion.service.impl;

import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NumberToWordsServiceImpTest {
    NumberToWordsServiceImp service;

    @BeforeEach
    public void setUp() {
        service = new NumberToWordsServiceImp();
    }

    @Test
    public void testNumberIsAllowedValue_ok_returnNumbersToWords() throws NumbersToWordsException {
        NumberDTO numberDTO = new NumberDTO(879L);

        assertEquals(service.convertNumbersToEnglishWords(numberDTO),"Eight hundred and seventy nine");
    }
}