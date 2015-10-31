/**
 Made by Yakimov Denis, 30/10/2015 for Hillel Java course       Homework 1
 */
package Calculator;

import java.util.Scanner;


public class Calc {

    public static boolean TypeErrorSwitch;

    public static void main(String[] args) {
        //Printing head lines
        System.out.println("JAVACALC");
        System.out.println("Made by Denis Yakimov for Hillel School");
        System.out.println();
        System.out.println("Enter first number, arithmetic operator and second number, you'll get the result. Press \'Enter\' key after each number or operator. Use DOUBLE if you want to.");
        System.out.println("Supported operations: *, /, +, -");
        System.out.println("Example:");
        System.out.println("5 (enter)");
        System.out.println("+ (enter)");
        System.out.println("3 (enter)");
        System.out.println();
        System.out.println("Type \"Q\" or \"q\" for any number or arithmetic operator to close the programm.");
        System.out.println("Don't input brackets!");

        //Creating an endless loop, using method CalcBody
        while (true) CalcBody();
    }

    //Method CalcBody - main function for calculating
    private static void CalcBody() {
        System.out.println();
        System.out.println("Equation:");

        //Initializing variables and boolean error flag
        boolean errthrow;
        double num1 = 0;
        double num2 = 1;
        double result = 0;
        TypeErrorSwitch = false;


        //Initializing SCANNER and filling string variables from it. Strings are tested for application closing flag
        Scanner scanner = new Scanner(System.in);
        String num1s = scanner.next();
        CloseFlag(num1s);

        String per = scanner.next();
        CloseFlag(per);

        String num2s = scanner.next();
        CloseFlag(num2s);


/**
 * THIS BLOCK WAS COMMENTED TO SHOW THE DIFFIRENCE WITHIN TWO WAYS OF SOLVING THE PROBLEM
 * IF THIS WAY, I CREATED A TWO SIMILIAR CODE BLOCKS THAT CHECKING NUM1S AND NUM2S STRINGS
 * IF ANY OF THEM ARE MISMATCHING WITH DOUBLE TYPE, THEN ERRTHROW BOOLEAN GETS TRUE
 *
 * IN SECOND VARIANT, THAT IS WORKING NOW, I CREATED A METHOD WHICH DOING THE SAME THING
 * BUT THE METHOD DIDN'T HAVE THE CLONE AND CALLED FROM CODE MORE EASILY
 *
 *
 * Two TRY-CATCH blocks to make sure first and second numbers are not text
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
 */


        //Calling a DoubleTypeExcept method for each variable num1s and num2s, if there are no errors, then parse them
        errthrow = DoubleTypeExcept(num1s);
        if (!errthrow) num1 = Double.parseDouble(num1s);
        errthrow = DoubleTypeExcept(num2s);
        if (!errthrow) num2 = Double.parseDouble(num2s);
        if (TypeErrorSwitch) System.out.println("TYPE MISMATCH!");


        //SWITCH method with resulting calculation and error checks
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
                    System.out.println("DIVIDING BY ZERO ERROR - NO RESULT!");
                    errthrow = true;
                }
                break;

            case "-":
                result = num1 - num2;
                break;

            default: {
                //Case did not find operator mark, then error is in operator
                System.out.println("\"" + per + "\" is not a valid operator mark!");
                System.out.println("ARITHMETIC OPERATOR MISMATCH!");
                errthrow = true;
            }
        }

        //Output
        if (!errthrow) System.out.println("Result is:" + result);
    }


    //Method for closing application
    private static void CloseFlag(String CFString) {
        CFString = CFString.toUpperCase();
        if (CFString.equals("Q")) {
            System.out.println("Programm closing. Thank you!");
            System.exit(0);
        }
    }


    //Creating a method of TYPE CHECKING which returns a BOOLEAN for error statement, false if it's ok, true if types are mismatching
    private static boolean DoubleTypeExcept(String DTEstring) {
        boolean DTEerror = false;
        try {Double DTEnumber = Double.parseDouble(DTEstring);}
        catch (java.lang.NumberFormatException s) {
                DTEerror = true;
                TypeErrorSwitch = true;
                System.out.println("Number \"" + DTEstring + "\" is not a valid double!");
            }
        return DTEerror;
    }


}