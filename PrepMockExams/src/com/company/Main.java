package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

      int housesToVisit = in.nextInt();
      int presents = in.nextInt();
      int presentsAtFirstTime =presents;
      int counterBack = 0;
      int additionalPresentsTaken=0;

      for (int i= 1; i<=housesToVisit;i++)
      {
        int presentsToLeave = in.nextInt();

        presents-=presentsToLeave;

        if (presents<0)
        {
            int currentLeft = Math.abs(presents);

            presents=(presentsAtFirstTime / i) * (housesToVisit-i) +currentLeft;
            additionalPresentsTaken+=presents;
presents-=currentLeft;
            counterBack++;

        }
      }

      if (additionalPresentsTaken!=0){
          System.out.println(counterBack);
          System.out.println(additionalPresentsTaken);
      }
      else{
          System.out.println(presents);
      }

    }
}
