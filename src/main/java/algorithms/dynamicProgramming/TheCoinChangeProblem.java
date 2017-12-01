package algorithms.dynamicProgramming;

import java.util.Scanner;

public class TheCoinChangeProblem {

    static long getWays(int n, int[] c){
        long[] combination = new long[n+1];
        combination[0] = 1;
        for (int coin : c)
            for (int amount = 1; amount <= n; amount++)
                if(amount >= coin)
                    combination[amount] += combination[amount-coin];
        return combination[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextInt();
        }
        long ways = getWays(n, c);
        System.out.println(ways);
    }

}
