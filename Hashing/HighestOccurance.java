import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HighestOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<n; i++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = 0;
        int element = -1;

        for(Map.Entry<Integer, Integer> entry : hash.entrySet()){
            if(entry.getValue() > maxFreq || (entry.getValue() == maxFreq && entry.getKey() < element)){
                maxFreq = entry.getValue();
                element = entry.getKey();        
            }
        }

        System.out.println("Element with highest frequency: " + element);
        System.out.println("Frequency: " + maxFreq);

        sc.close();
    }
}
