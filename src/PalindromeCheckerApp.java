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

        // Convert String to char[]
        char[] characters = text.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        // Two-pointer technique
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

        System.out.println("\nProgram execution completed.");
    }
}