import java.util.ArrayList;
import java.util.Scanner;

class Subset_S {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        scan.nextLine();
        String line = scan.nextLine();
        String[] str = line.trim().split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            numbers.add(Integer.parseInt(str[i]));
        }
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= sum + 1; i++) {
            visited.add(false);
        }
        visited.set(0, true);
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            for (int j = visited.size() - 1; j >= 0; j--) {
                if (j + number > sum) {
                    continue;
                }
                if (visited.get(j)) {
                    visited.set(j + number, true);
                }
            }
        }
        if (visited.get(sum)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

}