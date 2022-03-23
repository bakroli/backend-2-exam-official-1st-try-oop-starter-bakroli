package hu.nive.ujratervezes.furnitureshop;

import java.util.ArrayList;
import java.util.List;

public class Bed {
    private BedType type;
    private double bedFramePrice;
    private List<Mattress> mattressList = new ArrayList<>();

    public Bed(BedType type, double bedFramePrice, Mattress mattress) {
        this.type = type;
        this.bedFramePrice = bedFramePrice;
        this.mattressList.add(mattress);
    }

    public Bed(BedType type, double bedFramePrice, Mattress mattressOne, Mattress mattressTwo) {
        this.type = type;
        this.bedFramePrice = bedFramePrice;
        this.mattressList.add(mattressOne);
        this.mattressList.add(mattressTwo);
    }

    public BedType getType() {
        return type;
    }

    public double getBedFramePrice() {
        return bedFramePrice;
    }

    public List<Mattress> getMattressList() {
        return new ArrayList<>(mattressList);
    }

    public double getPrice() {
        return mattressList.stream().mapToDouble(Mattress::getPrice).sum() + bedFramePrice;
    }

}
