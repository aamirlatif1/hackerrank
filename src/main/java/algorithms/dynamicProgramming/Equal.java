package algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {

    static void operations(int[] employees) {
        long ops = 0;
        if(employees.length > 0) {
            Arrays.sort(employees);
            int i = 1;
            int last = employees[0];
            int lastDiff = 0;
            while (i < employees.length) {
                if (last != employees[i] + lastDiff) {
                    int diff = employees[i] + lastDiff - last;
                    ops += diff / 5 + (diff % 5) / 2 + (diff % 5) % 2;
                    lastDiff = diff;
                }
                last = employees[i];
                i++;
            }
        }
        System.out.println(ops);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] employees = new int[n];
            for (int j = 0; j < n; j++) {
                employees[j] = in.nextInt();
            }
            operations(employees);
        }
    }
}
