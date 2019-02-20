package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello user!");
        System.out.println("Our software will need some information about you before continue with the main part.");

        System.out.println("Are you a student (Yes/No)?");
        String answer = in.nextLine();
        String[] cData = commonData();
        if (answer.equals("Yes")) {
            String[] studentData = studentData();

            if (cData.length == 4) {
                Student student = new Student(cData[0], cData[1], cData[2], Integer.parseInt(cData[3]),
                        studentData[0], Double.parseDouble(studentData[1]));
            } else if (cData.length == 5) {
                Student student = new Student(cData[0], cData[1], cData[2], Integer.parseInt(cData[3]), cData[4],
                        studentData[0], Double.parseDouble(studentData[1]));
            } else {
                Student student = new Student(cData[0], cData[1], cData[2], Integer.parseInt(cData[3]), cData[4],
                        cData[5], studentData[0], Double.parseDouble(studentData[1]), Integer.parseInt(studentData[2]));
            }
        } else {
            String[] devData = devData();
        }
    }

    public static String[] devData() {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your salary per month? ");
        String salary = in.nextLine();


    }

    public static String[] commonData() {
        Scanner in = new Scanner(System.in);
        System.out.println("*Enter your first name: ");
        String firstName = in.nextLine();
        System.out.println("*Enter your last name: ");
        String lastName = in.nextLine();
        System.out.println("*Enter your age: ");
        String age = in.nextLine();
        System.out.println("*Email: ");
        String email = in.nextLine();
        System.out.println("Phone number: ");
        String phoneNumber = in.nextLine();
        System.out.println("country:");
        String country = in.nextLine();

        if (phoneNumber.isEmpty() || country.isEmpty())
            return new String[]{firstName, lastName, age, email};

        return new String[]{firstName, lastName, age, email, phoneNumber, country};
    }

    public static String[] studentData() {
        Scanner in = new Scanner(System.in);
        System.out.println("*What is the name of your uni ?");
        String uniName = in.nextLine();
        System.out.println("*Your GPA ?");
        String gpa = in.nextLine();
        System.out.println("How many hours per day you stud?");
        String hoursPerDay = in.nextLine();

        if (hoursPerDay.isEmpty())
            return new String[]{uniName, gpa};

        return new String[]{uniName, gpa, hoursPerDay};
    }
}
