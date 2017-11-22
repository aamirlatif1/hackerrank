package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlor {

    static void findPair(int[] arr, int m){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            int temp = m - arr[i];
            if(temp > 0 && map.containsKey(temp)){
                System.out.println((map.get(temp)+1)+" "+(i+1));
                break;
            }
            map.put(arr[i], i);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++){
                arr[j] = in.nextInt();
            }
            findPair(arr, m);
        }
    }
}
