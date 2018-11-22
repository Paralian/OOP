package Woche6;

import static java.lang.Math.*;

public class Vector3D {
    
    double x;
    double y;
    double z;
    
    Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        
    }
    
    double length() {
        return sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
    }
    
    Vector3D scale(double a) {
        return new Vector3D(x * a, y * a, z * a);
    }
    
    //normalize vector, return a new vector with length == 1
    Vector3D norm() {
        double l = this.length();
        
    }
    
    //komponentenweise Addition
    Vector3D add(Vector3D vector) {
        double sx = this.x + vector.x;
        double sy = this.y + vector.y;
        double sz = this.z + vector.z;
        return new Vector3D(sx, sy, sz);
    }
    
    //komponentenweise Subtraktion
    Vector3D sub(Vector3D vector) {
        double dx = this.x - vector.x;
        double dy = this.y - vector.y;
        double dz = this.z - vector.z;
        return new Vector3D(dx, dy, dz);
    }
    
    //Kreuzprodukt
    //TODO: check if this shit makes sense 
    //https://de.wikipedia.org/wiki/Kreuzprodukt#Komponentenweise_Berechnung
    Vector3D crossProduct(Vector3D vector) {
        double mx = this.x * vector.x;
        double my = this.y * vector.y;
        double mz = this.z * vector.z;
        return new Vector3D(mx, my, mz);
    }
    
    void print() {
        System.out.print("X = " + x + "\nY = " + y + "\nZ = " + z);
    }
    
    public static void main(String[] args) {
    
    }
}

