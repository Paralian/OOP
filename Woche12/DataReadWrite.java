import java.io.*;

public class DataReadWrite {
    public static void main(String[] args) {
        try {
            File file = new File("D:\\Kien's Personal Documents\\Uni Documents\\Marburg Uni\\WS1819 (Semester 02)\\Objektorientierte Programmierung\\Übungsabgabe\\OOP\\Woche12\\oop.dat.sec");
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            while (dis.available() > 0) {
                System.out.print(dis.readChar());
                dis.skipBytes(dis.readInt());
            }
            dis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try { // 12.2b2.txt(43KB) ist kleiner als 12.2b1.txt(108KB) weil DataOutputStream nur die binäre Repräsentation schreibt, während PrintStream eine Menschen-lesbare (Text-basierte) Darstellung von Werten erzeugt.
            File file1 = new File("D:\\Kien's Personal Documents\\Uni Documents\\Marburg Uni\\WS1819 (Semester 02)\\Objektorientierte Programmierung\\Übungsabgabe\\OOP\\Woche12\\12.2b1.txt");
            PrintStream ps = new PrintStream(file1);
            File file2 = new File("D:\\Kien's Personal Documents\\Uni Documents\\Marburg Uni\\WS1819 (Semester 02)\\Objektorientierte Programmierung\\Übungsabgabe\\OOP\\Woche12\\12.2b2.txt");
            FileOutputStream fos = new FileOutputStream(file2);
            DataOutputStream dos = new DataOutputStream(fos);
            for (short i = 10000; i < 32001; i++) {
                ps.print(i);
                dos.writeShort(i);
            }
            ps.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
