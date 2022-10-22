import java.io.*;

abstract class Shape {

    public static final int PI = 0;

    abstract float calc_area();

    abstract float calc_volume();

}

class Sphere extends Shape {

    float radius;

    public final static float PI = 3.14f;

    Sphere() {
        this(0);
    }

    Sphere(float radius) {
        this.radius = radius;
    }

    public float calc_area() {
        return (float) (4 * Sphere.PI * (Math.pow(this.radius, 2)));
    }

    public float calc_volume() {
        return (float) ((4 / 3) * Sphere.PI * (Math.pow(this.radius, 3)));
    }

    public static Sphere accept() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n\n_________SPHERE INPUT__________");

        System.out.print("\n\nEnter the radius of Sphere: ");
        float radius;
        while (true) {
            radius = Float.parseFloat(br.readLine());

            if (radius > 0)
                break;
            System.out.print("Radius should be greater than zero: ");
        }

        return new Sphere(radius);
    }

}

class Cone extends Shape {

    float height;
    float radius;

    public float calc_area() {
        return (float) (Sphere.PI * this.radius
                * (this.radius + Math.sqrt(Math.pow(this.height, 2) + Math.pow(this.radius, 2))));
    }

    public float calc_volume() {
        return (float) (Sphere.PI * Math.pow(this.radius, 2) * (this.height / 3));
    }

    Cone(float radius, float height) {
        this.radius = radius;
        this.height = height;
    }

    public static Cone accept() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n\n_________CONE INPUT__________");

        System.out.print("\n\nEnter the radius of Cone: ");
        float radius;
        while (true) {
            radius = Float.parseFloat(br.readLine());

            if (radius > 0)
                break;
            System.out.print("Radius should be greater than zero: ");
        }

        System.out.print("\nEnter the height of Cone: ");
        float height;
        while (true) {
            height = Float.parseFloat(br.readLine());

            if (height > 0)
                break;
            System.out.print("Height should be greater than zero: ");
        }

        return new Cone(radius, height);
    }

}

class Cylinder extends Shape {

    float radius;
    float height;

    Cylinder() {
        this(0, 0);
    }

    Cylinder(float radius, float height) {
        this.radius = radius;
        this.height = height;
    }

    public float calc_area() {
        return (float) ((2 * Sphere.PI * this.radius * this.height) + (2 * Shape.PI * Math.pow(this.radius, 2)));
    }

    public float calc_volume() {
        return (float) (Sphere.PI * Math.pow(this.radius, 2) * this.height);
    }

    public static Cylinder accept() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n\n_________CYLINDER INPUT__________");

        System.out.print("\n\nEnter the radius of Cylinder: ");
        float radius;
        while (true) {
            radius = Float.parseFloat(br.readLine());

            if (radius > 0)
                break;
            System.out.print("Radius should be greater than zero: ");
        }

        System.out.print("\nEnter the height of Cylinder: ");
        float height;
        while (true) {
            height = Float.parseFloat(br.readLine());

            if (height > 0)
                break;
            System.out.print("Height should be greater than zero: ");
        }

        return new Cylinder(radius, height);
    }

}

class Box extends Shape {

    float length;
    float breadth;
    float height;

    Box() {
        this(0f, 0f, 0f);
    }

    Box(float length, float breadth, float height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public float calc_area() {
        return (float) (2 * (this.height * this.breadth) + 2 * (this.height * this.length)
                + 2 * (this.breadth * this.length));
    }

    public float calc_volume() {
        return (float) (this.length * this.breadth * this.height);
    }

    public static Box accept() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\n\n_________CYLINDER INPUT__________");

        System.out.print("\n\nEnter the length of Box: ");
        float length;
        while (true) {
            length = Float.parseFloat(br.readLine());

            if (length > 0)
                break;
            System.out.print("Length should be greater than zero: ");
        }

        System.out.print("\nEnter the height of Box: ");
        float height;
        while (true) {
            height = Float.parseFloat(br.readLine());

            if (height > 0)
                break;
            System.out.print("Height should be greater than zero: ");
        }

        System.out.print("\nEnter the breadth of Box: ");
        float breadth;
        while (true) {
            breadth = Float.parseFloat(br.readLine());

            if (breadth > 0)
                break;
            System.out.print("Breadth should be greater than zero: ");
        }

        return new Box(length, breadth, height);
    }

}

class ShapeMain {

    public static void main(String[] args) throws IOException {

        Sphere sphere = Sphere.accept();
        System.out.printf("\nArea of Sphere:- %.2f\tVolume of Sphere:- %.2f", sphere.calc_area(), sphere.calc_volume());

        Cone cone = Cone.accept();
        System.out.printf("\nArea of Cone:- %.2f\tVolume of Cone:- %.2f", cone.calc_area(),
                cone.calc_volume());

        Cylinder cylinder = Cylinder.accept();
        System.out.printf("\nArea of Cylinder:- %.2f\tVolume of Cylinder:- %.2f",
                cylinder.calc_area(), cylinder.calc_volume());

        Box box = Box.accept();
        System.out.printf("\nArea of Box:- %.2f\tVolume of Box:- %.2f", box.calc_area(),
                box.calc_volume());

    }
}