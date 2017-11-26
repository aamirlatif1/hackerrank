package algorithms.dynamicProgramming;

public class ConsectiveSum {

    static int  consecutive(long num) {
        int count = 0;
        long start = 1;
        long end = 1;
        long current = 1;
        while (start <= num / 2) {
            if (current < num) {
                end += 1;
                current += end;
            } else if (current > num) {
                current -= start;
                start += 1;
            } else if (current == num) {
                count++;
                current -= start;
                start += 1;
            }
        }
        return  count;
    }



    public static void main(String[] args) {
        System.out.println(consecutive(15));
    }
}
