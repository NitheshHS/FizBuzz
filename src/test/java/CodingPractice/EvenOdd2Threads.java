package CodingPractice;

public class EvenOdd2Threads implements Runnable {
    static int count=0;
    private Object object;

    public EvenOdd2Threads(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while(count<=10) {
            synchronized (object) {
                if (count % 2 == 0 && Thread.currentThread().getName().equals("EVEN")) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " even value: " + count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
            synchronized (object) {
                if (count % 2 != 0 && Thread.currentThread().getName().equals("ODD")) {
                    System.out.println("Thread Name: " + Thread.currentThread().getName() + " odd value: " + count);
                    count++;
                    object.notify();
                }
            }
        }
    }
}
