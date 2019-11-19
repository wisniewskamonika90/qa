package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Raport : Junit test")
@Tag("unit")
public class JunitTest {

    final String stringTestowy = "stringTestowy";

    @BeforeAll
    public static void setupAll(){
        System.out.println("==========BeforeAll=======");
    }

    @BeforeEach
    public  void setupEach(){
        System.out.println("==========BeforeEach=======");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("==========AfterAll=======");
    }

    @AfterEach
    public  void tearDownEach(){
        System.out.println("==========AfterEach=======");
    }

    @DisplayName("pierwszy")
    @Test
    //@RepeatedTest(5)
    //@Disabled("bug, 1001")
    public void firstTest(){
        assertTrue(stringTestowy.contains("tr"));
        assertTrue(5 == 2+3,"test 1");
        assertFalse(stringTestowy.contains("z"));
        assertThat(stringTestowy).doesNotContain("z");
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        assertThat(stringTestowy).endsWith("wy");

    }

    @Test
    @Tag("drugi")
    public void secondTest(){;
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertTrue(result == 0.04 );
    }

    @Nested
    class NestedTest{

            List<Integer> list1 = Arrays.asList(1,2,3,4,5);
            List<Integer> list2 = Arrays.asList(3,4,5);

            @Test
            public void firstNestedtest(){
                assertTrue(list1.containsAll(list2));
                assertThat(list1).hasSize(5);
                assertThat(list1).containsAnyOf(1,2,3);
            }

            @Test
            public  void secondNestesTest(){

            }
    }
}
