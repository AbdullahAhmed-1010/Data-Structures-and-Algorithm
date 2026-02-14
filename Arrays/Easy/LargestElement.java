package Arrays.Easy;

import java.util.Scanner;

public class LargestElement {
    public static int largestElement(int n, int[] arr){
        // bruteforce approach: sort the array then the last element would be the largest element present in the array.

        // optimal solution
        int largest = arr[0];
        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int res = largestElement(n, arr);
        System.out.println("The largest element present in the array: " + res);

        sc.close();
    }
}