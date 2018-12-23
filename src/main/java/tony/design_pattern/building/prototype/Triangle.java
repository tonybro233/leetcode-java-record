package tony.design_pattern.building.prototype;

public class Triangle extends Shape {

    public Triangle() {
        this.type = "Triangle";
    }

    @Override
    void draw() {
        System.out.println("   /\\");
        System.out.println("  /  \\");
        System.out.println(" /    \\");
        System.out.println("/      \\");
        System.out.println("————————");
    }
}
