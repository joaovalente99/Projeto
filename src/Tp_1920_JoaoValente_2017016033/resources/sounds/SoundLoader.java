package Tp_1920_JoaoValente_2017016033.resources.sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class SoundLoader {
    static MediaPlayer mp;

    public static void playMusic(String nome) {
        String path = SoundLoader.class.getResource(nome).toExternalForm();
        Media music = new Media(path);
        mp = new MediaPlayer(music);
        mp.setStartTime(Duration.millis(250));
        mp.setStopTime(music.getDuration());
        mp.setAutoPlay(true);
    }
}
