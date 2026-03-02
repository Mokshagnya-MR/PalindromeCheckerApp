import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeChecker {

    // ================= Application Constants =================
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        displayWelcomeMessage();        // UC1
        checkHardcodedPalindrome();     // UC2
        palindromeUsingReverse();       // UC3
        palindromeUsingCharArray();     // UC4
        palindromeUsingStack();         // UC5
        palindromeUsingQueueAndStack(); // UC6
        palindromeUsingDeque();         // UC7
        palindromeUsingLinkedList();    // UC8

        System.out.println("Program execution completed.");
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

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC7 Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC7 Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC8 =================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private static void palindromeUsingLinkedList() {

        String text = "level";
        Node head = createLinkedList(text);

        if (isPalindromeLinkedList(head)) {
            System.out.println("UC8 Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC8 Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }

    private static Node createLinkedList(String text) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < text.length(); i++) {
            Node newNode = new Node(text.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    private static boolean isPalindromeLinkedList(Node head) {

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static Node reverseList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}