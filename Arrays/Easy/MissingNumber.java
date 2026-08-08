package Arrays.Easy;

import java.util.Scanner;

public class MissingNumber {
    //bruteforce solution
    public static int missingNumber(int[] arr){
        int n = arr.length+1;
        for(int i=1; i<=n; i++){
            int flag = 0;
            for(int j=0; j<n-1; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                return i;
        }
        return 0;
    }
    //better solution -> using hashing
    public static int betterSolution(int[] arr){
        int n = arr.length + 1;
        int[] hash = new int[n+1];
        for(int  i=0; i<arr.length; i++){
            hash[arr[i]] = 1;
        }
        for(int i=1; i<=n; i++){
            if(hash[i] == 0)
                return i;
        }
        return 0;
    }
    //optimal solution -> using summation technique
    public static long optimalsolution1(int[] arr){
        int n = arr.length+1;
        long sum1 = (n*(n+1))/2;
        long sum2 = 0;

        for(int i=0; i<arr.length; i++){
            sum2 = sum2 + arr[i];
        }
        long missingElement = sum1 - sum2;
        return missingElement;
    }
    //another optimal approach is to use XOR bit manipulation method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n-1];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<n-1; i++){
            arr[i] = sc.nextInt();
        }

        // int res = missingNumber(arr);
        // int res = betterSolution(arr);
        long res = optimalsolution1(arr);
        System.out.println(res);

        sc.close();
    }
}