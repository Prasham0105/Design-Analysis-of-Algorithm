import java.util.Arrays;
import java.util.Scanner;
public class GreedyMethod {
 // Function to find the minimum number of coins
 public static void findMinCoins(int[] coins, int amount) {
 Arrays.sort(coins);
 int[] result = new int[coins.length];
 int count = 0;
 for (int i = coins.length - 1; i >= 0; i--) {
 while (amount >= coins[i]) {
 amount -= coins[i];
 result[i]++;
 count++;
 }
 }
 System.out.println("Minimum number of coins required: " + count);
 System.out.println("Coins used:");
 for (int i = 0; i < coins.length; i++) {
 if (result[i] > 0) {
 System.out.println(coins[i] + " x " + result[i]);
 }
 }
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter the total amount: ");
 int amount = scanner.nextInt();
 int[] coins = {1, 5, 10, 25, 50, 100}; // Coin denominations
 findMinCoins(coins, amount);
 scanner.close();
 }
}
