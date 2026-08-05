package Arrays.Easy;

import java.util.Scanner;

public class LinearSearch {
    public static int linearSearch(int[] arr, int k){
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] == k){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Enter the element you need to find: ");
        int k = sc.nextInt();

        int index = linearSearch(arr, k);

        if (index != -1) {
            System.out.println("Element found at index " + index);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}