import java.util.*;

public class Shopping {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: array of prices
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter the prices of items:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Input: target amount
        System.out.print("Enter the target amount: ");
        int target = scanner.nextInt();

        // Find the indices of two items whose prices add up to the target amount
        int[] indices = findItems(prices, target);

        // Output the indices of the items
        if (indices != null) {
            System.out.println("Items at indices " + indices[0] + " and " + indices[1] + " add up to " + target);
        } else {
            System.out.println("No combination of items found that add up to " + target);
        }
    }

    public static int[] findItems(int[] prices, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            int complement = target - prices[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(prices[i], i);
        }
        return null;
    }
}
