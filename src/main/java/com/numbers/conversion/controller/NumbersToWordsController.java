package com.numbers.conversion.controller;

import com.numbers.conversion.exception.NumbersToWordsException;
import com.numbers.conversion.model.dto.NumberDTO;
import com.numbers.conversion.service.NumbersToWordsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * NumbersToWordsController receives a input number from outside and calls the  numbersToWordsService
 * to start its conversion to English numbers.
 */
@RestController
public class NumbersToWordsController {

	public static final String NUMBERS = "/numbers-words/{number}";

	private final NumbersToWordsService numbersToWordsService;
	static Logger logger = LogManager.getLogger(NumbersToWordsController.class);

	@Autowired
	public NumbersToWordsController(NumbersToWordsService numbersToWordsService) {
		this.numbersToWordsService = numbersToWordsService;
	}

	/**
	 * Endpoint to convert a number to words
	 * @param number the input number from outside.
	 * @return 200 ok if the number was converted to letters, otherwise 400 bad request, if the number is
	 * higher than the allowed Long max and min numbers.
	 */
	@GetMapping(NUMBERS)
	@ResponseBody
	public ResponseEntity<String> numbersWords(@PathVariable Long number) {
		NumberDTO numberDTO = new NumberDTO(number);
		try {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(numbersToWordsService.convertNumbersToEnglishWords(numberDTO));
		} catch (NumbersToWordsException e) {
			logger.error("Ending program with error message: {}", e.getMessage());
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
	}

}
