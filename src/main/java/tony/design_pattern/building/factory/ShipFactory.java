package tony.design_pattern.building.factory;

public class ShipFactory implements AbstractFactory {
    @Override
    public AbstractProduct build() {
        return new Ship();
    }
}
