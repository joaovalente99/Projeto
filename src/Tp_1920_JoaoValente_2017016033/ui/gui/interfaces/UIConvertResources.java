package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UIConvertResources extends VBox {

    private JogoMaqEstadosObservavel modeloObs;

    public UIConvertResources(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();
    }

    private void organizaComponentes() {

        ImageView fund = new ImageView(ImageLoader.getImage("cr.jpg"));
        fund.setFitHeight(200);
        fund.setFitWidth(500);

        Button btnConverterShield = new Button("Converter shield");
        Button btnConverterAmmo = new Button("Converter ammo");
        Button btnCoverterFuel = new Button("Converter fuel");
        Button btnContinuarViagen = new Button("Continuar viagem");
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));
        btnConverterShield.setMinSize(500, 30);
        btnConverterAmmo.setMinSize(500, 30);
        btnCoverterFuel.setMinSize(500, 30);
        btnContinuarViagen.setMinSize(500, 30);
        getChildren().addAll(fund, btnConverterShield, btnConverterAmmo, btnCoverterFuel, btnContinuarViagen);

        btnConverterShield.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.converteRecursos(1);
            if(modeloObs.getDados().getShip().getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes para completar a ação.");
                alert.showAndWait();
                modeloObs.getDados().atualizaSemRecurso();
            }
        });

        btnConverterAmmo.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.converteRecursos(2);
            if(modeloObs.getDados().getShip().getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes para completar a ação.");
                alert.showAndWait();
                modeloObs.getDados().atualizaSemRecurso();
            }
        });

        btnCoverterFuel.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.converteRecursos(3);
            if(modeloObs.getDados().getShip().getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes para completar a ação.");
                alert.showAndWait();
                modeloObs.getDados().atualizaSemRecurso();
            }
        });

        btnContinuarViagen.setOnAction( e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.continuaViagem();
        });
    }

    private void atualizaVista() {
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.CONVERT_RESOURCES);
        setManaged(interacaoEsperada == InteracaoEsperada.CONVERT_RESOURCES);
    }
}
