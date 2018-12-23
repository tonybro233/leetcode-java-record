package tony.design_pattern.building.prototype;

public class DemoRunner {

    public static void main(String[] args){
        ShapeCache.loadCache();
        Shape shape = ShapeCache.getShape("2");
        shape.draw();
    }
}
