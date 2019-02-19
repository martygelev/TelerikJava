package dsa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PlayerRanking {
    private static ArrayList<Player> ranklistOfPlayers = new ArrayList<>();
    private static HashMap<String, TreeSet<Player>> sortedByType = new HashMap<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] commands = bf.readLine().split(" ");


        while (!commands[0].equals("end")) {
            switch (commands[0]) {
                case "add":
                    add(commands);
                    break;

                case "find":
                    find(commands);
                    break;

                case "ranklist":
                    rankList(commands);
                    break;

            }
            commands = bf.readLine().split(" ");

        }
        System.out.println(result);

    }

    private static void rankList(String[] commands) {
        int start = Integer.parseInt(commands[1]);
        int end = Integer.parseInt(commands[2]);

        for (int i = start; i <= end; i++) {
            if (ranklistOfPlayers.size() >= i) {
                if (i == end) {
                    result.append(String.format("%d. %s", i, ranklistOfPlayers.get(i - 1).toString()));
                } else {
                    result.append(String.format("%d. %s; ", i, ranklistOfPlayers.get(i - 1).toString()));
                }
            }
        }
        result.append("\n");
    }

    private static void find(String[] commands) {
        result.append(String.format("Type %s: ", commands[1]));
        if (sortedByType.containsKey(commands[1])) {
            result.append(sortedByType.get(commands[1]).stream()
                    .limit(5)
                    .map(Player::toString)
                    .collect(Collectors.joining("; ")));
        }

        result.append("\n");
    }

    private static void add(String[] commands) {
        String newPlayersName = commands[1];
        String newPlayersType = commands[2];
        int newPlayersAge = Integer.parseInt(commands[3]);
        int newPlayersPosition = Integer.parseInt(commands[4]);

        Player newPlayer = new Player(newPlayersName, newPlayersType, newPlayersAge);

        if (ranklistOfPlayers.isEmpty()) {
            ranklistOfPlayers.add(newPlayer);
        } else {
            ranklistOfPlayers.add(newPlayersPosition - 1, newPlayer);
        }

        if (!sortedByType.containsKey(newPlayersType)) {
            sortedByType.put(newPlayersType, new TreeSet<>());
        }

        sortedByType.get(newPlayersType).add(newPlayer);

        result.append(String.format("Added player %s to position %d\n", newPlayersName, newPlayersPosition));
    }

    public static class Player implements Comparable<Player> {
        private String name;
        private String type;
        private int age;

        public Player(String name, String type, int age) {
            this.name = name;
            this.type = type;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public int getAge() {
            return age;
        }


        @Override
        public int compareTo(Player o) {
            int compareNames = this.getName().compareTo(o.getName());
            if (compareNames == 0) {
                compareNames = Integer.compare(this.getAge(), o.getAge());
                return -compareNames;
            }
            return compareNames;
        }

        @Override
        public String toString() {
            return String.format("%s(%d)", this.getName(), this.getAge());
        }
    }
}


