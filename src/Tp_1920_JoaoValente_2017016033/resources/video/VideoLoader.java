package Tp_1920_JoaoValente_2017016033.resources.video;

import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class VideoLoader {
    static MediaPlayer mp;

    public static MediaPlayer playVideo(String nome) {
        String path = VideoLoader.class.getResource(nome).toExternalForm();
        Media video = new Media(path);
        mp = new MediaPlayer(video);
        mp.setAutoPlay(true);
        return mp;
    }
}
