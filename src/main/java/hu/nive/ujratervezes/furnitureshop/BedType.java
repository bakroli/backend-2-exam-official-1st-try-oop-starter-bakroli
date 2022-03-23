package hu.nive.ujratervezes.furnitureshop;

public enum BedType {
    TWIN(90), KING(180);

    private int width;

    BedType(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
