package hu.nive.ujratervezes.furnitureshop;

import java.util.List;

public class KingBed extends Bed{

    public KingBed(double bedFramePrice, DoubleMattress doubleMattress) {
        super(BedType.KING, bedFramePrice, doubleMattress);
    }

    public KingBed(double bedFramePrice, SingleMattress singleMattressOne, SingleMattress singleMattressTwo) {
        super(BedType.KING, bedFramePrice, singleMattressOne, singleMattressTwo);
    }

}
