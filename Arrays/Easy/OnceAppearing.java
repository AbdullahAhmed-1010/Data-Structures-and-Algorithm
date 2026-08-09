package Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnceAppearing {
    //bruteforce approach
    public static ArrayList<Integer> appearingOnce(int[] arr){
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            int count = 0;
            for(int j=0; j<n;  j++){
                if(arr[j] == arr[i]){
                    count++;
                }
            }
            if(count == 1){
                res.add(arr[i]);
            }
        }
        return res;
    }
    //better solution -> using hashing
    public static int betterSolution1(int[] arr){
        int n = arr.length;
        int maximum = arr[0];
        for(int i=0; i<n; i++){
            maximum = Math.max(maximum, arr[i]);
        }
        int[] hash = new int[maximum+1];
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        for(int i=0; i<n; i++){
            if(hash[arr[i]] == 1)
                return arr[i];
        }
        return 0;
    }
    // better solution -> using hashmap
    public static int betterSolution2(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        for(int i=0; i<n; i++){
            if(map.get(arr[i]) == 1){
                return arr[i];
            }
        }
        return 0;
    }
    //optimal solution using XOR bit manipulation
    public static int optimalSolution(int[] arr){
        int xor = 0;
        for(int i=0; i<arr.length; i++){
            xor = xor ^ arr[i]; 
        }
        return xor;
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

        // ArrayList<Integer> res = appearingOnce(arr);
        // int res = betterSolution1(arr);
        // int res = betterSolution2(arr);
        int res = optimalSolution(arr);
        System.out.println(res);

        sc.close();
    }
}