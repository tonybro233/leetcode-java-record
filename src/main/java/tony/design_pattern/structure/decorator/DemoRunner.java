package tony.design_pattern.structure.decorator;

public class DemoRunner {

    public static void main(String[] args){
        Shape circle = new Circle();

        Shape redCircle = new RedColorShape(new Circle());

        Shape redRectangle = new RedColorShape(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();
        System.out.println();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
