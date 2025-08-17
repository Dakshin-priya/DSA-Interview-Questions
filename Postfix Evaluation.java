/*
1.  Read expression left to right
2.  If token is an operand → push it to stack
3.  If token is an operator → pop two operands from stack, apply operator, push result back
4.  At the end, the stack contains the final answer
*/
import java.util.Stack;

class PostfixEvaluation {

    public static int evaluatePostfix(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) { 
                // Operand (number)
                stack.push(Integer.parseInt(token));
            } else {
                // Operator
                int b = stack.pop(); // 2nd operand
                int a = stack.pop(); // 1st operand

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop(); // Final result
    }

    public static void main(String[] args) {
        String postfix = "2 3 * 5 4 * + 9 -";
        System.out.println("Postfix: " + postfix);
        int result = evaluatePostfix(postfix);
        System.out.println("Result: " + result); // 17
    }
}
