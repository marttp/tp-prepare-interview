import java.util.Stack;

public class BalancedParentheses {
    public static char[][] TOKENS = { {'{', '}'}, {'(', ')'}, {'[', ']'}};

    public static boolean isOpenTerms(char c) {
        for (char[] term : TOKENS) {
            if (term[0] == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatch(char openTerm, char closeTerm) {
        for (char[] term : TOKENS) {
            if (term[0] == openTerm && term[1] == closeTerm) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) { 
            if (isOpenTerms(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}