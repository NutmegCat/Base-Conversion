class BaseConverter {

    // method to check if the given number is valid for the specified base
    static boolean isValidNumber(int num, int base) {
        // iterate through each digit of the number
        while (num > 0) {
            int digit = num % 10;
            // check if the digit is greater than or equal to the specified base
            if (digit >= base) {
                return false; // invalid digit for the given base
            }
            num /= 10;
        }
        return true; // all digits are valid
    }

    // method to convert a number from a specified base to base 10
    static int convertToBase10(int num, int base) {
        int result = 0;
        int multiplier = 1;

        // iterate through each digit of the number
        while (num > 0) {
            int digit = num % 10;
            // convert the digit to base 10 and accumulate the result
            result += digit * multiplier;
            multiplier *= base;
            num /= 10;
        }

        return result;
    }

    // method to convert a number from base 10 to a specified base
    static String convertToBase(int num, int base) {
        String result = "";

        // iterate until the number is greater than 0
        while (num > 0) {
            // extract the remainder when dividing by the specified base
            int digit = num % base;
            // prepend the digit to the result string
            result = digit + result;
            // update the number by dividing it by the specified base
            num /= base;
        }

        // if the result is empty, return "0" to represent the base 10 zero
        return result.isEmpty() ? "0" : result;
    }

    // method to perform the arithmetic operation based on the operator
    static int performOperation(int num1, int num2, char operator) {
        int result = 0;
        // perform the specified arithmetic operation
        if (operator == '+')
            result = num1 + num2;
        else if (operator == '-')
            result = num1 - num2;
        else if (operator == '*')
            result = num1 * num2;
        else if (operator == '/') {
            // check for division by zero
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("error: division by zero is not allowed.");
                return 0; // return 0 to indicate an error
            }
        } else if (operator == '%') {
            // check for modulo operation with zero
            if (num2 != 0) {
                result = num1 % num2;
            } else {
                System.out.println("error: modulo operation with zero is not allowed.");
                return 0; // return 0 to indicate an error
            }
        } else {
            System.out.println("error: invalid operator. use +, -, *, /, or %.");
            return 0; // return 0 to indicate an error
        }
        return result;
    }

    // method to display the result of the arithmetic operation
    static void displayResult(int num1, int base, char operator, int num2, int outputBase, int result) {
        System.out.println();
        System.out.println("performing calculation...");
        System.out.println();
        // display the input expression
        System.out
                .println("         " + num1 + " (base " + base + ") " + operator + " " + num2 + " (base " + base + ")");
        System.out.println();
        // display the converted input numbers in base 10
        System.out.println(
                "         = " + convertToBase10(num1, base) + " " + operator + " " + convertToBase10(num2, base));
        System.out.println();
        // display the result in base 10
        System.out.println("         = " + result);
        System.out.println();
        // display the result in the desired output base
        System.out.println("         = " + convertToBase(result, outputBase) + " (base " + outputBase + ")");
        System.out.println();
    }

    // main method to execute the program
    public static void main(String[] args) {
        int num1, num2, base, outputBase;
        char operator;

        // input for the base and numbers
        System.out.print("enter the base for both input numbers (2 to 10): ");
        base = In.getInt();
        System.out.print("enter the first number (base " + base + "): ");
        num1 = In.getInt();

        // validate the first number
        if (!isValidNumber(num1, base)) {
            System.out.println("error: invalid number for the given base.");
            return; // end the program due to invalid number
        }

        System.out.print("enter the operator (+, -, *, /, %): ");
        operator = In.getChar();
        System.out.print("enter the second number (base " + base + "): ");
        num2 = In.getInt();

        // validate the second number
        if (!isValidNumber(num2, base)) {
            System.out.println("error: invalid number for the given base.");
            return; // end the program due to invalid number
        }

        System.out.print("enter the desired output base (2 to 10): ");
        outputBase = In.getInt();

        // validate bases
        if (base < 2 || base > 10 || outputBase < 2 || outputBase > 10) {
            System.out.println("error: invalid base. bases must be between 2 and 10.");
            return; // end the program due to invalid base
        }

        // perform the arithmetic operation
        int num1Base10 = convertToBase10(num1, base);
        int num2Base10 = convertToBase10(num2, base);
        int resultBase10 = performOperation(num1Base10, num2Base10, operator);

        // display the result
        if (resultBase10 != 0) {
            displayResult(num1, base, operator, num2, outputBase, resultBase10);
        }
    }
}