package rentAcar;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String city;
    private double pricePerDay;
    private String date;

    public Car(int id, String brand, String model, String city, double pricePerDay, String date) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %f %s", id, brand, model, city, pricePerDay, date);
    }
}
