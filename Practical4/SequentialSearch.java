public class SequentialSearch {
// Sequential search method
public static int sequentialSearch(int[] arr, int target) {
for (int i = 0; i < arr.length; i++) {
if (arr[i] == target) {
return i; // Element found, return its index
}
}
return -1; // Element not found
}
public static void main(String[] args) {
int[] arr = new int[10000];
for(int i=1;i<10000;i++)
{
System.out.println(i);
arr[i] = i + 1;
}
int targetElement = 1556;
int result = sequentialSearch(arr, targetElement);
if (result != -1) {
System.out.println("Element found at index: " + result);
} else {
System.out.println("Element not found in the array.");
}
}
}
