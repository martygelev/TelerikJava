import java.util.Scanner;

public class StoolsGO {
    static int n;
    static Stool[] stools;
    static int[][][] memo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        stools = new Stool[n];

        memo = new int[1 << n][n][3];

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(" ");
            stools[i] = new Stool(
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2])
            );
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.max(result,
                        MaxHeight((1 << n) - 1, i, j));
            }
        }

        System.out.println(result);
    }

    static int MaxHeight(int used, int top, int side) {
        if (used == (1 << top)) {
            if (side == 0) {
                return stools[top].X;
            }
            if (side == 1) {
                return stools[top].Y;
            }
            return stools[top].Z;
        }

        if (memo[used][top][side] != 0) {
            return memo[used][top][side];
        }

        int fromStools = used ^ (1 << top);

        int sideX = (side == 0) ? stools[top].Y : stools[top].X;
        int sideY = (side == 2) ? stools[top].Y : stools[top].Z;
        int sideHeight = stools[top].X + stools[top].Y + stools[top].Z
                - sideX - sideY;

        int result = sideHeight;

        for (int i = 0; i < n; i++) {
            if (((fromStools >> i) & 1) == 1) {
                if ((stools[i].Y >= sideX && stools[i].Z >= sideY)
                        || (stools[i].Y >= sideY && stools[i].Z >= sideX)) {
                    result = Math.max(result, MaxHeight(fromStools, i, 0) + sideHeight);
                }

                if (stools[i].X == stools[i].Y && stools[i].X == stools[i].Z) {
                    continue;
                }

                if ((stools[i].X >= sideX && stools[i].Z >= sideY)
                        || (stools[i].X >= sideY && stools[i].Z >= sideX)) {
                    result = Math.max(result, MaxHeight(fromStools, i, 1) + sideHeight);
                }

                if ((stools[i].X >= sideX && stools[i].Y >= sideY)
                        || (stools[i].X >= sideY && stools[i].Y >= sideX)) {
                    result = Math.max(result, MaxHeight(fromStools, i, 2) + sideHeight);
                }
            }
        }

        memo[used][top][side] = result;
        return result;
    }

    static class Stool {
        private int X;
        private int Y;
        private int Z;

        public int getX() {
            return X;
        }

        public int getY() {
            return Y;
        }

        public int getZ() {
            return Z;
        }

        public void setY(int y) {
            Y = y;
        }

        public void setX(int x) {
            X = x;
        }

        public void setZ(int z) {
            Z = z;
        }

        public Stool(int x, int y, int z) {
            this.X = x;
            this.Y = y;
            this.Z = z;
        }
    }
}
