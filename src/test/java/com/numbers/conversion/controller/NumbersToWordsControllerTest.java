package com.numbers.conversion.controller;

import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;
import com.numbers.conversion.service.NumbersToWordsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc.perform(post("/numbers-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"number\" : 89\n" +
                        "}")
        )
                .andExpect(status().isOk());
    }

    @Test
    public void testNumbersToWordsEndpoint_numberNotAllowed_thenReturnBadRequest() throws Exception {
        when(numbersToWordsService.convertNumbersToEnglishWords(any(NumberDTO.class))).thenThrow(NumbersToWordsException.class);

        mockMvc.perform(post("/numbers-words")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"number\" : 99999999999999\n" +
                        "}")
        )
                .andExpect(status().isBadRequest());
    }
}