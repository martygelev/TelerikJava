package demo;

public class Mansard implements House {
    @Override
    public void sleepOn() {
        System.out.println("bed");
    }

    @Override
    public void eatOn() {
        System.out.println("bed");
    }

    @Override
    public void showerOn() {
        System.out.println("bath");
    }

    @Override
    public int numberOfRooms() {
        return 1;
    }

    @Override
    public void extras(String[]... extras) {
        if (extras.length > 0) {
            for (String[] extra : extras) {
                System.out.print(extra + " ");
            }
        } else System.out.println("No ");
    }
}
