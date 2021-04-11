package com.numbers.conversion.dto;

import lombok.Getter;

import java.util.Objects;

/**
 * This class receives the request object from outside.
 */
@Getter
public class NumberDTO {

    public NumberDTO(long number) {
        this.number = number;
    }

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
