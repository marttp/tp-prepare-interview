import java.util.LinkedList;

public class Challenge {
    // Check palindrome
    public static void main(String[] args) {
        System.out.println(checkPalindrome("I did, did I?"));
        System.out.println(checkPalindrome("Racecar"));
    }

    public static boolean checkPalindrome(String string) {
        // Initial data
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(string.length());
        String lowercase = string.toLowerCase();

        // Operation
        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while(!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString().equals(stringNoPunctuation.toString());
    }
}
