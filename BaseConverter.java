class BaseConverter {

    static int convertToBase10(int num, int base) {
        int result = 0;
        int multiplier = 1;

        while (num > 0) {
            int digit = num % 10;
            result += digit * multiplier;
            multiplier *= base;
            num /= 10;
        }

        return result;
    }

    static String convertToBase(int num, int base) {
        String result = "";

        while (num > 0) {
            int digit = num % base;
            result = digit + result;
            num /= base;
        }

        return result.isEmpty() ? "0" : result;
    }

    static int performOperation(int num1, int num2, char operator) {
        int result = 0;
        if (operator == '+') result = num1 + num2;
        else if (operator == '-') result = num1 - num2;
        else if (operator == '*') result = num1 * num2;
        else if (operator == '/') {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                System.out.println("Error: Division by zero is not allowed.");
                return 0;  // Return 0 to indicate an error
            }
        } else if (operator == '%') {
            if (num2 != 0) {
                result = num1 % num2;
            } else {
                System.out.println("Error: Modulo operation with zero is not allowed.");
                return 0;  // Return 0 to indicate an error
            }
        } else {
            System.out.println("Error: Invalid operator. Use +, -, *, /, or %.");
            return 0;  // Return 0 to indicate an error
        }
        return result;
    }

    static void displayResult(int num1, int base, char operator, int num2, int resultBase, int result) {
        System.out.println();
        System.out.println("Enter the base for both input numbers (2 to 10): ");
        int baseInput = In.getInt();
        System.out.println("Enter the first number (base " + baseInput + "): ");
        int num1Input = In.getInt();
        System.out.println("Enter the operator (+, -, *, /, %): ");
        char operatorInput = In.getChar();
        System.out.println("Enter the second number (base " + baseInput + "): ");
        int num2Input = In.getInt();
        System.out.println("Enter the base for the output number (2 to 10): ");
        int resultBaseInput = In.getInt();
        System.out.println();

        if (baseInput < 2 || baseInput > 10 || resultBaseInput < 2 || resultBaseInput > 10) {
            System.out.println("Error: Invalid base. Bases must be between 2 and 10.");
            return;  // End the program due to invalid base
        }

        int num1Base10 = convertToBase10(num1Input, baseInput);
        int num2Base10 = convertToBase10(num2Input, baseInput);
        int resultBase10 = performOperation(num1Base10, num2Base10, operatorInput);

        if (resultBase10 != 0) {
            displayResult(num1Input, baseInput, operatorInput, num2Input, resultBaseInput, resultBase10);
        }
    }

    public static void main(String[] args) {
        int num1, num2, resultBase;
        char operator;

        System.out.print("Enter the base for both input numbers (2 to 10): ");
        int base = In.getInt();
        System.out.print("Enter the first number (base " + base + "): ");
        num1 = In.getInt();
        System.out.print("Enter the operator (+, -, *, /, %): ");
        operator = In.getChar();
        System.out.print("Enter the second number (base " + base + "): ");
        num2 = In.getInt();
        System.out.print("Enter the base for the output number (2 to 10): ");
        resultBase = In.getInt();

        if (base < 2 || base > 10 || resultBase < 2 || resultBase > 10) {
            System.out.println("Error: Invalid base. Bases must be between 2 and 10.");
            return;  // End the program due to invalid base
        }

        int num1Base10 = convertToBase10(num1, base);
        int num2Base10 = convertToBase10(num2, base);
        int resultBase10 = performOperation(num1Base10, num2Base10, operator);

        if (resultBase10 != 0) {
            displayResult(num1, base, operator, num2, resultBase, resultBase10);
        }
    }
}