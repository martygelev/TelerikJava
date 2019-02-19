package ok;

public class City {
    private String name;
    private String countryName;
    private String postalCode;

    public City(String name, String countryName, String postalCode) {
        this.name = name;
        this.countryName = countryName;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)){
            return false;
        }
        return ((City)obj).name.equals(((City) obj).name);
    }
}

