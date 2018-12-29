package tony.design_pattern.structure.bridge;

public class HandBag extends Bag {

    @Override
    public String getName() {
        return color.getColor() + " handbag";
    }
}
