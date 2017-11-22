package algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

    private static int requiredTransmitters(int[] arr, int k) {
        int count = 0;
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            int from = arr[i];
            while (i < arr.length && arr[i] - from <= k) {
                i++;
            }
            int to = arr[i - 1];
            while (i < arr.length && arr[i] - to <= k) {
                i++;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for (int x_i = 0; x_i < n; x_i++) {
            x[x_i] = in.nextInt();
        }
        System.out.println(requiredTransmitters(x, k));
    }
}
