package tu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Event> allEvents = new ArrayList<>();
    public static Map<Integer, Event> map = new HashMap<>();

    public static void main(String[] args) {


    }

    public String showAllEvents(String city, String date) {
        StringBuilder sb = new StringBuilder();

        sb.append(allEvents.stream()
                .filter(x -> x.getCity().equals(city))
                .filter(x -> x.getDate().equals(date)))
                .append(System.lineSeparator());

        return sb.toString();
    }

    public void addNewParticipant(int id) {
        if (map.containsKey(id)) {
            int availableNumberOfParticipants = map.get(id).getAvailableNumberOfParticipants();
            if (availableNumberOfParticipants > 0) {
                map.get(id).setAvailableNumberOfParticipants(availableNumberOfParticipants--);

                Event e = allEvents.stream().filter(x -> x.getId() == id)
                        .findAny()
                        .orElse(null);

                // allEvents.
            } else {
                System.out.println();
            }
        }

    }
}
