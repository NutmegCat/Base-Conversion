Write a program that will perform arithmetic operations on pairs of integers written in various number bases. Input to the program should consist of an arbitrary number of expressions, each of which is written on one line. Each expression should consist of the following five items separated by one or more blanks:

- an input base: 2 to 10
- a first integer, written in the input base
- an operator: +, -, *, /, %
- a second integer, written in the input base
- an output base: 2 to 10
 

The two integers written in the input base should be converted to a base ten representation, the indicated arithmetic operation should be performed, the result should be converted to the output base, and a summary should be printed in a tasteful manner. As an example, input of

8 73 + 216 5

Should produce output something like the following:

 

         73 (base 8) + 216 (base 8)

         = 59 + 142

         = 201

         = 1301 (base 5)

 

Your program should be modular, using methods appropriately. Bad data should be rejected by your program without causing it great grief.


Checklist:

- Fully functional program that meets the requirements
- Modular programming that meets the requirements
- Validation that meets the requirements
- Appropriate comments
- Efficient use of programming class time