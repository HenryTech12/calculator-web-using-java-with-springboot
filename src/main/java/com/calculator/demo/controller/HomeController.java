package com.calculator.demo.controller;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.calculator.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {

      private String store_num1 = "";
      private String store_num2 = "";
      private String opt = ""; //STORES OPERATOR
      private String res1 = "";
      private String res2 ="";
      private String res = "";
      private boolean fNegative = false;
      private boolean sNegative = false;
      private String fStr = "";
      private String sStr = "";
      private double num1 = 0;
      private double num2 = 0;
      @Autowired
      private CalculatorService service;
     private Logger log = LoggerFactory.getLogger(HomeController.class);
     
    @RequestMapping("/")
   public String home() {
       return "index.jsp";
   }
   @PostMapping("/calculate")
    public ModelAndView calculate(String del, String operator, String dot, String number) {
        
         double result = 0;

         ModelAndView mv = new ModelAndView();
         mv.setViewName("index.jsp");
         
        if(operator != null) {
          if(fStr != "-" && operator.equals("-") && store_num1 == "") {
                 fStr = "-";
                 fNegative = true;
                 operator = null;
          }
        }
        
       
         System.out.println("GH: "+dot);
         if(operator == null) {
              if(number != null) {
                   if(opt == "") {
                           store_num1 += number;
                           res1 = ""+store_num1;
                       }
                 }
           }
         else {
               if(opt == "") {
                    opt += operator;
                    operator = null;
              }
          }
   
         if(operator != null && store_num1 != "") {
          if(sStr != "-" && opt != "" && operator.equals("-") && store_num1 != "")
             {
                  sStr = "-";
                  sNegative = true;
             }
          }
        
         /* -- OPERATOR FUNCTIONALITY -- */
             if(opt != "")  {
               if(number != null) {
                     store_num2 += number;
                     res2 = ""+store_num2;
               }
             try {
              log.info("SWITCH BLOCK: OPERATORS FUNCTION");
                switch(opt) {
                   case "+":
                        if(store_num1 != "" && store_num2 != "") {
             
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             checkNegative();
                             result = service.add(num1,num2);
                        }
                        break;
                     case "-":
                        if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             checkNegative();
                             result = service.subtract(num1,num2);
                        }
                        break;
                      case "*":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             checkNegative();
                             result = service.multiply(num1,num2);
                        }
                         break;
                       case "/":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             checkNegative();
                             result = service.divide(num1,num2);
                        }
                       break;
                      case "%":
                         if(store_num1 != "" && store_num2 != "") {
                             num1 = Double.parseDouble(store_num1);
                             num2 = Double.parseDouble(store_num2);
                             checkNegative();
                             result = service.getMod(num1,num2);
                        }
                       break;
                      case "C":
                          store_num1 = "";
                          store_num2 = "";
                          opt = "";
                          res = "";
                          res1 = "";
                          res2 = "";
                          fStr = "";
                          sStr = ""; fNegative = false; sNegative= false;
                          service.clear();
                       break;
                    default:
                        result = service.getResult();
                        store_num1 = "";
                        break;
                    }
                } catch(Exception exception) {
                     exception.printStackTrace();
                     log.error("ERROR : Calculator Controller " + exception.getMessage());
               }
           }
             res = fStr+""+res1 + ""+ opt +""+sStr+ "" + res2;
             if(operator != null) {
             if(operator == "e'" || operator.equals("e")) {
                   System.out.println(result);
                   store_num1 = ""+result;
                   if(result == 0) { store_num1 = ""; }
                   store_num2 = "";
                   opt = "";
                   res = ""+result;
                   res1 = ""+result;
                   res2 = "";
                   fStr = "";
                   sStr = ""; fNegative = false; sNegative= false;
               }
            }

           if(dot != null) {
                if(dot == "d" || dot.equals("d")) {
                     if(opt == "") {
                         if(!store_num1.contains(".")) {
                              store_num1 += ".";
                          }
                      }
                     else {
                            if(!store_num2.contains(".")) {
                               store_num2 += ".";
                            }
                       }
                  }
            }
     
          if(del != null) {
             if(store_num1 != "" && opt == "") {    
                     String str = service.delete(store_num1);      
                     store_num1 = str;
                     res1 = store_num1;
                     res = res1 + "" + opt + "" + res2;
                     mv.addObject("value",res);
            }
           if(opt != "")   {
               if(store_num2 != "") {
                    String str = service.delete(store_num2);
                    store_num2 = str;
                    res2 = store_num2;
                    res = res1 + "" + opt + "" + res2;
                    mv.addObject("value",res);
                } else {
                     opt = "";
                     res = res1 + "" + res2;
                     mv.addObject("value",res);
                  }
               }
          }
    
         mv.addObject("value",res);
         System.out.println(store_num1 +" , "+ store_num2);
         return mv;
     }
     public void checkNegative() {
         if(fNegative == true && sNegative == false) {
               num1 = num1 * -1;
          }
         if(fNegative == false && sNegative == true) {
              num2 = num2 * - 1;
         }
         if(fNegative == true && sNegative == true) {
             num1 = num1 * -1;
             num2 = num2 * -1;
         }
     }
    
}