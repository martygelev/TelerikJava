package avgDegree;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(in.nextLine());

        Map<String,double[]> grades = new TreeMap<>();

      while(numberOfStudents-->0)
      {
            String name = in.nextLine();

            double[] inputGrades = Arrays.stream(in
                    .nextLine()
                    .split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            grades.put(name,inputGrades);
        }

        for (Map.Entry<String,double[]> stringEntry : grades.entrySet()) {

            double avg = 0;
            for (double v :stringEntry.getValue()) {
                avg+=v;
            }
            avg/=stringEntry.getValue().length;
            System.out.println(stringEntry.getKey() + " is graduated with " +

                   avg);
        }
    }
}
