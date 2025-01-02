package com.calculator.demo.service;

import org.junit.jupiter.api.*;

public class CalculatorServiceTest {


      private CalculatorService calculatorService;

       @BeforeEach
       void setUp() {
           calculatorService = new CalculatorService();
        }

       @Test
       void addService() {
               Assertions.assertEquals(5, calculatorService.add(2,3));
               Assertions.assertEquals(0, calculatorService.add(0,0));
               Assertions.assertEquals(-1, calculatorService.add(-2,1));
        }
}