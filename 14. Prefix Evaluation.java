/*
1.  Scan expression from right to left
2.  If token is an operand → push it to stack
3.  If token is an operator → pop two operands, apply operator, push result back
4.  At the end, the stack contains the final answer
*/
import java.util.Stack;

class PrefixEvaluation {

    public static int evaluatePrefix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+");

        // Traverse from right to left
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (token.matches("\\d+")) {
                // Operand
                stack.push(Integer.parseInt(token));
            } else {
                // Operator
                int a = stack.pop(); // 1st operand
                int b = stack.pop(); // 2nd operand

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String prefix = "- + * 2 3 * 5 4 9";
        System.out.println("Prefix: " + prefix);
        int result = evaluatePrefix(prefix);
        System.out.println("Result: " + result); // 17
    }
}
