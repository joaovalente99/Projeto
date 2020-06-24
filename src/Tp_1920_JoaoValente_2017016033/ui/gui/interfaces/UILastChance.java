package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UILastChance extends VBox {

    private JogoMaqEstadosObservavel modeloObs;
    private TextField tf;

    public UILastChance(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        ImageView fund = new ImageView(ImageLoader.getImage("LastChance.jpg"));
        fund.setFitHeight(200);
        fund.setFitWidth(500);

        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));

        HBox hb = new HBox();
        Button btnTrocaEContinua = new Button("Trocar recursos e continuar a jogar");
        Button btnSair = new Button("Sair");
        tf = new TextField();
        tf.setPromptText("Numero de recursos");
        btnTrocaEContinua.setMinSize(245, 30);
        btnSair.setMinSize(500, 30);
        tf.setMinSize(245, 30);

        hb.getChildren().addAll(tf, btnTrocaEContinua);
        hb.setPadding(new Insets(5, 5, 5, 5));
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);

        getChildren().addAll(fund, hb, btnSair);

        btnTrocaEContinua.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            try{
                int n = getValue();
                modeloObs.trocaMilagrosa(n);
            }catch(NumberFormatException ex){
            }
        });

        btnSair.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.gameOver();
        });


    }


    private void atualizaVista() {
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.LAST_CHANCE);
        setManaged(interacaoEsperada == InteracaoEsperada.LAST_CHANCE);
    }

    private int getValue() throws NumberFormatException {

        String s1 = (tf.getText()).trim();
        int value = 0;
        if (s1.length() < 1){
            throw new NumberFormatException();
        }
        value = Integer.parseInt(s1);
        return value;

    }
}
