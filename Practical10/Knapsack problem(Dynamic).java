import java.util.Arrays;
import java.util.List;
public class Main {
 public static int knapsackUtil(List<Integer> wt, List<Integer> val, int ind, int W, 
int[][] dp) {
 if (ind == 0) {
 if (wt.get(0) <= W) return val.get(0);
 else return 0;
 }
 if (dp[ind][W] != -1) return dp[ind][W];
 int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);
 int taken = Integer.MIN_VALUE;
 if (wt.get(ind) <= W) {
 taken = val.get(ind) + knapsackUtil(wt, val, ind - 1, W - wt.get(ind), dp);
 }
 dp[ind][W] = Math.max(notTaken, taken);
 return dp[ind][W];
 }
 public static int knapsack(List<Integer> wt, List<Integer> val, int n, int W) {
 int[][] dp = new int[n][W + 1];
 for (int[] row : dp) {
 Arrays.fill(row, -1);
 }
 return knapsackUtil(wt, val, n - 1, W, dp);
 }
 public static void main(String[] args) {
 List<Integer> wt = Arrays.asList(1, 2, 4, 5);
 List<Integer> val = Arrays.asList(5, 4, 8, 6);
 int W = 5;
 int n = wt.size()
System.out.println("The Maximum value of items the thief can steal is " + 
knapsack(wt, val, n, W));
 }
}
