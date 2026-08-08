package Arrays.Easy;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionArray {
    //bruteforce approach
    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        ArrayList<Integer> res = new ArrayList<>();
        int[] visited = new int[n2];

        for(int i=0; i<n1; i++){
            for(int j=0; j<n2; j++){
                if(arr1[i] == arr2[j] && visited[j] == 0){
                    res.add(arr1[i]);
                    visited[j] = 1;
                    break;
                }
                if(arr2[j] > arr1[i]){
                    break;
                }
            } 
        }
        return res;
    }
    //optimal solution -> 2-pointer approach
    public static ArrayList<Integer> optimalSolution(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;
        
        ArrayList<Integer> res = new ArrayList<>();

        while(i < n1 && j < n2){
            if(arr1[i] != arr2[j])
                i++;
            else{
                res.add(arr1[i]);
                i++;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the first array: ");
        int n1 = sc.nextInt();

        int arr1[] = new int[n1];
        System.out.println("Enter the elements of first array: ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of the second array: ");
        int n2 = sc.nextInt();

        int arr2[] = new int[n2];
        System.out.println("Enter the elements of second array: ");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // ArrayList<Integer> result = intersection(arr1, 
        ArrayList<Integer> result = optimalSolution(arr1, arr2);
        System.out.println(result);

        sc.close();
    }
}