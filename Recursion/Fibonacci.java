import java.util.Scanner;

public class Fibonacci {
    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        int last = fib(n-1);
        int secondLast = fib(n-2);

        return last+secondLast;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        int res = fib(n);
        System.out.println("Fibonacci number: " + res);

        sc.close();
    }
}
