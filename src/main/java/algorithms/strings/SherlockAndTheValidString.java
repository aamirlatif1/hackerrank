package algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndTheValidString {
    static String isValid(String s){
        String output = "NO";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray() ){
            if(!freq.containsKey(c)){
                freq.put(c, 1);
            }else {
                freq.put(c, freq.get(c) + 1);
            }
        }
        Map<Integer, Integer> ff = new HashMap<>();
        for (Integer f : freq.values()){
            if(!ff.containsKey(f)){
                ff.put(f, 1);
            } else{
                ff.put(f, ff.get(f)+1);
            }
        }
        if(ff.size() == 1){
            output = "YES";
        } else if(ff.size() == 2){
            int k1 = 0, k2 = 0;
            int v1 = 0, v2 = 0;
            for (Map.Entry<Integer, Integer> entry: ff.entrySet()){
                if (k1 == 0){
                    k1 = entry.getKey();
                    v1 = entry.getValue();
                }else{
                    k2 = entry.getKey();
                    v2 = entry.getValue();
                }
            }
            if (v1 == 1 && (k1 == 1 || k1-1 == k2) || v2 == 1 && (k2 == 1 || k2-1 == k1) ){
                output = "YES";
            }

        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
