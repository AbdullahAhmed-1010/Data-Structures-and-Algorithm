package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UnionArray {
    // bruteforce apprroach
    public static int union(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int temp[] = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            temp[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            temp[i + n1] = arr2[i];
        }
        int n = temp.length;
        Arrays.sort(temp);

        if (n == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (temp[j] != temp[i]) {
                i++;
                temp[i] = temp[j];
            }
        }
        for (int k = 0; k <= i; k++) {
            System.out.print(temp[k] + " ");
        }
        return i + 1;
    }

    // bruteforce approach -> using hashset
    public static void hashUnion(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n1; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < n2; i++) {
            set.add(arr2[i]);
        }

        int union[] = new int[set.size()];
        int i = 0;
        for (int element : set) {
            union[i] = element;
            i++;
        }
        for (int j = 0; j < union.length; j++) {
            System.out.print(union[j] + " ");
        }
    }

    // optimal solution -> 2-pointer approach
    public static void optimalSolution(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        for (int element : union) {
            System.out.print(element + " ");
        }
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

        // union(arr1, arr2);
        // hashUnion(arr1, arr2);
        optimalSolution(arr1, arr2);

        sc.close();
    }
}