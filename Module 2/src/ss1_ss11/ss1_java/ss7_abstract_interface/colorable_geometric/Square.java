package ss1_ss11.ss1_java.ss7_abstract_interface.colorable_geometric;

public class Square extends Rectangle implements Resizeable {
    public Square() {}

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() + (getSide() * percent / 100));
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", area= " + getArea() + ", which is a subclass of " + super.toString();
    }
}