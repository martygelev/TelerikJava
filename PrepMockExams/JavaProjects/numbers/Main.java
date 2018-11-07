import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        String[] commands = in.readLine().split(" ");

        while (!commands[0].equals("end")) {
            switch (commands[0]) {
                case "set":
                    sb.setLength(0);
                    sb.append(commands[1]);
                    break;
                case "front-add":
                    if (sb.length()>0) {
                        String newString = String.format("%s%s", commands[1], sb.toString());
                        sb.setLength(0);
                        sb.append(newString);
                    }else {
                        sb.append(commands[1]);
                    }
                    break;
                case "front-remove":
                    if (sb.length()>0) {
                        sb.deleteCharAt(0);
                    }
                    break;
                case "back-add":
                    sb.append(commands[1]);
                    break;
                case "back-remove":
                    if(sb.length()>0) {
                        sb.setLength(sb.length() - 1);
                    }
                    break;
                case "reverse":
                    if (sb.length()>0) {
                        sb.reverse();
                    }
                    break;
                case "print":
                    result.append(String.format("%s\n",sb.toString()));
                    break;
            }
            commands = in.readLine().split(" ");
        }
        System.out.println(result);

    }
}