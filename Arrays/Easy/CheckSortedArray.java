package Arrays.Easy;
import java.util.Scanner;

public class CheckSortedArray {
    public static boolean isSorted(int n, int[] arr){
        for(int i=0; i<n-1; i++){
            if(arr[i] < arr[i+1]){

            }
            else{
                return false;
            }
        }
        return true;
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

        boolean res = isSorted(n, arr);
        if(res){
            System.out.println("The array is sorted in ascending order");
        }
        else{
            System.out.println("The array is not sorted in ascending order");
        }
        sc.close();
    }
}
