

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageInBottle {
    static String message;
    static ArrayList<Character> chiphers = new ArrayList<>();
    static ArrayList<String> chiphers2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        message = in.readLine();
        String chipher = in.readLine();

        char key = Character.MIN_VALUE;
        StringBuilder value = new StringBuilder();
        for(int i = 0; i < chipher.length(); i++) {
            if(chipher.charAt(i) >= 'A' && chipher.charAt(i) <= 'Z') {
                if(key != Character.MIN_VALUE) {
                    chiphers.add(key);
                    chiphers2.add(value.toString());
                    value = new StringBuilder();
                }
                key = chipher.charAt(i);
            } else {
                value.append(chipher.charAt(i));
            }
        }
        if(key != Character.MIN_VALUE) {
            chiphers.add(key);
            chiphers2.add(value.toString());
            value = new StringBuilder();
        }
        Solve(0, new StringBuilder());
        System.out.println(solutions.size());
        Collections.sort(solutions);
        for(String item : solutions) {
            System.out.println(item);
        }
    }

    static List<String> solutions = new ArrayList<>();


    static void Solve(int secretMessageIndex, StringBuilder sb) {
        if(secretMessageIndex == message.length()) {
            solutions.add(sb.toString());
            return;
        }
        for(int i = 0; i < chiphers.size(); i++) {
            if(message.substring(secretMessageIndex).startsWith(chiphers2.get(i))) {
                sb.append(chiphers.get(i));
                Solve(secretMessageIndex + chiphers2.get(i).length(), sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
