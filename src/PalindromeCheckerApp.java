import java.util.*;

public class PalindromeChecker {

    // ================= UC1 =================
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        // UC1
        displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();
        System.out.println();

        // UC2
        checkHardcodedPalindrome(input);

        // UC3
        palindromeUsingReverse(input);

        // UC4
        palindromeUsingCharArray(input);

        // UC5
        palindromeUsingStack(input);

        // UC6
        palindromeUsingQueueAndStack(input);

        // UC7
        palindromeUsingDeque(input);

        // UC8
        palindromeUsingLinkedList(input);

        // UC9
        palindromeUsingRecursion(input);

        System.out.println("\nProgram execution completed.");
        scanner.close();
    }

    // ================= UC1 METHOD =================
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================\n");
    }

    // ================= UC2 =================
    private static void checkHardcodedPalindrome(String word) {

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("UC2 Result: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("UC2 Result: \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ================= UC3 =================
    private static void palindromeUsingReverse(String original) {

        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        if (original.equals(reversed)) {
            System.out.println("UC3 Result: \"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("UC3 Result: \"" + original + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ================= UC4 =================
    private static void palindromeUsingCharArray(String text) {

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
            System.out.println("UC4 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC4 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ================= UC5 =================
    private static void palindromeUsingStack(String text) {

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
            System.out.println("UC5 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC5 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ================= UC6 =================
    private static void palindromeUsingQueueAndStack(String text) {

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
            System.out.println("UC6 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC6 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    // ================= UC7 =================
    private static void palindromeUsingDeque(String text) {

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
            System.out.println("UC7 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC7 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
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

    private static void palindromeUsingLinkedList(String text) {

        Node head = createLinkedList(text);

        if (isPalindromeLinkedList(head)) {
            System.out.println("UC8 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC8 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
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

    // ================= UC9 =================
    private static void palindromeUsingRecursion(String text) {

        boolean result = isPalindromeRecursive(text, 0, text.length() - 1);

        if (result) {
            System.out.println("UC9 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC9 Result: \"" + text + "\" is NOT a Palindrome.");
        }

        System.out.println();
    }

    private static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(text, start + 1, end - 1);
    }
}