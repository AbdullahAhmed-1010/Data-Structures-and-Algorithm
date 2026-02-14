package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicates {
    // better approach using hashmap
    public static void removeDuplicatesBetterApproach(int [] nums){
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(hash.size());
        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
                System.out.println(entry.getKey());
        }
    }

    // optimal solution using two pointers
    public static int removeDuplicates(int[] nums){
        if (nums.length == 0 ){
            return 0;
        }
        int i =0;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // removeDuplicatesBetterApproach(arr);
        
        int res = removeDuplicates(arr);
        System.out.println(res);

        sc.close();
    }
}
