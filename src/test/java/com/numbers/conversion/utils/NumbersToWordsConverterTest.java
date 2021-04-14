package com.numbers.conversion.utils;

import com.numbers.conversion.exception.NumbersToWordsException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumbersToWordsConverterTest {
    @Test
    public void convertNumberZero() throws NumbersToWordsException {
        expectConversion(0, "Zero");
    }

    @Test
    public void convertNumberWithJustOneDigit_Ok_NumberIsConvertedToWords() throws NumbersToWordsException {
        expectConversion(1, "One");
        expectConversion(2, "Two");
        expectConversion(3, "Three");
        expectConversion(4, "Four");
        expectConversion(5, "Five");
        expectConversion(6, "Six");
        expectConversion(7, "Seven");
        expectConversion(8, "Eight");
        expectConversion(9, "Nine");
    }

    @Test
    public void convertNumberWithTwoDigitsFromTenToNineteen_ok_NumberIsConvertedToWords() throws NumbersToWordsException {
        expectConversion(10, "Ten");
        expectConversion(11, "Eleven");
        expectConversion(12, "Twelve");
        expectConversion(13, "Thirteen");
        expectConversion(14, "Fourteen");
        expectConversion(15, "Fifteen");
        expectConversion(16, "Sixteen");
        expectConversion(17, "Seventeen");
        expectConversion(18, "Eighteen");
        expectConversion(19, "Nineteen");
    }

    @Test
    public void convertNumbersMultipleOfTenUntilNinety_ok_NumbersAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(20, "Twenty");
        expectConversion(30, "Thirty");
        expectConversion(40, "Forty");
        expectConversion(50, "Fifty");
        expectConversion(60, "Sixty");
        expectConversion(70, "Seventy");
        expectConversion(80, "Eighty");
        expectConversion(90, "Ninety");
    }

    @Test
    public void convertNumbersOfTwoDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(45, "Forty five");
        expectConversion(87, "Eighty seven");
        expectConversion(66, "Sixty six");
        expectConversion(32, "Thirty two");
        expectConversion(85, "Eighty five");
    }

    @Test
    public void convertHundredNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(100, "One hundred");
        expectConversion(200, "Two hundred");
        expectConversion(300, "Three hundred");
        expectConversion(400, "Four hundred");
        expectConversion(500, "Five hundred");
        expectConversion(600, "Six hundred");
        expectConversion(700, "Seven hundred");
        expectConversion(800, "Eight hundred");
        expectConversion(900, "Nine hundred");
    }

    @Test
    public void convertNumbersOfThreeDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(555, "Five hundred and fifty five");
        expectConversion(643, "Six hundred and forty three");
        expectConversion(871, "Eight hundred and seventy one");
        expectConversion(999, "Nine hundred and ninety nine");
        expectConversion(890, "Eight hundred and ninety");
        expectConversion(145, "One hundred and forty five");

    }

    @Test
    public void convertThousandsNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(1000, "One thousand");
        expectConversion(2000, "Two thousand");
        expectConversion(3000, "Three thousand");
        expectConversion(4000, "Four thousand");
        expectConversion(5000, "Five thousand");
        expectConversion(6000, "Six thousand");
        expectConversion(7000, "Seven thousand");
        expectConversion(8000, "Eight thousand");
        expectConversion(9000, "Nine thousand");
    }

    @Test
    public void convertNumbersOfFourDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(1001, "One thousand and one");
        expectConversion(4567, "Four thousand five hundred and sixty seven");
        expectConversion(9999, "Nine thousand nine hundred and ninety nine");
        expectConversion(5237, "Five thousand two hundred and thirty seven");
    }

    @Test
    public void convertNumbersOfFiveDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(12345, "Twelve thousand three hundred and forty five");
        expectConversion(54321, "Fifty four thousand three hundred and twenty one");
        expectConversion(7777, "Seven thousand seven hundred and seventy seven");
    }

    @Test
    public void convertNumbersOfSixDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(654321, "Six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(123456, "One hundred and twenty three thousand four hundred and fifty six");
        expectConversion(898801, "Eight hundred and ninety eight thousand eight hundred and one");
    }

    @Test
    public void convertNumbersOfSevenDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(7654321, "Seven million six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(1234567, "One million two hundred and thirty four thousand five hundred and sixty seven");
        expectConversion(8765450, "Eight million seven hundred and sixty five thousand four hundred and fifty");
    }

    @Test
    public void convertNumbersOfEightDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(87654321, "Eighty seven million six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(11111101, "Eleven million one hundred and eleven thousand one hundred and one");
    }

    @Test
    public void convertNumbersOfNineDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(987654321, "Nine hundred and eighty seven million six hundred and fifty four " +
                "thousand three hundred and twenty one");
        expectConversion(111111001, "One hundred and eleven million one hundred and eleven thousand and one");
    }

    @Test
    public void convertNumbersOfTenDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(9876543210L, "Nine billion eight hundred and seventy six million five hundred " +
                "and forty three thousand two hundred and ten");
        expectConversion(1111110001, "One billion one hundred and eleven million one hundred and ten thousand and one");
    }

    @Test
    public void convertNumbersOfElevenDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(98765432101L, "Ninety eight billion seven hundred and sixty five million four hundred and " +
                "thirty two thousand one hundred and one");
        expectConversion(99999999999L, "Ninety nine billion nine hundred and ninety nine million nine hundred and " +
                "ninety nine thousand nine hundred and ninety nine");
    }

    @Test
    public void convertNumbersOfTwelveDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(987654321012L, "Nine hundred and eighty seven billion six hundred and fifty four " +
                "million three hundred and twenty one thousand and twelve");
        expectConversion(999999999999L, "Nine hundred and ninety nine billion nine hundred " +
                "and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine");

    }

    @Test
    public void convertNumbersOfThirteenFourteenFifteenSixteenSeventeenEighteen_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(9876543210123L, "Nine trillion eight hundred and seventy six billion five hundred and " +
                "forty three million two hundred and ten thousand one hundred and twenty three");
        expectConversion(99999999999999L, "Ninety nine trillion nine hundred and ninety nine billion nine hundred " +
                "and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine");
        expectConversion(289898989893279L, "Two hundred and eighty nine trillion eight hundred and ninety eight " +
                "billion nine hundred and eighty nine million eight hundred and ninety three thousand two hundred and seventy nine");
        expectConversion(7876543290812745L, "Seven quadrillion eight hundred and seventy six trillion five hundred " +
                "and forty three billion two hundred and ninety million eight hundred and twelve thousand seven hundred and forty five");
        expectConversion(69787563567898761L, "Sixty nine quadrillion seven hundred and eighty seven trillion five " +
                "hundred and sixty three billion five hundred and sixty seven million eight hundred and ninety eight thousand seven hundred and sixty one");
        expectConversion(909876541345678901L, "Nine hundred and nine quadrillion eight hundred and seventy six trillion " +
                "five hundred and forty one billion three hundred and forty five million six hundred and seventy eight thousand nine hundred and one");
    }

    @Test
    public void convertNegativeNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(-9876543210123L, "Negative nine trillion eight hundred and seventy six billion five hundred and forty three million two" +
                " hundred and ten thousand one hundred and twenty three");
        expectConversion(-101, "Negative one hundred and one");
        expectConversion(-800, "Negative eight hundred");
        expectConversion(-6666656, "Negative six million six hundred and sixty six thousand six hundred and fifty six");
    }

    @Test
    public void convertNegativeFollowedByPositiveNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(-88763, "Negative eighty eight thousand seven hundred and sixty three");
        expectConversion(100000000, "One hundred million");
    }

    @Test
    public void convertLimitNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(-9223372036854775807L, "Negative nine quintillion two hundred and twenty three " +
                "quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million " +
                "seven hundred and seventy five thousand eight hundred and seven");
        expectConversion(9223372036854775807L, "Nine quintillion two hundred and twenty three quadrillion " +
                "three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred " +
                "and seventy five thousand eight hundred and seven");
    }


    private void expectConversion(final long number, final String expectedWords) throws NumbersToWordsException {
        assertEquals(expectedWords, NumbersToWordsConverter.convertNumberToWords(number));
    }
}