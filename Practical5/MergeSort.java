public class MergeSort {
// Merge sort method
public static void mergeSort(int[] array, int left, int right) {
if (left < right) {
int middle = (left + right) / 2;
// Recursively sort the left half
mergeSort(array, left, middle);
// Recursively sort the right half
mergeSort(array, middle + 1, right);
// Merge the sorted halves
merge(array, left, middle, right);
}
}
// Merge two subarrays
public static void merge(int[] array, int left, int middle, int right) {
int n1 = middle - left + 1;
int n2 = right - middle;
int[] L = new int[n1];
int[] R = new int[n2];
for (int i = 0; i < n1; ++i) {
L[i] = array[left + i];
}
for (int j = 0; j < n2; ++j) {
R[j] = array[middle + 1 + j];
}
int i = 0, j = 0;
int k = left;
  while (i < n1 && j < n2) {
if (L[i] <= R[j]) {
array[k] = L[i];
i++;
} else {
array[k] = R[j];
j++;
}
k++;
}
while (i < n1) {
array[k] = L[i];
i++;
k++;
}
while (j < n2) {
array[k] = R[j];
j++;
k++;
}
}
public static void main(String[] args) {
int[] array = new int[10000];
for (int i = 0; i < array.length; i++) {
array[i] = (int) (Math.random() * 10000);
}
long startTime = System.nanoTime();
mergeSort(array, 0, array.length - 1);
long endTime = System.nanoTime();
System.out.println("Sorted array:");
for (int i = 0; i < 100; i++) { // Print first 100 elements to verify
System.out.print(array[i] + " ");
}
System.out.println("\nMerge Sort took " + (endTime - startTime) + " ns");
}
}
