package indices;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());

        boolean[] visitedCells = new boolean[n];

        boolean c = false;
        int[] array = Arrays.stream(in.readLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();

        StringBuilder result = new StringBuilder();
        int currentCell = 0;
        int loopStartIndex = -1;

        while (!(currentCell < 0 || currentCell >= n)) {

            if (visitedCells[currentCell]) {
                loopStartIndex = currentCell;
                c=true;
                break;
            }

            result.append(currentCell);
            result.append(" ");
            visitedCells[currentCell] = true;
            currentCell = array[currentCell];
        }

        if (c==true) {

            int index = result.toString().indexOf((" " + loopStartIndex + " "));
            String print = "";
            if (loopStartIndex >= 0) {
                if (index < 0)
                    result.insert(0, "(");
                else {
                    result.insert(index, "(");

                }

            }
            print = print + result.toString();
            print = print.replace("( ", "(");
            print = print + ")";
            print = print.replace(" )", ")");
            System.out.println(print);

        }
        else {
            System.out.println(result.toString());
        }


    }
}

