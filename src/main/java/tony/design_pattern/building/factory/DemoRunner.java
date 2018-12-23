package tony.design_pattern.building.factory;

import java.util.ArrayList;
import java.util.List;

public class DemoRunner {
    public static void main(String[] args){
        for (AbstractFactory factory : Rigister.factories){
            AbstractProduct product = factory.build();
            System.out.println("product : "+product.getName());
        }
    }

    private static class Rigister {
        private static List<AbstractFactory> factories = new ArrayList<>();
        static {
            factories.add(new CarFactory());
            factories.add(new ShipFactory());
        }
    }
}
