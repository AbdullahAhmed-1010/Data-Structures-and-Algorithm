import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<n; i++){
            hmap.put(arr[i], hmap.getOrDefault(arr[i], 0) + 1);
        }

        System.out.println("Enter the number of queries: ");
        int query = sc.nextInt();

        while(query-- > 0){
            System.out.println("Enter the element: ");
            int number = sc.nextInt();

            System.out.println("Frequency: " + hmap.getOrDefault(number, 0));
        }

        sc.close();
    }
}
