package ss1_ss11.ss7_abstract_interface.resizable_geometric;

public abstract class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void resize(double percent);
}
