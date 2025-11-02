package SingletonDesign;

public class AudioPlayer {

    private static AudioPlayer instance;
    private boolean isPlaying = false;

    private static AudioPlayer getInstance(){
        if (instance == null ){
            instance = new AudioPlayer();
        }
        return instance;
    }

    public void play(String song){
        if (!isPlaying){
            System.out.println("Playing songs : "+song);
            isPlaying = true;
        }
        else {
            System.out.println("Already playing another song!");
        }
    }

    public void stop(){
        System.out.println("Music Stopped!");
        isPlaying = false;
    }

    public static void main(String[] args) {

        AudioPlayer a = AudioPlayer.getInstance();
        AudioPlayer b = AudioPlayer.getInstance();

        a.play("Imagine - John Lennon");
        b.play("Hey Judy - The Beatles");
        a.stop();


        System.out.println("Same player instance ?"+(a == b));
    }

}

