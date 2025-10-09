import java.util.Scanner;

class Calculator {
    // stores the equation in String and the result
    final String eqString;
    final double result;

    // stores key info for calculator: numbers to be operated and
    // if the input for first number and operator are completed.
    double a = 0, b = 0;
    char operation = '+';
    double factor = 1, incrementer = 10;
    boolean a_inp_complete = false, first_operator_complete = false, post_decimal = false;

    // Constructor: Calls the calculator and prints out the result
    Calculator(String equation) {
        eqString = equation;
        result = calculate();
        System.out.println("Your result is: " + result);
    }

    double calculate() {
        // checks which operator is used, converts strings to ints and returns the solution of requested equation.
        if (eqString.contains("+")) {
            operation = '+';
            string_to_double();
            return a + b;
        } else if(eqString.contains("-")) {
            operation = '-';
            string_to_double();
            return a - b;
        } else if(eqString.contains("*")) {
            operation = '*';
            string_to_double();
            return a * b;
        } else if(eqString.contains("/")) {
            operation = '/';
            string_to_double();
            return a / b;
        } else {
            string_to_double();
        }
        return a + b;
    }
    
    // Converts strings to ints
    void string_to_double() {
        // loop to iterate over each character
        for(int i = 0; i < eqString.length(); i++) {
            // if the char is a digit then store the digit else if
            // char is space then continue:)
            // incrementer and factor are used before and after decimal places to
            // convert string to number correctly!
            if (!a_inp_complete && Character.isDigit(eqString.charAt(i))) {
                if (post_decimal) {
                    factor*= 0.1;
                }
                a = (a * incrementer) + (factor * Character.getNumericValue(eqString.charAt(i)));
                continue;
            } // if decimal point is encountered we change some parameters! 
            else if(!a_inp_complete && (Character.compare(eqString.charAt(i), '.') == 0)) {
                post_decimal = true;
                incrementer = 1;
                continue;
            } else if(Character.isSpaceChar(eqString.charAt(i)))
                continue;
            
            // while going through all the characters, if we encounter our operator,
            // it means that our first number is complete and we need to move to next number
            // this condition ensures that we move to next number and only one operator is used...
            if (!first_operator_complete && (Character.compare(eqString.charAt(i), operation) == 0)) {
                a_inp_complete = true;
                first_operator_complete = true;
                post_decimal = false;
                factor = 1;
                incrementer = 10;
                continue;
            }

            // converting string to int for second number and
            // break; if we encounter any characters or operators after 2nd number
            // incrementer and factor are used before and after decimal places to
            // convert string to number correctly!
            if(a_inp_complete && Character.isDigit(eqString.charAt(i))) {
                if (post_decimal) {
                    factor*= 0.1;
                }
                b = (b * incrementer) + (factor * Character.getNumericValue(eqString.charAt(i)));
                continue;
            } // if decimal point is encountered we change some parameters! 
            else if(a_inp_complete && (Character.compare(eqString.charAt(i), '.') == 0)) {
                post_decimal = true;
                incrementer = 1;
                continue;
            } else if(first_operator_complete && b != 0)
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("Welcome to Calculator!");
        System.out.print("Instructions: \n1.Operations are allowed on only 2 numbers at a time! \n"+
        "2.Enter equation using the +, -, *, / operators only! \n"+
        "3.Only one operator allowed at a time! \n"+
        "4.The Code ignores alphabets and spaces!\n\n");

        System.out.print("Enter Your Equation: ");
        String equation = sc.nextLine();
        new Calculator(equation);
        sc.close();
        System.out.println("------------------------------------------");
    }
}