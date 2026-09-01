package Arrays.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class RearrangeElements {
    //bruteforce solution (TC = O(n + n/2) SC = O(n/2 + n/2))
    public static int[] bruteforceSolution(int[] arr){
        int n = arr.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(arr[i] > 0)
                pos.add(arr[i]);
            else
                neg.add(arr[i]);
        }
        if(pos.size() > neg.size()){
            for(int i=0; i<neg.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = neg.size() * 2;
            for(int i = neg.size(); i< pos.size(); i++){
                arr[index] = pos.get(i);
                index++;
            }
        }
        else{
            for(int i=0; i<pos.size(); i++){
                arr[2*i] = pos.get(i);
                arr[2*i + 1] = neg.get(i);
            }
            int index = pos.size() * 2;
            for(int i = pos.size(); i< neg.size(); i++){
                arr[index] = neg.get(i);
                index++;
            }
        }
        return arr;
    }
    //optimal solution (TC = O(n) SC = O(n))
    public static int[] optimalSolution(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++) {
        ans.add(0);
    }
        int pos = 0;
        int neg = 1;
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                ans.set(pos, arr[i]);
                pos = pos + 2;
            }
            else{
                ans.set(neg, arr[i]);
                neg = neg + 2;
            }
        }
        for(int i=0; i<n; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
    //optimal solution -> optimizing SC to O(1) using 2-pointer approach
    public static void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}
public static int[] optimizedSolution(int[] arr) {
    int n = arr.length;
    int pos = 0;
    int neg = 1;

    while (pos < n && neg < n) {
        while (pos < n && arr[pos] > 0)
            pos += 2;
        while (neg < n && arr[neg] < 0)
            neg += 2;
        if (pos < n && neg < n)
            swap(arr, pos, neg);
    }
    return arr;
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

        // int[] res = bruteforceSolution(arr);
        // int[] res = optimalSolution(arr);
        int[] res = optimizedSolution(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

        sc.close();
    }
}