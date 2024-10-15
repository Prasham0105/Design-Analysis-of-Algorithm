import java.util.Arrays;
public class BinarySearch {
// Binary search method
public static int binarySearch(int[] arr, int target) {
int left = 0;
int right = arr.length - 1;
while (left <= right) {
int mid = left + (right - left) / 2;
if (arr[mid] == target) {
return mid; // Element found, return its index
}
if (arr[mid] < target) {
left = mid + 1;
} else {
right = mid - 1;
}
}
return -1; // Element not found
}
public static void main(String[] args) {
int[] arr = new int[10000];
for (int i = 0; i < 10000; i++) {
arr[i] = i + 1;
}
// Sorting the array (though it's already sorted in this case)
Arrays.sort(arr);
int targetElement = 1558;
int result = binarySearch(arr, targetElement);
if (result != -1) {
System.out.println("Element found at index: " + result);
} else {
System.out.println("Element not found in the array.");
}
}
}
