package Arrays.Easy;

import java.util.Scanner;

public class MoveZeroes {
    // bruteforce approach
    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int k = 0;
        int count = 0;
        int temp[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                count++;
        }
        for (int i = n - count; i < n; i++) {
            temp[i] = 0;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = temp[j];
            j++;
        }
    }

    // optimal solution -> 2-pointer approach
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void optimalSolution(int[] arr) {
        int n = arr.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // moveZeroes(arr);
        optimalSolution(arr);

        System.out.println("\nResulted Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}