package com.numbers.conversion.controller;

import com.numbers.conversion.model.dto.NumberDTO;
import com.numbers.conversion.service.NumbersToWordsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = NumbersToWordsController.class)
class NumbersToWordsControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @MockBean
    NumbersToWordsService numbersToWordsService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNumbersToWordsEndpoint_ok_thenReturnOkStatus() throws Exception {
        when(numbersToWordsService.convertNumbersToEnglishWords(any(NumberDTO.class))).thenReturn("Eighty nine");

        mockMvc.perform(get("/numbers-words/89")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Eighty nine")));
    }

    @Test
    public void testNumbersToWordsEndpoint_numberIsLimitAllowedValue_thenReturnBadRequest() throws Exception {
        when(numbersToWordsService.convertNumbersToEnglishWords(any(NumberDTO.class))).thenReturn("Nine quintillion two hundred and twenty three " +
                "quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four" +
                " million seven hundred and seventy five thousand eight hundred and seven");

        mockMvc.perform(get("/numbers-words/9223372036854775807")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Nine quintillion two hundred and twenty three " +
                        "quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four " +
                        "million seven hundred and seventy five thousand eight hundred and seven")));
    }

    @Test
    public void testNumbersToWordsEndpoint_numberNotAllowed_thenReturnBadRequest() throws Exception {
        when(numbersToWordsService.convertNumbersToEnglishWords(any(NumberDTO.class))).thenReturn("Eighty nine");

        mockMvc.perform(get("/numbers-words/someInvalidInput")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("The input number exceed allowed value or is not a Number")));
    }

    @Test
    public void testNumbersToWordsEndpoint_numberExceedAllowedValue_thenReturnBadRequest() throws Exception {
        when(numbersToWordsService.convertNumbersToEnglishWords(any(NumberDTO.class))).thenReturn("Eighty nine");

        mockMvc.perform(get("/numbers-words/9223372036854775808")).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("The input number exceed allowed value or is not a Number")));
    }
}