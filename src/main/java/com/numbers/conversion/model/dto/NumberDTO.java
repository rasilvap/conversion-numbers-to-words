package com.numbers.conversion.model.dto;

import lombok.Getter;

import java.util.Objects;

/**
 * This class receives the request object from outside.
 */
@Getter
public class NumberDTO {

    /**
     * NumberDTO class constructor with params.
     * @param number
     */
    public NumberDTO(Long number) {
        this.number = number;
    }

    /**
     * NumberDTO class constructor with empty params.
     */
    public NumberDTO(){}

    private long number;

    @Override
    public String toString() {
        return "NumberDTO{" +
                "number=" + number +
                '}';
    }
}
