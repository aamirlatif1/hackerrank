package algorithms.strings;

import java.util.Scanner;

public class CamelCase {

    public static int countWords(String input){
        int words = 1;
        for(int i = 1; i < input.length(); i++){
            char c = input.charAt(i);
            if(Character.isUpperCase(c)){
                words++;
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(countWords(s));
    }

}
