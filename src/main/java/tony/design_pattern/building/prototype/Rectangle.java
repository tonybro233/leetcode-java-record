package tony.design_pattern.building.prototype;

public class Rectangle extends Shape {

    public Rectangle(){
        this.type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println(" ── ── ── ── ─");
        System.out.println("|             |");
        System.out.println("|             |");
        System.out.println("|             |");
        System.out.println("|             |");
        System.out.println(" —— —— —— —— —");
    }
}
