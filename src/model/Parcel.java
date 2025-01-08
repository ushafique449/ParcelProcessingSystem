package model;
public class Parcel {
    private String id;
    private Dimension dimensions;
    private double weight;
    private int daysInDepot;
    private ParcelStatus status;

    public Parcel(String id, Dimension dimensions, double weight, int daysInDepot) {
        this.id = id;
        this.dimensions = dimensions;
        this.weight = weight;
        this.daysInDepot = daysInDepot;
        this.status = ParcelStatus.WAITING_FOR_COLLECTION;
    }

    public String getId() {
        return id;
    }

    public Dimension getDimensions() {
        return dimensions;
    }

    public double getWeight() {
        return weight;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void setStatus(ParcelStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Parcel [ID=" + id + ", Dimensions=" + dimensions + ", Weight=" + weight +
                ", DaysInDepot=" + daysInDepot + ", Status=" + status + "]";
    }
}
