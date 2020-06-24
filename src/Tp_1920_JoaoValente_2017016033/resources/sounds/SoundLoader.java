package Tp_1920_JoaoValente_2017016033.resources.sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundLoader {
    static MediaPlayer mp;
    static MediaPlayer mpf;
    static double sound;

    public static void playMusic(String nome) {
        String path = SoundLoader.class.getResource(nome).toExternalForm();
        Media music = new Media(path);
        mp = new MediaPlayer(music);
        mp.setStartTime(Duration.millis(250));
        mp.setStopTime(music.getDuration());
        mp.setVolume(sound);
        mp.setAutoPlay(true);
    }

    public static void playMusicFundo(String nome) {
        try {
            String path = SoundLoader.class.getResource(nome).toExternalForm();
            Media music = new Media(path);
            mpf = new MediaPlayer(music);
            mpf.setStopTime(Duration.INDEFINITE);
            mpf.setOnEndOfMedia(new Runnable() {
                public void run() {
                    mpf.seek(Duration.ZERO);
                }
            });
            mpf.setAutoPlay(true);
        } catch (NullPointerException es) {
            mpf.stop();
        }
    }

    public static void changeVolume(double val) {
        sound = val / 100;
        mpf.setVolume(val / 100);
    }
}
