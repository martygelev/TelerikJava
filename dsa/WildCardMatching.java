
 class WildcardMatching
{
    static boolean isMatch(String str, String pattern)
    {
        int strPointer = 0;
        int patternPointer = 0;
        int match = 0;
        int starIndex = -1;

        while (strPointer < str.length())
        {
            if (patternPointer < pattern.length() &&
                    (pattern.charAt(patternPointer) == '?' ||
                            str.charAt(strPointer) == pattern.charAt(patternPointer)))
            {
                strPointer++;
                patternPointer++;
            }
            else if (patternPointer < pattern.length() &&
                    pattern.charAt(patternPointer) == '*')
            {
                starIndex = patternPointer;
                match = strPointer;
                patternPointer++;
            }
            else if (starIndex != -1)
            {
                patternPointer = starIndex + 1;
                match++;
                strPointer = match;
            }
            else
                return false;
        }
        while (patternPointer < pattern.length() && pattern.charAt(patternPointer) == '*')
            patternPointer++;

        return patternPointer == pattern.length();
    }

    static boolean isMatchDP(String word, String pattern)
    {
        char[] wordChars = word.toCharArray();
        char[] patternChars = pattern.toCharArray();

        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length(); i++)
        {
            if (patternChars[i] == '*')
            {
                if (isFirst)
                {
                    patternChars[writeIndex++] = patternChars[i];
                    isFirst = false;
                }
            } else
            {
                patternChars[writeIndex++] = patternChars[i];
                isFirst = true;
            }
        }

        boolean[][] dp = new boolean[word.length() + 1][writeIndex + 1];

        if (writeIndex > 0 && patternChars[0] == '*')
            dp[0][1] = true;

        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++)
        {
            for (int j = 1; j < dp[0].length; j++)
            {
                if (wordChars[i - 1] == patternChars[j - 1] || patternChars[j - 1] == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (patternChars[j - 1] == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }

        return dp[word.length()][writeIndex];
    }

    public static void main(String[] args)
    {
        System.out.println(isMatchDP("acdcb", "a*c?*b"));
    }
}