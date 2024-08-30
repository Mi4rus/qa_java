package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class LionTest {
    private Lion lion;

    @Mock
    private Feline feline;

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion(feline);
    }

    @AfterEach
    public void tearDown() throws Exception {
        Mockito.reset(feline);
    }

    @Test
    public void testGetKittens() {
        //given
        Mockito.when(feline.getKittens()).thenReturn(1);
        //when
        int result = lion.getKittens();
        //then
        assertEquals(1, result);
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testDoesHaveManeDefault() {
        boolean result = lion.doesHaveMane();

        assertFalse(result);
    }
    @Test
    public void testDoesHaveManeThrowsException() throws Exception {
        Lion lion;

        Exception exception = assertThrows(Exception.class,()-> new Lion("Другой пол"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка",exception.getMessage());

    }

    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    public void testDoesHaveManeWithSex(String sex, boolean expectedResult) throws Exception {
        Lion lion = new Lion(sex);

        boolean result = lion.doesHaveMane();
        assertEquals(expectedResult,result);

    }



    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Хищник"));

        List<String> result = lion.getFood();

        assertEquals(List.of("Хищник"), result);
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}