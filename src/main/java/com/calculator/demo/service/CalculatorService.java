package com.calculator.demo.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@Service
public class CalculatorService {
     
     private double result = 0;
     private Logger log = LoggerFactory.getLogger(CalculatorService.class);
     public double add(double num1, double num2) {
        log.info("INFO METHOD: Calculator -: Add Function Is Called");
         result = num1 + num2;
         return result;
     }

    public double subtract(double num1, double num2) {
        log.info("INFO METHOD: Calculator Service -: Minus Function Is Called");
        result = num1 - num2;
        return result;
   }
    
    public double divide (double num1, double num2) {
      log.info("INFO METHOD: Calculator Service-: Division Function Is Called");
       result = num1 / num2;
       return result;
    }

  public double multiply(double num1, double num2) {
      log.info("INFO METHOD: Calculator Service-: Multiplication Function Is Called");
      result = num1 * num2;
      return result;
  }
  public double getMod(double num1, double num2) {
      log.info("INFO METHOD: Calculator Service -: Modulus Function Is Called");
       result = num1 % num2;
       return result;
   }
  public String delete(String str) {
         log.info("INFO METHOD: Calculator Service -: Delete Function Is Called");
         StringBuilder sb = new StringBuilder(str);
         int index = sb.toString().length() - 1;
         sb.deleteCharAt(index);
         return sb.toString();
    }
   public double getResult() {
       return result;
   }
   public void clear() {
         result = 0;
   }
}