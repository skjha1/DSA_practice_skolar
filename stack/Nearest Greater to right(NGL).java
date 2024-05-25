import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class NearestGreaterToRight {

    // Method to find the nearest greater element to the right for each element in the array
    public static ArrayList<Integer> nearestGreaterToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of elements
        ArrayList<Integer> result = new ArrayList<>(); // List to store the result
        int n = arr.length; // Length of the input array

        // Iterate over the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from stack that are less than or equal to the current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no greater element to the right
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                // Nearest greater element to the right is the top element of the stack
                result.add(stack.peek());
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        // The result list is in reverse order, reverse it before returning
        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {4, 5, 2, 10, 8};
        ArrayList<Integer> result = nearestGreaterToRight(arr); // Find nearest greater to right
        System.out.println(result); // Output: [5, 10, 10, -1, -1]
    }
}
