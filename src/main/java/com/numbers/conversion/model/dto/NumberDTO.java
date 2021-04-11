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
    public NumberDTO(long number) {
        this.number = number;
    }

    /**
     * NumberDTO class constructor with empty params.
     */
    public NumberDTO(){}

    private long number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberDTO numberDTO = (NumberDTO) o;
        return number == numberDTO.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "NumberDTO{" +
                "number=" + number +
                '}';
    }
}
