package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MajorityElement {
    //bruteforce approach (TC = O(n^2) SC =O(1))
    public static int majorityElement(int[] arr){
        int n = arr.length;
        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if(arr[j] == arr[i])
                    count++;
            }
            if(count > n/2)
                return arr[i];
        }
        return -1;
    }
    //better solution -> using hashing/hashmap (TC = O(n + n) SC = O(n))
    public static int betterSolution1(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() > (n/2)){
                return it.getKey();
            }
        }
        return -1;
    }
    //better solution -> using sorting and counter variable (TC = O(nlogn + n) SC = O(1))
    public static int betterSolution2(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int element = arr[n/2];
        int count = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == element){
                count++;
            }
        }
        if(count > n/2)
            return element;
        return -1;
    }
    // optimal solution -> Moore's Voting Algorithm (TC = O(n + n) SC = O(1))
    public static int optimalSolution(int[] arr){
        int n = arr.length;
        int count = 0;
        int element = 0;
        for(int i=0; i<n; i++){
            if(count == 0){
                count = 1;
                element = arr[i];
            }
            else if(element == arr[i])
                count++;
            else
                count--;
        }
        int count1 = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == element)
                count1++;
        }
        if(count1 > n/2)
            return element;
        return -1;
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

        // int res = majorityElement(arr);
        // int res = betterSolution1(arr);
        // int res = betterSolution2(arr);
        int res = optimalSolution(arr);
        System.out.println(res);

        sc.close();
    }
}