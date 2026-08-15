package Arrays.Medium;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
    //bruteforce approach
    public static ArrayList<Integer> twoSum(int[] arr, int target){
        int n = arr.length;
        ArrayList<Integer> sumArray = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i] + arr[j] == target){
                    sumArray.add(arr[i]);
                    sumArray.add(arr[j]);
                }
            }
        }
        return sumArray;
    }
    //better solution -> using hashing/hashmap
    public static int[] betterSolution(int[] arr, int target){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int element = arr[i];
            int more = target - element;
            if(map.containsKey(more)){
                return new int[]{map.get(more), arr[i]};
            }
            map.put(element, arr[i]);
        }
        return new int[]{-1, -1};
    }
    //optimal solution -> using 2-pointer and greedy approach but only applicabe when the user wants to return the elements of array
    //and not the indices
    //for returning indices type of problem the above solution is the most optimal one
    public static int[] optimalSolution(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length;
        int left = 0;
        int right = n-1;

        for(int i=0; i<n; i++){
            if(arr[left] + arr[right] > target)
                right--;
            else if(arr[left] + arr[right] < target)
                left++;
            else
                return new int[]{arr[left], arr[right]};
        }
        return new int[]{};
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

        System.out.println("Enter the given target: ");
        int target = sc.nextInt();

        // ArrayList<Integer> res = twoSum(arr, target);
        // int[] res = betterSolution(arr, target);
        int[] res = optimalSolution(arr, target);
        System.out.println(Arrays.toString(res));

        sc.close();
    }
}