package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] firstRow = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // digits
        int numberOfSteps = firstRow[1];

        String[] studentsArr = in.nextLine().split(" ");

        List<String> studentsList = new ArrayList<>(Arrays.asList(studentsArr));

        while(numberOfSteps--!=0) {

            String[] pairToChange = in.nextLine().split(" ");
            String firstStudent = pairToChange[0];
            String secondStudent = pairToChange[1];

            studentsList.remove(firstStudent);

            int indexSecond = studentsList.indexOf(secondStudent);

            if (indexSecond==0){
                studentsList.add(0,firstStudent);

            }
            else {
                studentsList.add(indexSecond , firstStudent);
            }
        }

        for (int i = 0; i < studentsList.size()-1; i++) {
            System.out.print(studentsList.get(i)+" ");
        }
        System.out.println(studentsList.get(studentsList.size()-1));

    }
}
