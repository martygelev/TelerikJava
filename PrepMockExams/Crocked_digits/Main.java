package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Crocked_digits {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String number = reader.readLine();
        int sum = 0;
        int currentDigit = 0;
        for (int i =0;i<number.chars().count();i++){

            if(Character.isDigit(number.charAt(i))){
                currentDigit = Character.getNumericValue(number.charAt(i));
                sum += currentDigit;
            }

        }

        while(sum>9){
            int current = sum;
            sum=0;
            while(current>0){
                sum +=current%10;
                current = current/10;}
        }

        System.out.println(sum);

    }

}
