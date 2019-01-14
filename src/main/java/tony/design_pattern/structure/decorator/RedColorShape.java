package tony.design_pattern.structure.decorator;

public class RedColorShape extends ShapeColorDecorator {

    public RedColorShape(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        this.decoratedShape.draw();
        showBorder();
    }

    private void showBorder(){
        System.out.println(" My border is Red.");
    }
}
