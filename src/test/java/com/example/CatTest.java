package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CatTest {
    Cat cat;

    @Mock
    Feline feline;


    @BeforeEach
    public void setUp() {
    cat = new Cat(feline);
    }

    @AfterEach
    public void tearDown() {
        Mockito.reset(feline);
    }

    @Test
    void testGetSound() {
        cat = new Cat(feline);

        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals(expectedResult, actualResult);
        
    }
    @Test
    public void testGetFood() throws Exception{
        cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> result = cat.getFood();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), result);


    }
}