package Arrays.Easy;

import java.util.Scanner;

public class MaximumConsecutives {
    public static int maximamConsecutive(int[] arr){
        int n = arr.length;
        int count = 0;
        int maximum = 0;

        for(int i=0; i<n; i++){
            if(arr[i] == 1){
                count++;
                maximum = Math.max(maximum, count);
            }
            else
                count = 0;
        }
        return maximum;
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

        int res = maximamConsecutive(arr);
        System.out.println("Maximum Consecutive Ones: " + res);

        sc.close();
    }
}