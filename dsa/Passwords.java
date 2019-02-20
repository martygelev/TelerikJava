import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class PasswordsV23 {
    private static int convert(String s) {
        int value = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                flag = -1;
            } else {
                value = value * 10 + (s.charAt(i) - '0');
            }
        }
        if (flag == -1) {
            return -value;
        }
        return value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n = convert(input[0]);
        String directions = input[1];
        int k = convert(input[2]);
        ArrayList<Integer> password = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            password.add(0);
        }

        hack(directions, -1, password, 0, 0, -1, n, k, 0);
    }

    private static int hack(String directions, int dirIndex, ArrayList<Integer> password,
                            int index, int keysIndex, int currentNumber, int n, int k, int passwordCount) {

        if (index == n) {
            passwordCount += 1;
        }

        if (passwordCount == k) {
            for (int c : password) {
                System.out.printf("%d", c);
            }
            return passwordCount;
        }

        if (passwordCount > k) {
            return 1;
        }

        ArrayList<Integer> keys = generateKeys(directions, dirIndex, currentNumber);
        for (int i = 0; i < keys.size(); i++) {
            password.set(index, keys.get(i));
            currentNumber = password.get(index);
            passwordCount += hack(directions, dirIndex + 1, password, index + 1, i, currentNumber, n, k,
                    passwordCount);
            passwordCount++;
        }
        return passwordCount;
    }

    private static ArrayList<Integer> generateKeys(String directions, int dirIndex, int currentNumber) {
        ArrayList<Integer> keys = new ArrayList<>();
        if (dirIndex < 0) {
            if (directions.charAt(0) == '>') {
                keys.add(1);
                keys.add(0);
                for (int i = 2; i < 10; i++) {
                    keys.add(i);
                }
            } else if (directions.charAt(0) == '<') {
                keys.add(0);
                for (int i = 2; i < 10; i++) {
                    keys.add(i);
                }
            }
            return keys;
        }

        if (directions.charAt(dirIndex) == '>') {
            if (currentNumber < 0) {
                keys.add(0);
            }
            for (int i = currentNumber + 1; i < 10; i++) {
                keys.add(i);
            }
            if (currentNumber > 0) {
                keys.add(0);
            }
        } else if (directions.charAt(dirIndex) == '<') {
            for (int i = 1; i < currentNumber; i++) {
                keys.add(i);
            }
        } else {
            keys.add(currentNumber);
        }
        return keys;
    }
}
