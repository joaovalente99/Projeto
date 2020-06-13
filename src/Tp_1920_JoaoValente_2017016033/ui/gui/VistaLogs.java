package Tp_1920_JoaoValente_2017016033.ui.gui;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class VistaLogs extends HBox {

    private JogoMaqEstadosObservavel modeloObs;
    private Label labelDados;

    public VistaLogs(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        organizaComponentes();
        this.modeloObs.addPropertyChangeListener(
                e -> labelDados.setText(modeloObs.getDados().getMsgLogEsp())
        );
    }

    private void organizaComponentes() {

        BackgroundSize backgroundSize = new BackgroundSize(1200, 720, false, false, false, true);
        BackgroundImage myBI = new BackgroundImage(ImageLoader.getImage("fundoEsq.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        setBackground(new Background(myBI));
        labelDados = new Label(modeloObs.toString());
        getChildren().addAll(labelDados);
        setSpacing(5);
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER);
    }
}
