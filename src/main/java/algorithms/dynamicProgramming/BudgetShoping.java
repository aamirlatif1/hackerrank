package algorithms.dynamicProgramming;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BudgetShoping {

    /*
    static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
        int memo[][] = new int[bundleQuantities.length+1][bundleCosts.length+1];
        for(int qi = 0; qi <= bundleQuantities.length; qi++){
            for (int ci = 0; ci <= bundleCosts.length; ci++){
                if(qi == 0 || ci == 0){
                    memo[qi][ci] = 0;
                } else if(bundleCosts[ci-1] <= n) {
                    //K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                    memo[qi][ci] = Math.max(bundleCosts[ci-1] + memo[qi][n-ci])
                }
            }
        }
        return 0;
    }
*/
    static int budgetShopping(int n, int bundleCosts[], int bundleQuantities[]) {
        int memo[][] = new int[bundleQuantities.length + 1][n + 1];
        for (int quantity = 0; quantity <= bundleQuantities.length; quantity++) {
            for (int cost = 0; cost <= n; cost++) {
                if (quantity == 0 || cost == 0)
                    memo[quantity][cost] = 0;
                else if (bundleCosts[quantity - 1] <= cost)
                    memo[quantity][cost] = Math.max(bundleQuantities[quantity - 1] + memo[quantity - 1][cost - bundleCosts[quantity - 1]], memo[quantity - 1][cost]);
                else
                    memo[quantity][cost] = memo[quantity - 1][cost];
            }
        }
        return memo[bundleQuantities.length][n];
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        } else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        int bundleQuantities_size = 0;
        bundleQuantities_size = Integer.parseInt(in.nextLine().trim());

        int[] bundleQuantities = new int[bundleQuantities_size];
        for (int i = 0; i < bundleQuantities_size; i++) {
            int bundleQuantities_item;
            bundleQuantities_item = Integer.parseInt(in.nextLine().trim());
            bundleQuantities[i] = bundleQuantities_item;
        }

        int bundleCosts_size = 0;
        bundleCosts_size = Integer.parseInt(in.nextLine().trim());

        int[] bundleCosts = new int[bundleCosts_size];
        for (int i = 0; i < bundleCosts_size; i++) {
            int bundleCosts_item;
            bundleCosts_item = Integer.parseInt(in.nextLine().trim());
            bundleCosts[i] = bundleCosts_item;
        }

        res = budgetShopping(n, bundleQuantities, bundleCosts);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

}
