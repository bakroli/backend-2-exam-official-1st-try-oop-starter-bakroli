package hu.nive.ujratervezes.furnitureshop;

public class Mattress {
    private double price;
    private int width;

    public Mattress(double price, int width) {
        this.price = price;
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public int getWidth() {
        return width;
    }
}
