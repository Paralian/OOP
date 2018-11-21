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
     * adds this vector with a given vector
     * @param vector is the given vector
     * @return the sum of two vectors
     */
    private Vector3D add(Vector3D vector) {
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    /**
     * subtracts this vector with a given vector
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
        return new Vector3D(y*vector.z-z*vector.y, z*vector.x-x*vector.z, x*vector.y-y*vector.x);
    }

    /**
     * prints the coordinates of this vector
     */
    private void print() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    public static void main(String[] args) {
        Vector3D vector = new Vector3D(2, 4, 3);
        vector.print();
        System.out.println("Length of vector: " + vector.length());
        System.out.print("Vector scaled by 5: ");
        vector.scale(5).print();
        System.out.print("Vector normalized: ");
        vector.norm().print();
        System.out.print("Vector added to vector scaled by 5: ");
        vector.add(vector.scale(5)).print();
        System.out.print("Vectors subtracted from vector scaled by 5: ");
        vector.sub(vector.scale(5)).print();
        System.out.print("Cross product of vector with (1, 1, 1): ");
        vector.crossProduct(new Vector3D(1, 1, 1)).print();
    }
}
