package demo;

public class Apartment implements House {
    private String[] extras;

    public String[] getExtras() {
        return extras;
    }

    public void setExtras(String[] extras) {
        this.extras = extras;
    }

    @Override
    public void sleepOn() {
        System.out.println("I sleep Where I want");
    }

    @Override
    public void eatOn() {
        System.out.println("I eat on my dest usually");
    }

    @Override
    public void showerOn() {
        System.out.println("bath :D");
    }

    @Override
    public int numberOfRooms() {
        return 4;
    }

    @Override
    public void extras(String[]... extras) {
        if (extras.length > 0) {
            System.out.println("In my apartment I have: ");
            for (String[] extra : extras) {
                System.out.print(extra + " ");
            }
        } else System.out.println("No ");

    }
}
