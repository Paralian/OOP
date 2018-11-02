package Woche2;
public class aufgabeZwei {
    static void method1() {
        System.out.println("Enter method1");
        method2_1();
        method2_2();
        System.out.println("Exit method1");
    }

    static void method2_1() {
        System.out.println("Enter method2_1");
        method2_2();
        System.out.println("Exit method2_1");
    }

    static void method2_2() {
        System.out.println("Enter method2_2");
        method3();
        System.out.println("Exit method2_2");
    }

    static void method3() {
        System.out.println("Enter method3");
        System.out.println("Exit method3");
    }

    public static void main(String[] args) {
        method1();
    }
    /*
		Konsolenausgabe:

		Enter method1
		Enter method2_1
		Enter method2_2
		Enter method3
		Exit method3
		Exit method2_2
		Exit method2_1
		Enter method2_2
		Enter method3
		Exit method3
		Exit method2_2
		Exit method1
		*/
}
