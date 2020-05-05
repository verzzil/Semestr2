package Semestr2;

public class NewThread implements Runnable {
    Thread t;
    NewThread() {
        t = new Thread(this,"ДочПоток");
        t.start();
        System.out.println("Дочерний поток запустился");
    }
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Дочерний поток: "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
