package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("UnitTest")
public class TaskOneTest {


    @Test
    public void zad1(){
        String resultString = new String("result of test 154% success");
        String expectedString = new String ("result od test [number]% success");

        assertTrue(resultString.startsWith("result of test"));
        assertTrue(resultString.endsWith("success"));
        assertThat(resultString).matches("(result of test )\\d+(% success)");

        String result = resultString.replace("result of test ", "").replace("% success", "");
        System.out.println(result);
        int resultNumber = Integer.parseInt(result);
        assertTrue(resultNumber >0);
    }
}
