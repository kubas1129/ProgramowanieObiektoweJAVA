package ShapePackage;

public class ShapeMain {
    public static void main(String[] arg)
    {
        Shape triangle = new Triangle();
        triangle.draw();

        Shape rectangle = new Rectangle();
        rectangle.draw();

        Shape circle = new Circle();
        circle.draw();

        Shape square = new Square();
        square.draw();
    }
}
