public class BaseConverter {
    public static void main(String[] args) {
        while (true) {
            String[] userInput = In.getString().split("\\s+");

            if (userInput[0].equalsIgnoreCase("exit")) {
                break;
            }

            int base1 = stringToBase(userInput[0]);
            int num1 = stringToBase(userInput[1], base1);
            char operator = userInput[2].charAt(0);
            int num2 = stringToBase(userInput[3], stringToBase(userInput[4]));
            int base2 = stringToBase(userInput[4]);
            int resultBase = stringToBase(userInput[5]);

            performOperation(base1, num1, operator, num2, base2, resultBase);
        }
    }

    private static int stringToBase(String str) {
        int base = 0;
        for (char c : str.toCharArray()) {
            base = base * 10 + (c - '0');
        }
        return base;
    }

    private static int stringToBase(String str, int base) {
        int num = 0;
        for (char c : str.toCharArray()) {
            num = num * base + (c - '0');
        }
        return num;
    }

    private static void performOperation(int base1, int num1, char operator, int num2, int base2, int resultBase) {
        int decimalNum1 = convertToDecimal(num1, base1);
        int decimalNum2 = convertToDecimal(num2, base2);

        int result = 0;
        if (operator == '+') {
            result = decimalNum1 + decimalNum2;
        } else if (operator == '-') {
            result = decimalNum1 - decimalNum2;
        } else if (operator == '*') {
            result = decimalNum1 * decimalNum2;
        } else if (operator == '/') {
            if (decimalNum2 != 0) {
                result = decimalNum1 / decimalNum2;
            } else {
                System.out.println("Error: Division by zero");
                return;
            }
        } else if (operator == '%') {
            if (decimalNum2 != 0) {
                result = decimalNum1 % decimalNum2;
            } else {
                System.out.println("Error: Modulo by zero");
                return;
            }
        } else {
            System.out.println("Error: Invalid operator");
            return;
        }

        String resultInBase = convertToBase(result, resultBase);

        System.out.println(num1 + " (base " + base1 + ") " + operator + " " + num2 + " (base " + base2 + ")");
        System.out.println("= " + convertToBase(decimalNum1, 10) + " " + operator + " " + convertToBase(decimalNum2, 10));
        System.out.println("= " + result);
        System.out.println("= " + resultInBase + " (base " + resultBase + ")\n");
    }

    private static int convertToDecimal(int number, int base) {
        int decimalNumber = 0;
        int multiplier = 1;

        while (number > 0) {
            int digit = number % 10;
            decimalNumber += digit * multiplier;
            multiplier *= base;
            number /= 10;
        }

        return decimalNumber;
    }

    private static String convertToBase(int number, int base) {
        if (number == 0) {
            return "0";
        }

        int tempNumber = number;
        int numDigits = 0;

        while (tempNumber > 0) {
            tempNumber /= base;
            numDigits++;
        }

        char[] result = new char[numDigits];
        tempNumber = number;

        for (int i = numDigits - 1; i >= 0; i--) {
            int digit = tempNumber % base;
            result[i] = (char) (digit + '0');
            tempNumber /= base;
        }

        return new String(result);
    }
}
