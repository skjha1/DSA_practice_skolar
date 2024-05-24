import java.util.Stack;

public class InfixToPrefixConverter {
    // Function to check if the character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Function to get the precedence of an operator
    private static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Function to reverse a string
    private static String reverse(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    // Function to swap parentheses
    private static String swapParentheses(String str) {
        StringBuilder swapped = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                swapped.append(')');
            } else if (c == ')') {
                swapped.append('(');
            } else {
                swapped.append(c);
            }
        }
        return swapped.toString();
    }

    // Main function to convert infix to prefix
    public static String infixToPrefix(String infix) {
        // Step 1: Reverse the infix expression and swap parentheses
        String reversedInfix = reverse(infix);
        reversedInfix = swapParentheses(reversedInfix);

        // Step 2: Initialize stack and result
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Step 3: Scan the reversed expression
        for (char c : reversedInfix.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                // If character is an operand, add it to the result
                result.append(c);
            } else if (c == '(') {
                // If character is '(', push it to the stack
                stack.push(c);
            } else if (c == ')') {
                // If character is ')', pop and output from the stack until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Pop the '('
            } else if (isOperator(c)) {
                // If character is an operator
                while (!stack.isEmpty() && getPrecedence(stack.peek()) > getPrecedence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Step 4: Pop all the remaining operators from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        // Step 5: Reverse the result to get the prefix expression
        return reverse(result.toString());
    }

    // Main method to test the function
    public static void main(String[] args) {
        String infix = "(A + B) * C - D / E";
        String prefix = infixToPrefix(infix);
        System.out.println("Infix: " + infix);
        System.out.println("Prefix: " + prefix);
    }
}
