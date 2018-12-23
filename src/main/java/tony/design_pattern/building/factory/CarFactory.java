package tony.design_pattern.building.factory;

public class CarFactory implements AbstractFactory {
    @Override
    public AbstractProduct build() {
        return new Car();
    }
}
