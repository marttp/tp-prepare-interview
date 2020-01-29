package challenge;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            // Filter only a - z
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            /*
             * Stack start from last
             * Queue start from first
             * Then make it compare together.
             * If unmatch some element is return to false.
             */
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }
}
