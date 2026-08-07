package Arrays.Easy;

import java.util.Arrays;

public class UnionArray {
    public static int union(int[] arr1, int[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        int temp[] = new int[n1 + n2];
        for(int i=0; i<n1; i++){
            temp[i] = arr1[i];
        }
        for(int i=n1; i<n2; i++){
            temp[i] = arr2[i];
        }
        int n = temp.length;
        Arrays.sort(temp);
        
        if(n == 0){
            return 0;
        }
        int i = 0;
        for(int j=1; j<n; j++){
            if(temp[j] != temp[i]){
                i++;
                temp[i] = temp[j];
            }
        }
        return i+1;
    }
}