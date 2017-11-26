package algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SimpleTextQueries {

    static void textQueries(String[] sentences, String[] queries) {
        List<List<Integer>> foundList = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < sentences.length; j++) {
            String[] words = queries[i].split(" ");
            boolean found = true;
            for (String word : words) {
                if (sentences[j].indexOf(word) == -1) {
                    found = false;
                }
            }
            if (found) {
//                foundList.add();
            } else {
                System.out.println("-1");
            }
        }
    }


    public static void main(String[] args) {

    }
}
