import java.util.Scanner;

public class Beach {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strs = in.nextLine().split(" ");
        Double sx = Double.parseDouble(strs[0]);
        Double sy = Double.parseDouble(strs[1]);
        Double v1 = Double.parseDouble(strs[2]);

        strs = in.nextLine().split(" ");
        Double ex = Double.parseDouble(strs[0]);
        Double ey = Double.parseDouble(strs[1]);
        Double v2 = Double.parseDouble(strs[2]);

        double bestTime = GetTime(sx, sy, sx, v1) + GetTime(ex, ey, sx, v2);
        double currTime = GetTime(sx, sy, ex, v1) + GetTime(ex, ey, ex, v2);

        if (bestTime > currTime) {
            bestTime = currTime;
        }

        currTime = GetTime(sx, sy, (sx + sy) / 2, v1) + GetTime(ex, ey, (sx + sy) / 2, v2);

        if (bestTime > currTime) {
            bestTime = currTime;
        }

        {
            double dx = sx - ex;
            double r = sy / (-ey);
            double v = dx / (1 + r);
            double beach = ex + v;
            currTime = GetTime(sx, sy, beach, v1) + GetTime(ex, ey, beach, v2);
            if (bestTime > currTime) {
                bestTime = currTime;
            }
        }

        System.out.printf("{%.2f}", bestTime);
    }

    static double GetTime(double sx, double sy, double beach, double v) {
        double dx = sx - beach;
        double dist = Math.sqrt(dx * dx + sy * sy);
        return dist / v;
    }
}
