package dsa;

import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String first = in.nextLine();
        String second = in.nextLine();

        int s = 0;
        int f = 0;

        while(f<second.length()){
            char c = first.charAt(s);
            if(c==' '){
                ++s;
                continue;
            }
            while(f<second.length()&&second.charAt(f)!=c)++f;
            if(f!=second.length()){
                ++s;
                ++f;
                if(s==first.length()) break;
            }
        }

        if(s==first.length()) System.out.println("true");
        else System.out.println("false");

    }
}
