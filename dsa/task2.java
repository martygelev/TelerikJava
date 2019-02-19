package dsa;

public class task2 {
    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
       boolean result = backspaceCompare(S,T);
        System.out.println(result);
    }

    public static boolean backspaceCompare(String s1, String s2) {
        String str1 = calculate(s1).trim();

        String str2 = calculate(s2).trim();

        return str1.equals(str2);
    }

    public static String calculate (String s1){
        StringBuilder sb = new  StringBuilder(s1);

        if (sb.toString().contains("#")){
            while(sb.toString().contains("#")){
                int index = sb.indexOf("#");
                int prev = index-1;
                if (prev>=0){
                    sb.replace(prev,index+1,"");
                }
                else sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }
}
