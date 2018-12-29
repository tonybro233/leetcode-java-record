package tony.design_pattern.structure.bridge;

public abstract class Bag {

    protected Color color;

    public abstract String getName();

    public void setColor(Color color) {
        this.color=color;
    }

}
