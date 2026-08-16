package Arrays.Medium;

import java.util.Scanner;

public class KadanesAlgorithm {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int res = kadanesAlgorithm(arr);
        System.out.println(res);

        sc.close();
    }
}