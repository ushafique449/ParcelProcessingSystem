/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author PC
 */
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
}