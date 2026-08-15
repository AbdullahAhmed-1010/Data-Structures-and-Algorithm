package Arrays.Easy;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSub {
    //bruteforce solution - generating all subarrays
    public static int longestSub(int[] arr, int x){
        int n  = arr.length;
        int len = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum = sum + arr[k];
                }
                if(sum == x){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    //better solution - using prefix sum and hashmap but only for arrays containing only positives
    //for arrays containing positives, zeroes and negatives this is the only optimal solution
    public static int betterSolution(int[] arr, int k){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        for(int i=0; i<n; i++){
            prefixSum = prefixSum + arr[i];
            if(prefixSum == k){
                maxLen = i+1;
            }
            if(map.containsKey(prefixSum - k)){
                int previousIndex = map.get(prefixSum - k);
                int currentLen = i - previousIndex;
                maxLen = Math.max(maxLen, currentLen);
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }
    //optimal solution for arrays containing only positives - using 2-pointer approach and greedy method
    public static int optimalSolution(int[] arr, int k){
        int n = arr.length;
        int right = 0;
        int left = 0;
        int sum = arr[0];
        int maxLen = 0;

        while(right < n){
            while(left <= right && sum > k){
                sum = sum - arr[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1);
            }
            right++;
            if(right < n){
                sum = sum + arr[right];
            }
        }
        return maxLen;
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
        System.out.println("Enter the given summation: ");
        int x = sc.nextInt();

        // int res = longestSub(arr, x);
        // int res = betterSolution(arr, x);
        int res = optimalSolution(arr, x);
        System.out.println(res);

        sc.close();
    }
}