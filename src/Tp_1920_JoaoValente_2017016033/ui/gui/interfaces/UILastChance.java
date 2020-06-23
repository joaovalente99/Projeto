package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import Tp_1920_JoaoValente_2017016033.resources.video.VideoLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class UILastChance extends HBox {

    private JogoMaqEstadosObservavel modeloObs;

    public UILastChance(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        go = new ImageView(ImageLoader.getImage("gameOver.jpg"));
        go.setFitHeight(200);
        go.setFitWidth(500);

        hb = new HBox();
        Button btnRecomeca = new Button("Recomecar jogo");
        Button btnSair = new Button("Sair");

        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        hb.setPadding(new Insets(5, 5, 5, 5));
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));
        btnRecomeca.setMinSize(200, 80);
        btnSair.setMinSize(200, 80);
        hb.getChildren().addAll(btnRecomeca, btnSair);
        getChildren().addAll(go, hb);



        btnRecomeca.setOnAction(actionEvent -> {
            SoundLoader.playMusic("menuSound.mp3");
            mv.getMediaPlayer().stop();
            getChildren().remove(mv);
            modeloObs.recomecaJogo();
        });
        btnSair.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            ((Stage) getScene().getWindow()).close();
        });

    }


    private void atualizaVista() {
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        if(interacaoEsperada == InteracaoEsperada.GAME_OVER) {
            mv = new MediaView(VideoLoader.playVideo("end.mp4"));
            getChildren().addAll(mv);
        }
        setVisible(interacaoEsperada == InteracaoEsperada.GAME_OVER);
        setManaged(interacaoEsperada == InteracaoEsperada.GAME_OVER);
    }
}
