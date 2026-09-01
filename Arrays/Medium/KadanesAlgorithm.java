package Arrays.Medium;

import java.util.Scanner;

public class KadanesAlgorithm {
    //bruteforce solution (TC = O(n^3) SC = O(1))
    //for better solution we can iterate the second loop and add the sum directly (TC = O(n^2) SC = O(1))
    public static int kadanesAlgorithm(int[] arr){
        int n = arr.length;
        int maximumSum = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k = i; k<n; k++){
                    sum = sum + arr[i];
                }
                maximumSum = Math.max(maximumSum, sum);
            }
        }
        return maximumSum;
    }
    //optimal solution -> Kadane's Algorithm (TC = O(n) SC = O(1))
    public static int[] optimalSolution(int[] arr){
        int n = arr.length;
        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1, end = -1 , point = 0;
        for(int i=0; i<n; i++){
            if(sum == 0)
                point = i;
            sum = sum + arr[i];
            if(sum > maximumSum){
                maximumSum = sum;
                start = point;
                end = i;
            }
            if(sum < 0)
                sum = 0;
        }
        return new int[]{start, end};
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

        // int res = kadanesAlgorithm(arr);
        int[] res = optimalSolution(arr);
        int start = res[0];
        int end = res[1];
        System.out.print("Maximum Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}