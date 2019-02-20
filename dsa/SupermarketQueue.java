package ok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SupermarketQueue {
    private static List<String> queue = new ArrayList<>();
    private static HashMap<String, Integer> names = new HashMap<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        while (!input.equals("End")) {
            String[] split = input.split(" ");

            switch (split[0]) {
                case "Append":
                    String nameToAppend = split[1];
                    appendCom(nameToAppend);

                    break;
                case "Insert":
                    int positionToInsert = Integer.parseInt(split[1]);
                    String nameToInsert = split[2];

                    insertCom(positionToInsert, nameToInsert);
                    break;
                case "Find":
                    String name = split[1];

                    findCom(name);
                    break;
                case "Serve":
                    int numberOFPeople = Integer.parseInt(split[1]);

                    serveCom(numberOFPeople);
                    break;
            }
            input = in.readLine();
        }
        System.out.print(result.toString());
    }

    private static void findCom(String name) {
        if (names.containsKey(name)) {
            result.append(names.get(name).toString());
            result.append(System.lineSeparator());

        } else {
            result.append("0");
            result.append(System.lineSeparator());

        }
    }

    private static void serveCom(int people) {

        if (people <= queue.size()) {
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while (i < people) {
                sb.append(String.format("%s ", queue.get(0)));
                names.put(queue.get(0), names.get(queue.get(0)) - 1);
                queue.remove(0);
                i++;
            }
            sb.setLength(sb.length() - 1);
            result.append(sb.toString());
            result.append(System.lineSeparator());


        } else {
            result.append("Error");
            result.append(System.lineSeparator());

        }
    }

    private static void insertCom(int pos, String name) {

        if (pos >= 0 && pos <= queue.size()) {
            queue.add(pos, name);
            if (!names.containsKey(name)) {
                names.put(name, 0);
            }

            names.put(name, names.get(name) + 1);
            result.append("OK");
            result.append(System.lineSeparator());
        } else {
            result.append("Error");
            result.append(System.lineSeparator());
        }
    }

    private static void appendCom(String name) {

        queue.add(name);
        if (!names.containsKey(name)) {
            names.put(name, 0);
        }

        names.put(name, names.get(name) + 1);
        result.append("OK");
        result.append(System.lineSeparator());

    }
}