import java.util.Arrays;
import java.util.Scanner;

public class SongsGO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        int[] array1 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] array2 = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rename = new int[n + 1];

        for (int i = 0; i < n; i++)
        {
            rename[array1[i]] = i;
        }

        for (int i = 0; i < n; i++)
        {
            array2[i] = rename[array2[i]];
        }

        int[] tree = new int[n];

        for(int i = 0; i < n; i++)
        {
            Update(tree, i, 1);
            array1[array2[i]] = i;
        }

        long inversions = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            Update(tree, array1[i], -1);
            inversions += Query(tree, array1[i]);
        }

        System.out.println(inversions);
    }
    public static void Update(int[] tree, int index, int val)
    {
        while (index > 0)
        {
            tree[index] += val;
            index &= index - 1;
        }

        tree[0] += val;
    }

    public static int Query(int[] tree, int index)
    {
        int n = tree.length;

        int val = 0;
        while (index < n)
        {
            val += tree[index];
            index += index & -index;
            if (index == 0)
            {
                break;
            }
        }

        return val;
    }
}
