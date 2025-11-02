package thread;

public class LamdaAndThread {

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++){
                System.out.println("Running inside the thread : "+i);
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }

}
