
/**
 Made by Yakimov Denis, 30/10/2015 for Hillel Java course
 Homework 1
 */
package Calculator;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        //Printing head lines
        System.out.println("Hillel Java Calculator");
        System.out.println("Made by Denis Yakimov");
        System.out.println();
        System.out.println("Enter first number, operation mark and second number, you'll get the result. Press \'Enter\' key after each number of mark. Use double if you want to.");
        System.out.println("Supported operations: *, /, +, -");
        System.out.println("Example: \"32\"(enter), \"+\"(enter), \"12\"(enter). Don't input double brackets!");
        System.out.println("Equation:");

        //Initializing variables and boolean error flag
        boolean errthrow = false;
        double num1, num2, result = 0;


        //Initializing SCANNER and filling string variables from it.
        Scanner scanner = new Scanner(System.in);
        String num1s = scanner.next();
        String per = scanner.next();
        String num2s = scanner.next();

        //Two TRY-CATCH blocks to make sure first and second numbers are not text
        try {num1 = Double.parseDouble(num1s);}
        catch (java.lang.NumberFormatException s) {
            num1=0;
            errthrow = true;
            System.out.println("Number \"" + num1s + "\" is not a valid double!");
        }

        try {num2 = Double.parseDouble(num2s);}
        catch (java.lang.NumberFormatException s) {
            num2=0;
            errthrow = true;
            System.out.println("Number \"" + num2s + "\" is not a valid double!");
        }

        //SWITCH method with resulting calculation and error checks
        if (errthrow)
        {
            //If error is here, then it's due to error in numbers type mismatch
            System.out.println("TYPE MISMATCH!");
        }
        else
        {
            switch (per) {
                case "+":
                    result = num1 + num2;
                    break;

                case "*":
                    result = num1 * num2;
                    break;

                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        //Throwing dividing by zero error, use the same boolean though
                        System.out.println("Oh, sh1t, you divided by zero@#$u...");
                        errthrow = true;
                    }
                    break;

                case "-":
                    result = num1 - num2;
                    break;

                default: {
                    //Case did not find operator mark, then error is in operator
                    System.out.println("\""+ per +"\" is not a valid operator mark!");
                    errthrow = true;
                }
            }
        }

        System.out.println();
        //Output
        if (errthrow) System.out.println("ERROR IN STATEMENT! Programm will be closed without result.");
        else System.out.println("Result is:" + result);
    }
}
