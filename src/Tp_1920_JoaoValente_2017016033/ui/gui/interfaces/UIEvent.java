package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;

import static java.awt.Color.*;

public class UIEvent extends VBox {

    private JogoMaqEstadosObservavel modeloObs;

    public UIEvent(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        HBox hbox = new HBox();
        Button btnEventoRand = new Button("Evento Random");
        Button btnEventoEsp = new Button("Evento Especifico");
        Spinner<Integer> id = new Spinner<>();
        SpinnerValueFactory<Integer> spinnerValues = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6);
        btnEventoEsp.setMinSize(200, 80);
        btnEventoRand.setMinSize(360, 80);
        id.setMinSize(200, 80);
        btnEventoRand.setMaxSize(200, 80);
        btnEventoEsp.setMaxSize(200, 80);
        id.setMaxSize(200, 80);
        id.setValueFactory(spinnerValues);
        id.setMinWidth(100);
        id.setMaxWidth(200);


        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(5, 5, 5, 5));
        setMinSize(50, 50);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(btnEventoEsp, id);
        getChildren().addAll(btnEventoRand, hbox);

        btnEventoEsp.setOnAction(actionEvent -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.caiEvento(id.getValue());
        });
        btnEventoRand.setOnAction(actionEvent -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.caiEvento();
        });

    }


    private void atualizaVista() {

        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.EVENT);
    }
}
