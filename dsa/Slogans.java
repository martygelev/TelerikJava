package dsa;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Slogans {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] suggestedWords = bf.readLine().split(" ");
            String sloganToTry = bf.readLine();

            ArrayList<String> usedWords = new ArrayList<>();
            HashSet<String> impossibles = new HashSet<>();

            if (generateVariants(suggestedWords,sloganToTry,usedWords,impossibles)){
                ArrayList<String> usedWords2 = new ArrayList<>();
                for (int j = usedWords.size()-1; j >= 0; j--) {
                    usedWords2.add(usedWords.get(j));
                }
                sb.append(String.join(" ",usedWords2));
            }else {
                sb.append("NOT VALID");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean generateVariants(String[] suggestedWords, String sloganToTry, ArrayList<String> usedWords, HashSet<String> impossibles) {
        if (sloganToTry.length()<1){
            return true;
        }

        if (impossibles.contains(sloganToTry)){
            return false;
        }

        for (String word:suggestedWords){
            if (sloganToTry.startsWith(word)){
                String subSlogan = sloganToTry.substring(word.length());
                if (generateVariants(suggestedWords,subSlogan,usedWords,impossibles)){
                    usedWords.add(word);
                    return true;
                }
            }
        }
        impossibles.add(sloganToTry);
        return false;
    }
}

