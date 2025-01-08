package controller;
import model.*;
public class Worker {
    public void processCustomer(Customer customer, ParcelMap parcelMap) {
        Parcel parcel = parcelMap.getParcel(customer.getParcelId());
        if (parcel != null) {
            System.out.println("Processing Parcel for Customer: " + customer.getName());
            double fee = calculateFee(parcel);
            System.out.println("Fee calculated: £" + fee);
            parcel.setStatus(ParcelStatus.COLLECTED);
            parcelMap.removeParcel(parcel.getId());
        } else {
            System.out.println("Parcel not found for Customer: " + customer.getName());
        }
    }

    public double calculateFee(Parcel parcel) {
        return parcel.getWeight() * 10 + parcel.getDaysInDepot() * 2;
    }
}