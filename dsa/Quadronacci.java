import java.util.ArrayList;
import java.util.Scanner;

public class Quadronacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> firstFourDigits = new ArrayList<>();
        firstFourDigits.add(in.nextInt());
        firstFourDigits.add(in.nextInt());
        firstFourDigits.add(in.nextInt());
        firstFourDigits.add(in.nextInt());
        int R = in.nextInt();
        int C = in.nextInt();
        long[][] quadNumbers = new long[R][C];

        quadNumbers[0][0] = firstFourDigits.get(0);
        quadNumbers[0][1] = firstFourDigits.get(1);
        quadNumbers[0][2] = firstFourDigits.get(2);
        quadNumbers[0][3] = firstFourDigits.get(3);

        if (R == 1) {

            for (int Col = 4; Col < C; Col++) {

                quadNumbers[0][Col] = quadNumbers[0][Col - 1] + quadNumbers[0][Col - 2] + quadNumbers[0][Col - 3] + quadNumbers[0][Col - 4];

            }
        } else if (R > 1 && C == 4) {

            for (int Row = 1; Row < R; Row++) {

                quadNumbers[Row][0] = quadNumbers[Row - 1][0] + quadNumbers[Row - 1][1] + quadNumbers[Row - 1][2] + quadNumbers[Row - 1][3];
                quadNumbers[Row][1] = quadNumbers[Row - 1][1] + quadNumbers[Row - 1][2] + quadNumbers[Row - 1][3] + quadNumbers[Row][0];
                quadNumbers[Row][2] = quadNumbers[Row - 1][2] + quadNumbers[Row - 1][3] + quadNumbers[Row][0] + quadNumbers[Row][1];
                quadNumbers[Row][3] = quadNumbers[Row - 1][3] + quadNumbers[Row][0] + quadNumbers[Row][1] + quadNumbers[Row][2];

            }
        } else if (R > 1 && C > 4) {

            for (int Col = 4; Col < C; Col++) {

                quadNumbers[0][Col] = quadNumbers[0][Col - 1] + quadNumbers[0][Col - 2] + quadNumbers[0][Col - 3] + quadNumbers[0][Col - 4];
            }
            for (int Row = 1; Row < R; Row++) {
                quadNumbers[Row][0] = quadNumbers[Row - 1][C - 1] + quadNumbers[Row - 1][C - 2] + quadNumbers[Row - 1][C - 3] + quadNumbers[Row - 1][C - 4];
                quadNumbers[Row][1] = quadNumbers[Row - 1][C - 1] + quadNumbers[Row - 1][C - 2] + quadNumbers[Row - 1][C - 3] + quadNumbers[Row][0];
                quadNumbers[Row][2] = quadNumbers[Row - 1][C - 1] + quadNumbers[Row - 1][C - 2] + quadNumbers[Row][0] + quadNumbers[Row][1];
                quadNumbers[Row][3] = quadNumbers[Row - 1][C - 1] + quadNumbers[Row][0] + quadNumbers[Row][1] + quadNumbers[Row][2];

                for (int Col = 4; Col < C; Col++) {

                    quadNumbers[Row][Col] = quadNumbers[Row][Col - 1] + quadNumbers[Row][Col - 2] + quadNumbers[Row][Col - 3] + quadNumbers[Row][Col - 4];
                }
            }
        }

        for (int Row = 0; Row < R; Row++) {
            for (int Col = 0; Col < C; Col++) {

                System.out.print(quadNumbers[Row][Col] + " ");
            }
            System.out.println();
        }
    }
}

