package dsa;

public class diamantiIRubini {
    public static void main(String[] args) {
        String s1 = "Sali";
        String w = "SasSALIsaAAAS";

        int result = numJewelsInStones(s1, w);
        System.out.println(result);
    }

    public static int numJewelsInStones(String str1, String str2) {
        int counter = 0;
        for (char o : str2.toCharArray()) {
            if (str1.contains(String.valueOf(o))) {

                counter++;
            }
        }
        return counter;
    }
}
