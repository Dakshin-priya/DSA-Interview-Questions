/*
1. Reverse the infix expression (right to left).
2.Swap parentheses:
    ( → )
    ) → (
3. Convert the reversed expression to postfix using the same stack rules.
4. Reverse the postfix result → this gives prefix expression.
*/
import java.util.Stack;

class InfixToPrefix {

    // Operator precedence
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

    public static String infixToPrefix(String infix) {
        // Step 1: Reverse infix and swap parentheses
        String reversed = "";
        for (int i = infix.length() - 1; i >= 0; i--) {
            char ch = infix.charAt(i);
            if (ch == '(') reversed += ')';
            else if (ch == ')') reversed += '(';
            else reversed += ch;
        }

        // Step 2: Convert reversed infix to postfix
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);

            if (ch == ' ') continue;

            if (Character.isLetterOrDigit(ch)) {
                output.append(ch).append(' ');
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else { // operator
                while (!stack.isEmpty() && precedence(ch) < precedence(stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        // Step 3: Reverse postfix → prefix
        String[] tokens = output.toString().trim().split("\\s+");
        String prefix = "";
        for (int i = tokens.length - 1; i >= 0; i--) {
            prefix += tokens[i] + " ";
        }

        return prefix.trim();
    }

    public static void main(String[] args) {
        String infix = "(2*3 + 5*4 - 9)";
        String prefix = infixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}
