import java.util.*;

public class JungleTrees {
    static class JungleTree implements Comparator<JungleTree>
    {
        public int X;
        public int Height;

        public JungleTree(int x, int h){
            this.X=x;
            this.Height=h;
        }

        public int getX() {
            return X;
        }


        @Override
        public int compare(JungleTree o1, JungleTree o2) {
            return o1.getX()-o2.getX();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strs =in.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int maxJumpDistance = Integer.parseInt(strs[1]);
        int maxHeightDifference = Integer.parseInt(strs[2]);

        JungleTree[] trees = new JungleTree[n];
        for(int i = 0; i < n; ++i)
        {
            strs = in.nextLine().split(" ");
            trees[i].X =Integer.parseInt(strs[0]);
            trees[i].Height = Integer.parseInt(strs[1]);
        }

        Arrays.sort(trees);

        int[] minJumps = new int[n];
        for(int i = 0; i < n; ++i)
        {
            minJumps[i] = -1;
        }

        minJumps[0] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while(q.size() > 0)
        {
            Integer from = q.peek();

            for(int to = 0; to < n; ++to)
            {
                if(minJumps[to] < 0
                        && Math.abs(trees[from].Height - trees[to].Height) <= maxHeightDifference
                        && Math.abs(trees[from].X - trees[to].X) <= maxJumpDistance)
                {
                    minJumps[to] = minJumps[from] + 1;
                    q.add(to);
                }
            }
        }

        System.out.println(minJumps[n - 1]);

    }
}
/*
5 10 3
13 1
9 4
4 7
18 5
20 8
 */ // -> 3

