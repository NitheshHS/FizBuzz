package CodingPractice;

public class MainClass {
    public static void main(String[] args) {
        Object obj=new Object();
        Runnable evenOdd1 = new EvenOdd2Threads(obj);
        Runnable evenOdd2 = new EvenOdd2Threads(obj);
        new Thread(evenOdd1,"EVEN").start();
        new Thread(evenOdd2, "ODD").start();
    }
}
