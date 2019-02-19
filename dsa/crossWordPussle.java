
import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

 class CrosswordPuzzle
{
    static void fakeInput()
    {
        String input = "+-++++++++\n" +
                "+-++++++++\n" +
                "+-++++++++\n" +
                "+-----++++\n" +
                "+-+++-++++\n" +
                "+-+++-++++\n" +
                "+++++-++++\n" +
                "++------++\n" +
                "+++++-++++\n" +
                "+++++-++++\n" +
                "LONDON;DELHI;ICELAND;ANKARA";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    static void crosswordPuzzle(String[] crossword, Set<String> hashSet)
    {
        if (hashSet.isEmpty())
            printResult(crossword);

        int[] IJVL = findNextPattern(crossword);

        String pattern = getPattern(crossword, IJVL);

        Iterator<String> it = hashSet.iterator();
        while (it.hasNext())
        {
            String word = it.next();
            if (canWrite(word, pattern))
            {
                String[] nextCrossword = writeWord(crossword, IJVL, word);

                Set<String> nextHashSet = new HashSet<>(hashSet);
                nextHashSet.remove(word);

                crosswordPuzzle(nextCrossword, nextHashSet);
            }
        }
    }

    static String[] writeWord(String[] crossword, int[] IJVL, String word)
    {
        if (IJVL[2] == 0) // if horizontal
        {
            crossword[IJVL[0]] = crossword[IJVL[0]].substring(0, IJVL[1]) + word +
                    crossword[IJVL[0]].substring(IJVL[3] + 1);

        } else // if vertical
        {
            int wordCounter = 0;
            for (int i = IJVL[0]; i < IJVL[3] + 1; i++)
                crossword[i] = crossword[i].substring(0, IJVL[1]) +
                        word.charAt(wordCounter++) +
                        crossword[i].substring(IJVL[1] + 1);
        }

        return crossword;
    }

    static boolean canWrite(String word, String pattern)
    {
        if (word.length() != pattern.length())
            return false;

        for (int i = 0; i < word.length(); i++)
        {
            char patternIndex = pattern.charAt(i);
            char wordIndex = word.charAt(i);

            if (patternIndex != '-' && patternIndex != wordIndex)
                return false;
        }

        return true;
    }

    static String getPattern(String[] crossword, int[] IJVL)
    {
        if (IJVL[2] == 0)  // if horizontal
            return crossword[IJVL[0]].substring(IJVL[1], IJVL[3] + 1);
        else // if vertical
        {
            StringBuilder sb = new StringBuilder();

            for (int i = IJVL[0]; i < IJVL[3] + 1; i++)
                sb.append(crossword[i].charAt(IJVL[1]));

            return sb.toString();
        }
    }

    static int[] findNextPattern(String[] crossword)
    {
        /* These are the parameters of the next empty place (the next word pattern) to write
           the word to. IJVL - I, J, Vertical(0/1), Last element'simplechess number */
        int[] IJVL = new int[]{-1, -1, -1, -1};
        int I = 0;
        int J = 0;

        outterLoop:
        for (int i = 0; i < crossword.length; i++)
        {
            for (int j = 0; j < crossword.length; j++)
            {
                if (crossword[i].charAt(j) == '-')
                {
                    I = i;
                    J = j;

                    break outterLoop;
                }
            }
        }

        if ((I > 0 && crossword[I - 1].charAt(J) != '+') ||
                (I < crossword.length - 1 &&
                        crossword[I + 1].charAt(J) != '+'))
        {
            IJVL[2] = 1; // vertical

            while (I > 0 && crossword[I - 1].charAt(J) != '+')
                I--;

            IJVL[0] = I;
            IJVL[1] = J;

            while (I < crossword.length - 1 &&
                    crossword[I + 1].charAt(J) != '+')
                I++;

            IJVL[3] = I;
        } else
        {
            IJVL[2] = 0; // horizontal
            IJVL[0] = I;

            while (J > 0 && crossword[I].charAt(J - 1) != '+')
                J--;

            IJVL[1] = J;

            while (J < crossword.length - 1 &&
                    crossword[I].charAt(J + 1) != '+')
                J++;

            IJVL[3] = J;
        }

        return IJVL;
    }

    static void printResult(String[] result)
    {
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static void main(String[] args)
    {
        fakeInput();
        Scanner input = new Scanner(System.in);

        String[] crossword = new String[10];

        for (int i = 0; i < 10; i++)
            crossword[i] = input.nextLine();

        String[] words = input.nextLine().split(";");
        Set<String> hashSet = new HashSet<>();

        for (String word : words)
            hashSet.add(word);

        crosswordPuzzle(crossword, hashSet);
    }
}