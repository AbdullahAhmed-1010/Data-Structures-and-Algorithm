import java.util.Scanner;

public class CharacterHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        System.out.println("Enter the string: ");
        str = sc.nextLine();

        int hash[] = new int[256];
        for(int i=0; i<str.length(); i++){
            hash[str.charAt(i)]++;
        }

        int query;
        System.out.println("Enter the number of your queries: ");
        query = sc.nextInt();

        while(query-- > 0){
            char c;
            System.out.println("Enter your character: ");
            c= sc.next().charAt(0);

            System.out.println("Frequency: " + hash[c]);

        }

        sc.close();
    }
}