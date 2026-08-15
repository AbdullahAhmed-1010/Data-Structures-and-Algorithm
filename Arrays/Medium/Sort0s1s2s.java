package Arrays.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class Sort0s1s2s {
    //bruteforce approach -> sort the array using any sorting technique
    //better solution
    public static int[] betterSolution(int[] arr){
        int count0 = 0, count1 = 0, count2 = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0)
                count0++;
            else if(arr[i] == 1)
                count1++;
            else
                count2++;
        }
        for(int i=0; i<count0; i++)
            arr[i] = 0;
        for(int i=count0; i<count0+count1; i++)
            arr[i] = 1;
        for(int i=count0+count1; i<count0+count1+count2; i++)
            arr[i] = 2;

        return arr;
    }
    //optimal solution -> Dutch National Flag (DNF) Algorithm (using 3-pointer approach)
    public static int[] optimalSolution(int[] arr){
        int low = 0, mid = 0, high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

        // int[] res = betterSolution(arr);
        int[] res = optimalSolution(arr);
        System.out.println(Arrays.toString(res));

        sc.close();
    }
}