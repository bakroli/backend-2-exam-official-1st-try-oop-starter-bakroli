package hu.nive.ujratervezes.furnitureshop;

import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {
    private List<Bed> bedList = new ArrayList<>();

    void addNewBed(Bed bed) {
        bedList.add(bed);
    }

    void removeBed(Bed bed) {
        bedList.remove(bed);
    }

    public List<Bed> getBedList() {
        return new ArrayList<>(bedList);
    }

    public double calculateAveragePriceOfBeds() {
        return bedList.stream()
                .mapToDouble(Bed::getPrice)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("No Beds"));
    }

    public int countAvailableBeds() {
        return bedList.size();
    }

    public List<Bed> getListOfBedsByType(BedType type) {
        return bedList.stream()
                .filter(p -> p.getType() == type)
                .toList();
    }

}
