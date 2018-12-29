package tony.design_pattern.structure.bridge;

public class Wallet extends Bag {
    @Override
    public String getName() {
        return color.getColor()+" wallet";
    }
}
