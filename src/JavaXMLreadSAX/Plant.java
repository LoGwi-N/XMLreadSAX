package JavaXMLreadSAX;

public class Plant {

    private String common;
    private String botanical;
    private String light;
    private String zone;
    private double price;
    private int availability;

    public Plant(String common, String botanical, String light, String zone, double price, int availability) {
        this.common = common;
        this.botanical = botanical;
        this.light = light;
        this.zone = zone;
        this.price = price;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "hashCode='" + this.hashCode() + "\' " +
                "Common='" + common + '\'' +
                ", Botanical='" + botanical + '\'' +
                ", Light='" + light + '\'' +
                ", Zone='" + zone + '\'' +
                ", Price=" + price +
                ", Availability=" + availability +
                '}';
    }

    public String getCommon() {
        return common;
    }

    public String getBotanical() {
        return botanical;
    }

    public String getLight() {
        return light;
    }

    public String getZone() {
        return zone;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }
}

