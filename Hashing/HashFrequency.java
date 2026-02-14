import java.util.Scanner;

public class HashFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        int arr[] = new int[n];
        int max = 0;
        System.out.println("Enter the elements of array: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int hash[] = new int[max + 1];
        for(int i=0; i<n; i++){
            hash[arr[i]] += 1;
        }

        int query;
        System.out.println("Enter the size of your query: ");
        query = sc.nextInt();

        while(query-- > 0){
            int number;
            System.out.println("Enter your query: ");
            number = sc.nextInt();
            if(number <= max)
                System.out.println("Hash["+number+"]: " + hash[number]);
            else
                System.out.println("Hash["+number+"]: " + 0);
        }

        sc.close();

    }
}