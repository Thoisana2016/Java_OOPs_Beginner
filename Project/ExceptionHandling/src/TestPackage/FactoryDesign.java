package TestPackage;
interface Shape{
    void draw();
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}
class ShapeFactory{
    public Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        else if (shapeType.equalsIgnoreCase( "Square")){
            return new Square();
        } else if (shapeType.equalsIgnoreCase("rectabgle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        return null;
    }
}
public class FactoryDesign {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("circlE");
        shape1.draw();
    }
}
