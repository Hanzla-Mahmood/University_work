
interface GeometricObject {
    abstract void getPerimeter();
    abstract void getArea();
}

// Implement the Circle class which implements the GeometricObject interface
class Circle implements GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void getPerimeter() {
        double perimeter = 2 * 3.14 * radius;
        System.out.println("Circle Perimeter: " + perimeter);
    }


    public void getArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}

// Test program to test the Circle class
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2); // Create a Circle object with radius 2

        // Display the perimeter and area of the circle
        circle.getPerimeter();
        circle.getArea();
    }
}
