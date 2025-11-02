package infyJava.threadToLamda;

public class ThreadToLamda {

    public static void main(String[] args) {
        Thread threadInstance = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("It's me from thread!");
            }
        });
        threadInstance.start();
    }

}
