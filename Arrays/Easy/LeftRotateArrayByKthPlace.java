package Arrays.Easy;

import java.util.Scanner;

public class LeftRotateArrayByKthPlace{   
    //bruteforce solution
    public static void leftRotate(int arr[], int n, int k){
        k=k%n;
        int temp[] = new int[k];

        for(int i=0; i<k; i++){
            temp[i] = arr[i];
        }
        for(int i=k; i<n; i++){
            arr[i-k] = arr[i];
        }
        int j = 0;
        for(int i=n-k; i<n; i++){
            arr[i] = temp[j];
            j++;
        }
    }

    //optimal solution
    public static void reverse(int arr[], int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void leftRotateByReverse(int arr[], int n, int k){
        k = k%n;
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
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

        System.out.println("Enter the k places you need to rotate: ");
        int k = sc.nextInt();

        System.out.println("Original array: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }

        // leftRotate(arr, n, k);
        leftRotateByReverse(arr, n, k);

        System.out.println("\nArray after left rotation: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}