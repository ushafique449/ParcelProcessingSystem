package model;

public class Dimension {
    private double length;
    private double width;
    private double height;

    public Dimension(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Dimensions [Length=" + length + ", Width=" + width + ", Height=" + height + "]";
    }
}