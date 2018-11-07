package DDD;
import java.util.*;

public class Main {

    private Set<Integer> firstPlayer;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String[] firstInput = in.nextLine().split(" ");
        String[] secondInput = in.nextLine().split(" ");

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (int i=0; i<20; i++)
        {
            firstPlayer.add(Integer.parseInt(firstInput[i]));
            secondPlayer.add(Integer.parseInt(secondInput[i]));

        }

        for (int i =0; i<50; i++)
        {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty())
            {
                System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First player win!");
                return;
            }

          int first =   firstPlayer.iterator().next();
            firstPlayer.remove(first);
            int seconfr = secondPlayer.iterator().next();
            secondPlayer.remove(seconfr);


            if (first>seconfr)
            {
                firstPlayer.add(first);
                firstPlayer.add(seconfr);
            }
            else if (first<seconfr)
            {
                secondPlayer.add(seconfr);
                secondPlayer.add(first);
            }
        }

        if (firstPlayer.size()>secondPlayer.size())
        {
            System.out.println("First player win!");
        }
        else if (firstPlayer.size()<secondPlayer.size())
        {
            System.out.println("Second player win!");
        }
        else System.out.println("Draw!");


    }
}
