package com.numbers.conversion.model.dto;

import lombok.Getter;

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

    private Long number;

    @Override
    public String toString() {
        return "NumberDTO{" +
                "number=" + number +
                '}';
    }
}
