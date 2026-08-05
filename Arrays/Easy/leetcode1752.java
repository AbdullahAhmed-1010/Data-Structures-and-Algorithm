package Arrays.Easy;

import java.util.Scanner;

public class leetcode1752 {
    public static void reverse(int arr[], int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static boolean checkRotatedSorted(int[] arr){
        int k = 0;
        int count = 0;

        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] < arr[i]){
                count++;
                k = i+1;
            }
        }
        if(count > 1){
            return false;
        }
        if(count == 0){
            return true;
        }
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);
        reverse(arr, 0, arr.length-1);

        for(int i=0; i<arr.length-1; i++){
            if(arr[i+1] < arr[i]){
                return false;
            }
        }
        return true;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(checkRotatedSorted(arr));

        sc.close();
    }
}