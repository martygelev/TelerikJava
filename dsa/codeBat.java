public class codeBat {
    public static void main(String[] args) {
        //  boolean a = strCopies("catcowcat", "cat", 2);
        //  System.out.println(a);
        //  int seq = strDist("catcowcat","cat");
        //   System.out.println(seq);

    }

    public static boolean strCopies(String str, String sub, int n) {
        if (func(str, sub) == n) return true;
        else return false;
    }

    private static int func(String str, String sub) {
        int strlen = str.length();
        int sublen = sub.length();
        if (strlen < sublen) return 0;
        if (str.substring(0, sublen).equals(sub))
            return 1 + func(str.substring(1), sub);
        else
            return func(str.substring(1), sub);
    }
}
