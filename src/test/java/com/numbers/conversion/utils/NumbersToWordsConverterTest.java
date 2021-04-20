package com.numbers.conversion.utils;

import com.numbers.conversion.exception.NumbersToWordsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersToWordsConverterTest {
    @Test
    public void convertNumberZero() throws NumbersToWordsException {
        expectConversion(0L, "Zero");
    }

    @Test
    public void convertNumberWithJustOneDigit_Ok_NumberIsConvertedToWords() throws NumbersToWordsException {
        expectConversion(1L, "One");
        expectConversion(2L, "Two");
        expectConversion(3L, "Three");
        expectConversion(4L, "Four");
        expectConversion(5L, "Five");
        expectConversion(6L, "Six");
        expectConversion(7L, "Seven");
        expectConversion(8L, "Eight");
        expectConversion(9L, "Nine");
    }

    @Test
    public void convertNumberWithTwoDigitsFromTenToNineteen_ok_NumberIsConvertedToWords() throws NumbersToWordsException {
        expectConversion(10L, "Ten");
        expectConversion(11L, "Eleven");
        expectConversion(12L, "Twelve");
        expectConversion(13L, "Thirteen");
        expectConversion(14L, "Fourteen");
        expectConversion(15L, "Fifteen");
        expectConversion(16L, "Sixteen");
        expectConversion(17L, "Seventeen");
        expectConversion(18L, "Eighteen");
        expectConversion(19L, "Nineteen");
    }

    @Test
    public void convertNumbersMultipleOfTenUntilNinety_ok_NumbersAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(20L, "Twenty");
        expectConversion(30L, "Thirty");
        expectConversion(40L, "Forty");
        expectConversion(50L, "Fifty");
        expectConversion(60L, "Sixty");
        expectConversion(70L, "Seventy");
        expectConversion(80L, "Eighty");
        expectConversion(90L, "Ninety");
    }

    @Test
    public void convertNumbersOfTwoDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(45L, "Forty five");
        expectConversion(87L, "Eighty seven");
        expectConversion(66L, "Sixty six");
        expectConversion(32L, "Thirty two");
        expectConversion(85L, "Eighty five");
    }

    @Test
    public void convertHundredNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(100L, "One hundred");
        expectConversion(200L, "Two hundred");
        expectConversion(300L, "Three hundred");
        expectConversion(400L, "Four hundred");
        expectConversion(500L, "Five hundred");
        expectConversion(600L, "Six hundred");
        expectConversion(700L, "Seven hundred");
        expectConversion(800L, "Eight hundred");
        expectConversion(900L, "Nine hundred");
    }

    @Test
    public void convertNumbersOfThreeDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(555L, "Five hundred and fifty five");
        expectConversion(643L, "Six hundred and forty three");
        expectConversion(871L, "Eight hundred and seventy one");
        expectConversion(999L, "Nine hundred and ninety nine");
        expectConversion(890L, "Eight hundred and ninety");
        expectConversion(145L, "One hundred and forty five");

    }

    @Test
    public void convertThousandsNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(1000L, "One thousand");
        expectConversion(2000L, "Two thousand");
        expectConversion(3000L, "Three thousand");
        expectConversion(4000L, "Four thousand");
        expectConversion(5000L, "Five thousand");
        expectConversion(6000L, "Six thousand");
        expectConversion(7000L, "Seven thousand");
        expectConversion(8000L, "Eight thousand");
        expectConversion(9000L, "Nine thousand");
    }

    @Test
    public void convertNumbersOfFourDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(1001L, "One thousand and one");
        expectConversion(4567L, "Four thousand five hundred and sixty seven");
        expectConversion(9999L, "Nine thousand nine hundred and ninety nine");
        expectConversion(5237L, "Five thousand two hundred and thirty seven");
    }

    @Test
    public void convertNumbersOfFiveDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(12345L, "Twelve thousand three hundred and forty five");
        expectConversion(54321L, "Fifty four thousand three hundred and twenty one");
        expectConversion(7777L, "Seven thousand seven hundred and seventy seven");
    }

    @Test
    public void convertNumbersOfSixDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(654321L, "Six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(123456L, "One hundred and twenty three thousand four hundred and fifty six");
        expectConversion(898801L, "Eight hundred and ninety eight thousand eight hundred and one");
    }

    @Test
    public void convertNumbersOfSevenDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(7654321L, "Seven million six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(1234567L, "One million two hundred and thirty four thousand five hundred and sixty seven");
        expectConversion(8765450L, "Eight million seven hundred and sixty five thousand four hundred and fifty");
    }

    @Test
    public void convertNumbersOfEightDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(87654321L, "Eighty seven million six hundred and fifty four thousand three hundred and twenty one");
        expectConversion(11111101L, "Eleven million one hundred and eleven thousand one hundred and one");
    }

    @Test
    public void convertNumbersOfNineDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(987654321L, "Nine hundred and eighty seven million six hundred and fifty four " +
                "thousand three hundred and twenty one");
        expectConversion(111111001L, "One hundred and eleven million one hundred and eleven thousand and one");
    }

    @Test
    public void convertNumbersOfTenDigits_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(9876543210L, "Nine billion eight hundred and seventy six million five hundred " +
                "and forty three thousand two hundred and ten");
        expectConversion(1111110001L, "One billion one hundred and eleven million one hundred and ten thousand and one");
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
        expectConversion(-101L, "Negative one hundred and one");
        expectConversion(-800L, "Negative eight hundred");
        expectConversion(-6666656L, "Negative six million six hundred and sixty six thousand six hundred and fifty six");
    }

    @Test
    public void convertNegativeFollowedByPositiveNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(-88763L, "Negative eighty eight thousand seven hundred and sixty three");
        expectConversion(100000000L, "One hundred million");
    }

    @Test
    public void convertLimitNumbers_ok_NumberAreConvertedToWords() throws NumbersToWordsException {
        expectConversion(-9223372036854775808L, "Negative nine quintillion two hundred and twenty three " +
                "quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million " +
                "seven hundred and seventy five thousand eight hundred and eight");
        expectConversion(9223372036854775807L, "Nine quintillion two hundred and twenty three quadrillion " +
                "three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred " +
                "and seventy five thousand eight hundred and seven");
    }


    private void expectConversion(final Long number, final String expectedWords) throws NumbersToWordsException {
        assertEquals(expectedWords, NumbersToWordsConverter.convertNumberToWords(number));
    }
}