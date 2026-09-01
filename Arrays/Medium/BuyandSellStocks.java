package Arrays.Medium;

import java.util.Scanner;

public class BuyandSellStocks {
    //bruteforce solution (TC = O(n^2) SC = O(1))
    public static int buyAndSell(int[] arr){
        int n = arr.length;
        int profit = 0;
        int maximumProfit = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                profit = arr[j] - arr[i];
                maximumProfit = Math.max(maximumProfit, profit);
            }
        }
        return maximumProfit;
    }
    //optimal solution -> using Dynamic Programming (TC = O(n) SC = O(1))
    public static int optimalSolution(int[] arr){
        int n = arr.length;
        int minimum = arr[0];
        int maximumProfit = 0;
        for(int i=0; i<n; i++){
            int profit = arr[i] - minimum;
            maximumProfit = Math.max(maximumProfit, profit);
            minimum = Math.min(minimum, arr[i]);
        }
        return maximumProfit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of days: ");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        System.out.println("Enter the price of the stocks on that day: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // int res = buyAndSell(arr);
        int res = optimalSolution(arr);
        System.out.println(res);

        sc.close();
    }
}
