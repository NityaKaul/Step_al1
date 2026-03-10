import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    // Two Pointer Approach
    public static boolean twoPointer(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack Approach
    public static boolean stackMethod(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Recursive Approach
    public static boolean recursiveMethod(String input, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }
        return recursiveMethod(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String input = "level";

        // Two Pointer Timing
        long startTime = System.nanoTime();
        boolean result1 = twoPointer(input);
        long endTime = System.nanoTime();
        long time1 = endTime - startTime;

        // Stack Timing
        startTime = System.nanoTime();
        boolean result2 = stackMethod(input);
        endTime = System.nanoTime();
        long time2 = endTime - startTime;

        // Recursive Timing
        startTime = System.nanoTime();
        boolean result3 = recursiveMethod(input, 0, input.length() - 1);
        endTime = System.nanoTime();
        long time3 = endTime - startTime;

        System.out.println("Input : " + input);
        System.out.println("Two Pointer Result : " + result1 + " | Time : " + time1 + " ns");
        System.out.println("Stack Method Result : " + result2 + " | Time : " + time2 + " ns");
        System.out.println("Recursive Result : " + result3 + " | Time : " + time3 + " ns");
    }
}