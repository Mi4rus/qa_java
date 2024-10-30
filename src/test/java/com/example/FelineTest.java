package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FelineTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> result = feline.eatMeat();
        String [] expectedResult = {"Животные", "Птицы", "Рыба"};
        assertArrayEquals(expectedResult, result.toArray());

    }

    @Test
    void testGetFamily() {
        Feline feline = new Feline();

        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    void testGetKittensReturnOne() {
        Feline feline = new Feline();

        int result = feline.getKittens();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "-1, -1",
            "0, 0"
    })
    public void testGetKittensParametrized(int kittensCount, int expectedResult) {
        Feline feline = new Feline();

        int result = feline.getKittens(kittensCount);
        assertEquals(expectedResult, result);
    }
}