public class Vector3D {
    private double x, y, z;

    /**
     * Constructor of Class Vector3D
     */
    private Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * calculates the length of this vector
     * @return the length of the vector
     */
    private double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    /**
     * scales this vector with a given aspect ratio
     * @param a is the given aspect ratio
     * @return the scaled vector
     */
    private Vector3D scale(double a) {
        return new Vector3D(x * a, y * a, z * a);
    }

    /**
     * normalizes this vector
     * @return the normalized vector
     */
    private Vector3D norm() {
        return scale(1.0 / length());
    }

    /**
     * adds a given vector to this vector
     * @param vector is the given vector
     * @return the sum of two vectors
     */
    private Vector3D add(Vector3D vector) {
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    /**
     * subtracts a given vector from this vector
     * @param vector is the given vector
     * @return the difference between two vectors
     */
    private Vector3D sub(Vector3D vector) {
        return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
    }

    /**
     * find the cross product of this vector with a given vector
     * @param vector is the given vector
     * @return the cross product of two vectors
     */
    private Vector3D crossProduct(Vector3D vector) {
        return new Vector3D(y * vector.z - z * vector.y, z * vector.x - x * vector.z, x * vector.y - y * vector.x);
    }

    /**
     * prints the coordinates of this vector
     */
    private void print() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    public static void main(String[] args) {
        Vector3D vector = new Vector3D(3, 4, 12);
        Vector3D testVector = new Vector3D(1, 1, 1);
        System.out.print("This vector: ");
        vector.print();
        System.out.print("Test vector: ");
        testVector.print();
        System.out.println("Length of vector: " + vector.length());
        System.out.print("Scale this vector by 5: ");
        vector.scale(5).print();
        System.out.print("Normalize this vector: ");
        vector.norm().print();
        System.out.print("Add the test vector to this vector: ");
        vector.add(testVector).print();
        System.out.print("Subtract the test vector from this vector: ");
        vector.sub(testVector).print();
        System.out.print("Calculate the cross product of this vector with the test vector: ");
        vector.crossProduct(testVector).print();
    }
}
