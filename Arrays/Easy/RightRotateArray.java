package Arrays.Easy;
import java.util.Scanner;

public class RightRotateArray{
    public static void rightRotate(int arr[], int n, int k){
        k = k%n;
        int d = n-k;
        int temp[] = new int[d];

        for(int i=0; i<d; i++){
            temp[i] = arr[i];
        }
        for(int i=d; i<n; i++){
            arr[i-d] = arr[i];
        }
        int j = 0;
        for(int i=n-d; i<n; i++){
            arr[i] = temp[j];
            j++;
        }
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

        rightRotate(arr, n, k);

        System.out.println("\nArray after left rotation: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}