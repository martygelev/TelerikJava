package ok;

import java.util.Scanner;

public class NumberOfPages {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int page;
        for ( page = 1; page!=0; page++){
            n-=String.valueOf(page).length();
        }
        System.out.println(--page);
    }
}
