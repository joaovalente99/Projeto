package Tp_1920_JoaoValente_2017016033.ui.gui;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class VistaDados extends VBox {

    private JogoMaqEstadosObservavel modeloObs;
    private Label labelDados;

    public VistaDados(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        organizaComponentes();
        this.modeloObs.addPropertyChangeListener(
                e -> labelDados.setText(modeloObs.toString())
        );
    }

    private void organizaComponentes() {

        BackgroundSize backgroundSize = new BackgroundSize(1200, 720, false, false, false, false);
        BackgroundImage myBI = new BackgroundImage(ImageLoader.getImage("fundoEsq.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        setBackground(new Background(myBI));

        labelDados = new Label(modeloObs.toString());
        getChildren().addAll(labelDados);
        setSpacing(5);
        setPadding(new Insets(5, 5, 5, 5));
        setAlignment(Pos.TOP_LEFT);
    }
}
