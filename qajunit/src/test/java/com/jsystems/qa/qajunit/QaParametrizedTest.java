package com.jsystems.qa.qajunit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QaParametrizedTest  extends  ConfigJunit{

    @ParameterizedTest(name = "Parameter with {0}")
    @ValueSource(ints = {5,10,15})
    public void firstParameterizedTest(int number){

        /*    int[] ints = {5,10,15};
            for(int i =0; i<ints.length; i++){
                assertTrue(ints[i] %5 == 0);
            }
*/
        assertTrue(number % 5 == 0);
    }

    @ParameterizedTest(name = "Parameter with {0}")
    @ValueSource(strings = {"Hello", "Hello junit", "Hello students"})
    public void secondParameterizedTest(String text){

        assertTrue(text.contains("Hello"));
    }

    @ParameterizedTest(name = "Parameter with {0} and {1}")
    @CsvSource(value = {"Hello, 5", "Hello junit, 10", "'Hello ,student', 15"}) //delimiter - oznaczenie innego separatora
    public void nextParameterizedTest(String text, int number){
        assertTrue(number % 5 == 0);
        assertTrue(text.contains("Hello"));
    }

    @ParameterizedTest(name = "Parameter with {0} and {1}")
    @CsvFileSource(resources = "/plik.csv")
    public void csvFileParameterizedTest(String text, int number){
        assertTrue(number % 5 == 0);
        assertTrue(text.contains("Hello"));
    }

    @ParameterizedTest(name = "Parameter with {0} and {1}")
    @EnumSource(value = ParamEnum.class)
    public void enumParameterizedTest(ParamEnum enumtype){
        assertTrue(enumtype.toString().contains("ENUM"));

    }

    enum ParamEnum{
        ENUM_ONE,
        ENUM_TWO
    }
}
