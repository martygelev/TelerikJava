package tu;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int id;
    private String city;
    private String description;
    private String date;
    private int availableNumberOfParticipants;

    public Event(int id, String city, String description, String date, int availableNumberOfParticipants) {
        this.id = id;
        this.city = city;
        this.description = description;
        this.date = date;
        this.availableNumberOfParticipants = availableNumberOfParticipants;
    }

    public void setAvailableNumberOfParticipants(int availableNumberOfParticipants) {
        this.availableNumberOfParticipants = availableNumberOfParticipants;
    }

    public int getAvailableNumberOfParticipants() {
        return availableNumberOfParticipants;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }


}
