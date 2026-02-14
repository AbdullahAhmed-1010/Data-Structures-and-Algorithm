package Arrays.Easy;

import java.util.Scanner;

public class SecondLargestElement {
    public static int secondLargestElement(int n, int[] arr){
        // bruteforce approach: sort the array and the last element would be the largest element present in the array
        // using arr[n-2] to find the second largest element might cause an error because we dont know if the array conatains any duplicate element or not
        // for an array with constant elements, second largest = -1

        // better solution: using two loop passes
        // first pass to find the largest element and second pass to find the second largest element

        // optimal solution
        int largest = arr[0];
        int secondLargest = -1;
        for(int i=0; i<n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
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

        int res = secondLargestElement(n, arr);
        System.out.println("The second largest element present in the array: " + res);

        sc.close();
    }
}