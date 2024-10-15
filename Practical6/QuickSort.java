public class QuickSort {
// Quick sort method
public static void quickSort(int[] array, int low, int high) {
if (low < high) {
int pi = partition(array, low, high);
quickSort(array, low, pi - 1);
quickSort(array, pi + 1, high);
}
}
// Partition method
public static int partition(int[] array, int low, int high) {
int pivot = array[high];
int i = (low - 1);
for (int j = low; j < high; j++) {
if (array[j] < pivot) {
i++;
// Swap array[i] and array[j]
int temp = array[i];
array[i] = array[j];
array[j] = temp;
}
}
// Swap array[i + 1] and array[high] (or pivot)
int temp = array[i + 1];
array[i + 1] = array[high];
array[high] = temp;
return i + 1;
}
public static void main(String[] args) {
int[] array = new int[10000];
for (int i = 0; i < array.length; i++) 
 {
array[i] = (int) (Math.random() * 10000);
}
long startTime = System.nanoTime();
quickSort(array, 0, array.length - 1);
long endTime = System.nanoTime();
System.out.println("Sorted array:")
for (int i = 0; i < 100; i++)
 { // Print first 100 elements to verify
System.out.print(array[i] + " ");
}
System.out.println("\nQuick Sort took " + (endTime - startTime) + " ns");
}
}
