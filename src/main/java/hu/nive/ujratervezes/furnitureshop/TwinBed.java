package hu.nive.ujratervezes.furnitureshop;

import java.util.List;

public class TwinBed extends Bed{

    public TwinBed(double bedFramePrice, SingleMattress singleMattress) {
        super(BedType.TWIN, bedFramePrice, singleMattress);
    }
}
