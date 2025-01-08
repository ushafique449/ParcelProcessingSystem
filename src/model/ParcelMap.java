package model;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;


public class ParcelMap {
    private Map<String, Parcel> parcels;

    public ParcelMap() {
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    public void removeParcel(String parcelId) {
        parcels.remove(parcelId);
    }

    public Parcel getParcel(String parcelId) {
        return parcels.get(parcelId);
    }

    public Map<String, Parcel> getParcels() {
        return parcels;
    }
 public List<Parcel> getSortedParcelsByDaysInDepot() {
    return parcels.values().stream()
                  .sorted(Comparator.comparingInt(Parcel::getDaysInDepot))
                  .collect(Collectors.toList());
}
 
 public void loadFromFile(String filename) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
        String line;
        boolean firstLine = true; 
        while ((line = reader.readLine()) != null) {
            if (firstLine) {
                firstLine = false;
                continue;
            }

            
            String[] data = line.split(",");

            
            String id = data[0];
            double length = Double.parseDouble(data[1]);
            double width = Double.parseDouble(data[2]);
            double height = Double.parseDouble(data[3]);
            double weight = Double.parseDouble(data[4]);
            int daysInDepot = Integer.parseInt(data[5]);

            
            Dimension dimensions = new Dimension(length, width, height);
            addParcel(new Parcel(id, dimensions, weight, daysInDepot));
        }
    }
}
}