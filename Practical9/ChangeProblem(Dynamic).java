import java.util.Scanner;
public class MinCoin {
 // Recursive function to find the minimum number of coins
 public static int minCoins(int[] coins, int m, int V) {
 // Base case
 if (V == 0) return 0;
 // Initialize result
 int res = Integer.MAX_VALUE;
 // Try every coin that has smaller value than V
 for (int i = 0; i < m; i++) {
 if (coins[i] <= V) {
 int sub_res = minCoins(coins, m, V - coins[i]);
 // Check for INT_MAX to avoid overflow and see if
 // result can be minimized
 if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
 res = sub_res + 1;
 }
 }
 return res;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 int[] coins = {10,5,2, 1}; // Coin denominations
 int m = coins.length;
 System.out.print("Enter the total amount: ");
 int V = scanner.nextInt();
 int result = minCoins(coins, m, V);
 if (result != Integer.MAX_VALUE) {
 System.out.println("Minimum coins required is " + result);
 } else {
 System.out.println("It's not possible to make the given amount with the 
provided coins.");
 }
 scanner.close();
 }
}
