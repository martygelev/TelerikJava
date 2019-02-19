package ok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyBoardRow {
    public static void main(String[] args) {
        String[] input = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(input);

        for (String s : result) {
            System.out.println(s);
        }
    }
    public static String[] findWords(String[] words) {
        List<String> validWords = new ArrayList<>();
        String firstRow = "QWERTYUIOP";
        String secondRow = "ASDFGHJKL";
        String thirdRow = "ZXCVBNM";

        for (String word : words) {
            int counter =0;
            for (char ch : word.toUpperCase().toCharArray()) {
                if (firstRow.indexOf(ch)<0){
                    break;
                }
                counter++;
            }
            if (counter==word.length()){
                validWords.add(word);
            }
             counter =0;
            for (char ch : word.toUpperCase().toCharArray()) {
                if (secondRow.indexOf(ch)<0){
                    break;
                }
                counter++;
            }
            if (counter==word.length()){
                validWords.add(word);
            }
            counter=0;
            for (char ch : word.toUpperCase().toCharArray()) {
                if (thirdRow.indexOf(ch)<0){
                    break;
                }
                counter++;
            }
            if (counter==word.length()){
                validWords.add(word);
            }

        }
        String[] finalWords = new String[validWords.size()];
        validWords.toArray(finalWords);
        return finalWords;


    }
}
