public class Main {
 // Function to find the most efficient way to multiply matrices
 public static int matrixChainOrder(int[] p, int n) {
 int[][] m = new int[n][n];
 // m[i,j] = Minimum number of scalar multiplications needed to compute the 
matrix A[i]A[i+1]...A[j] = A[i..j]
 // m[i,i] = 0 for i = 1 to n
 
 for (int i = 1; i < n; i++) {
 m[i][i] = 0;
 }
 // L is the chain length.
 for (int L = 2; L < n; L++) {
 for (int i = 1; i < n - L + 1; i++) {
 int j = i + L - 1;
 m[i][j] = Integer.MAX_VALUE;
 for (int k = i; k <= j - 1; k++) {
 int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
 if (q < m[i][j])
 m[i][j] = q;
 }
 }
 }
 return m[1][n - 1];
 }
 public static void main(String[] args) {
 int[] arr = {1, 2, 3, 4}; // Example dimensions of matrices
 int size = arr.length;
 System.out.println("Minimum number of multiplications is " + 
matrixChainOrder(arr, size));
 }
}
