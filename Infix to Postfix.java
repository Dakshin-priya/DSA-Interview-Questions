/*
Operands → go directly to output.
Operators → use a stack:
    Pop operators from stack to output if they have higher or equal precedence.
    Then push the current operator( if or not has higher priority).

Parentheses:
( → push to stack
) → pop all operators until ( is found


Operator Precedence (highest → lowest):
^    >    * /     >    + -


Associativity:

^            →     right to left

* / + -      →        left to right

*/

import java.util.Stack;

class InfixToPostfix {
    // Method to return precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == ' ') continue; // skip spaces

            // If operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                output.append(ch).append(' ');
            }
            // If '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
            }
            // If operator
            else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString().trim();
    }

    public static void main(String[] args) {
        String infix = "(2*3 + 5*4 - 9)";
        String postfix = infixToPostfix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
