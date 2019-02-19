package dsa;

import java.util.Scanner;

public class JumpJump {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        int index = 0;
        String msg = "Fell of the dancefloor at %d!";

        while(index>=0 && index<input.length()){
            char ch = input.toCharArray()[index];
            int num = ch- '0';

            if (ch=='^'){
                msg = "Jump, Jump, DJ Tomekk kommt at %d!";
                break;
            }
            else if (num ==0){
                msg = "Too drunk to go on after %d!";
                break;
            }
            else if (num%2==0){
                index+=num;
            }
            else if (num%2==1){
                index-=num;
            }
        }
        System.out.println(String.format(msg,index));
    }
}
