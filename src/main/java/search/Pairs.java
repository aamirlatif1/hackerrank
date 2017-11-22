package search;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();

        }
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        int pairs = 0;
        while (j < arr.length){
            int diff = arr[j] - arr[i];
            if(diff == k){
                pairs++;
                j++;
            } else if(diff < k){
                j++;
            }else{
                i++;
            }
        }
        System.out.println(pairs);
    }
}
