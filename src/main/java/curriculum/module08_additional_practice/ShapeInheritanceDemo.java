public class ShapeInheritanceDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(3.0);
        Shape rectangle = new Rectangle(4.0, 5.0);
        System.out.printf("Circle area: %.2f%n", circle.area());
        System.out.printf("Rectangle area: %.2f%n", rectangle.area());
    }

    abstract static class Shape {
        abstract double area();
    }

    static class Circle extends Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }
    }
}
