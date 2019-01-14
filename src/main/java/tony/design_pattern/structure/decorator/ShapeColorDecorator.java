package tony.design_pattern.structure.decorator;

public abstract class ShapeColorDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeColorDecorator(Shape shape){
        this.decoratedShape = shape;
    }

}
