import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
	public static int nComp = 0;

	/*
	 * QuickSort_first uses the first element of the array as the pivot
	 * 
	 */
	public static void QuickSort_first(int[] A) {
		if (A.length == 1) return;
		nComp += A.length - 1;
		//System.out.println("A.length = "+A.length);
		int q = Partition(A);
		//private static int[] firstHalf;
		//private static int[] secondHalf;
		//System.out.println(nComp);
		if (q >= 1) {
			int[] firstHalf = Arrays.copyOfRange(A, 0, q);
			//System.out.println("firstHalf.length = "+firstHalf.length);
			QuickSort_first(firstHalf);
		}
		if (q <= A.length - 2) {
			int[] secondHalf = Arrays.copyOfRange(A, q + 1, A.length);
			QuickSort_first(secondHalf);
		}
	}

	/*
	 * QuickSort_last uses the last element of the array as the pivot
	 * 
	 */
	public static void QuickSort_last(int[] A) {
		if (A.length == 1) return;
		nComp += A.length - 1;
		//System.out.println("A.length = "+A.length);
		
		//swap first and last elements in array A
		int temp = A[0];
		A[0] = A[A.length -1];
		A[A.length -1] = temp;
		
		int q = Partition(A);
		//private static int[] firstHalf;
		//private static int[] secondHalf;
		//System.out.println(nComp);
		if (q >= 1) {
			int[] firstHalf = Arrays.copyOfRange(A, 0, q);
			//System.out.println("firstHalf.length = "+firstHalf.length);
			QuickSort_last(firstHalf);
		}
		if (q <= A.length - 2) {
			int[] secondHalf = Arrays.copyOfRange(A, q + 1, A.length);
			QuickSort_last(secondHalf);
		}
	}

	/*
	 * QuickSort_median uses the median of the first, middle, and last elements of the array as the pivot
	 * 
	 */
	public static void QuickSort_median(int[] A) {
		if (A.length == 1) return;
		nComp += A.length - 1;
		int temp;
		//System.out.println("A.length = "+A.length);
		
		//identify median of the first, middle, and last
		int m = A.length / 2;
		if (A.length % 2 == 0) m -= 1;
		
		//if middle element is the median, swap the first with the middle
		if ((A[0] < A[m] && A[m] < A[A.length - 1]) || (A[A.length - 1] < A[m] && A[m] < A[0])) {
			temp = A[0];
			A[0] = A[m];
			A[m] = temp;
		}

		//if the last element is the median, swap the first with the last
		if ((A[0] < A[A.length - 1] && A[A.length - 1] < A[m]) || (A[m] < A[A.length - 1] && A[A.length - 1] < A[0])) {
			temp = A[0];
			A[0] = A[A.length - 1];
			A[A.length - 1] = temp;
		}
		
		int q = Partition(A);
		//private static int[] firstHalf;
		//private static int[] secondHalf;
		//System.out.println(nComp);
		if (q >= 1) {
			int[] firstHalf = Arrays.copyOfRange(A, 0, q);
			//System.out.println("firstHalf.length = "+firstHalf.length);
			QuickSort_median(firstHalf);
		}
		if (q <= A.length - 2) {
			int[] secondHalf = Arrays.copyOfRange(A, q + 1, A.length);
			QuickSort_median(secondHalf);
		}
	}

	
	public static int Partition(int[] A) {
		int p = A[0];
		int i = 1;
		int temp;
		for (int j = 1; j < A.length; j++) {
			if (A[j] < p) {
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i += 1;
			}
		}
		temp = A[0];
		A[0] = A[i-1];
		A[i-1] = temp;
		
		//System.out.println("q = "+(i-1));
		
		return i-1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		//int[] A = {2, 3, 1};
		//int[] A = {4, 3, 1, 2};
		//int[] A = {3,8,2,5,1,4,7,6};

		
		Scanner scanner = new Scanner(new File("QuickSort.txt"));
		int [] A = new int [10000];
		int i = 0;
		while(scanner.hasNextInt()){
		   A[i++] = scanner.nextInt();
		}
		
		//QuickSort_first(A);
		//QuickSort_last(A);		
		QuickSort_median(A);
		System.out.println(nComp);
		

	}

}
