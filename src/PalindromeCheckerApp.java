import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        // UC1
        displayWelcomeMessage();

        // UC2
        checkHardcodedPalindrome();

        // UC3
        palindromeUsingReverse();

        // UC4
        palindromeUsingCharArray();

        // UC5
        palindromeUsingStack();

        // UC6
        palindromeUsingQueueAndStack();

        // UC7
        palindromeUsingDeque();
    }

    // ================= UC1 =================
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================\n");
    }

    // ================= UC2 =================
    private static void checkHardcodedPalindrome() {
        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("UC2 Result: \"" + word + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC2 Result: \"" + word + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC3 =================
    private static void palindromeUsingReverse() {
        String original = "level";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("UC3 Result: \"" + original + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC3 Result: \"" + original + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC4 =================
    private static void palindromeUsingCharArray() {
        String text = "radar";
        char[] characters = text.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC4 Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC5 =================
    private static void palindromeUsingStack() {
        String text = "civic";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC5 Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC5 Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC6 =================
    private static void palindromeUsingQueueAndStack() {
        String text = "refer";

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC6 Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC6 Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC7 =================
    private static void palindromeUsingDeque() {

        String text = "noon";
        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque (rear)
        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        // Compare front & rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC7 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC7 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram execution completed.");
    }
}