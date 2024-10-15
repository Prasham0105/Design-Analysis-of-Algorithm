import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class Item {
 int value, weight;
 float density;
 Item(int value, int weight) {
 this.value = value;
 this.weight = weight;
 this.density = (float) value / weight;
 }
}
public class Knapsack {
 public static void input(Item[] items, int sizeOfItems) {
 Scanner scanner = new Scanner(System.in);
 System.out.println("Enter total " + sizeOfItems + " item's values and weight");
 for (int i = 0; i < sizeOfItems; i++) {
 System.out.print("Enter " + (i + 1) + " Value: ");
 int value = scanner.nextInt();
 System.out.print("Enter " + (i + 1) + " Weight: ");
 int weight = scanner.nextInt();
 items[i] = new Item(value, weight);
 }
 }
 public static void display(Item[] items, int sizeOfItems) {
 System.out.print("Values: ");
 for (int i = 0; i < sizeOfItems; i++) {
 System.out.print(items[i].value + "\t");
 }
 System.out.println("\nWeights: ");
 for (int i = 0; i < sizeOfItems; i++) {
 System.out.print(items[i].weight + "\t");
 }
 System.out.println();
 }
 public static double knapsack(Item[] items, int sizeOfItems, int W) {
 Arrays.sort(items, new Comparator<Item>() {
 public int compare(Item i1, Item i2) {
 return Float.compare(i2.density, i1.density)
  }
 });
 double totalValue = 0;
 double totalWeight = 0;
 for (int i = 0; i < sizeOfItems; i++) {
 if (totalWeight + items[i].weight <= W) {
totalValue += items[i].value;
 totalWeight += items[i].weight;
 } else {
 int remainingWeight = W - (int) totalWeight;
 totalValue += items[i].density * remainingWeight;
 totalWeight += remainingWeight;
 break;
 }
 } 
 System.out.println("Total weight in the bag: " + totalWeight);
 return totalValue;
 }
 public static void main(String[] args) {
 Item[] items = new Item[3];
 input(items, 3);
 System.out.println("Entered data:");
 display(items, 3); 
 Scanner scanner = new Scanner(System.in);
 System.out.print("Enter Knapsack weight: ");
 int W = scanner.nextInt();
 double maxValue = knapsack(items, 3, W);
 System.out.println("---Max value for " + W + " weight is: " + maxValue); 
 scanner.close();
 }
}
