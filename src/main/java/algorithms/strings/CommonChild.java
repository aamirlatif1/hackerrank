package algorithms.strings;

import java.util.Scanner;

public class CommonChild {

    static int commonChild(String s1, String s2){
        int LCStuff[][] = new int[s1.length() + 1][s2.length() + 1];
        int result = 1;  // To store length of the longest common substring
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        // Following steps build LCSuff[m+1][n+1] in bottom up fashion
        for (int i = 0; i <= s1.length(); i++)
        {
            for (int j = 0; j <= s2.length(); j++)
            {
                if (i == 0 || j == 0)
                    LCStuff[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCStuff[i][j] = LCStuff[i - 1][j - 1] + 1;
                    result = Math.max(result, LCStuff[i][j]);
                }
                else
                    LCStuff[i][j] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
    }
}
