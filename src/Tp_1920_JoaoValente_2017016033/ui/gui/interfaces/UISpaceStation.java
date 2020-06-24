package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.logica.dados.MilitaryShip;
import Tp_1920_JoaoValente_2017016033.logica.dados.MiningShip;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UISpaceStation extends VBox {

    private JogoMaqEstadosObservavel modeloObs;
    private Button btnRealizarUpgradeWeapon;
    public UISpaceStation(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        ImageView fund = new ImageView(ImageLoader.getImage("st.jpg"));
        fund.setFitHeight(200);
        fund.setFitWidth(500);



        Button btnUpgradeCargoHold = new Button("Realizar upgrade a Cargo Hold");
        Button btnConverterRecursoNoutro = new Button("Converter um recurso noutro");
        Button btnContratarMembro = new Button("Contratar um membro para a equipa");
        Button btnArmorDrone = new Button("Meter a armor do drone a máximo");
        Button btnComprarDrone = new Button("Comprar outro drone");
        btnRealizarUpgradeWeapon = new Button("Realizar upgrade ao weapon system");
        Button btnContinuarViagen = new Button("Continuar viagem");
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));
        btnUpgradeCargoHold.setMinSize(500, 30);
        btnConverterRecursoNoutro.setMinSize(500, 30);
        btnContratarMembro.setMinSize(500, 30);
        btnArmorDrone.setMinSize(500, 30);
        btnComprarDrone.setMinSize(500, 30);
        btnRealizarUpgradeWeapon.setMinSize(500, 30);
        btnContinuarViagen.setMinSize(500, 30);
        getChildren().addAll(fund, btnUpgradeCargoHold, btnConverterRecursoNoutro, btnContratarMembro, btnArmorDrone,
                btnComprarDrone, btnRealizarUpgradeWeapon, btnContinuarViagen);


        btnUpgradeCargoHold.setOnAction(actionEvent -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.realizaUpgrades(1, 0, 0);
            if(modeloObs.getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes, sem cargo Hold ou level maximo atingido para completar a ação.");
                alert.showAndWait();
                modeloObs.atualizaSemRecurso();
            }
        });

        btnConverterRecursoNoutro.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            btnUpgradeCargoHold.setManaged(false);
            btnConverterRecursoNoutro.setManaged(false);
            btnContratarMembro.setManaged(false);
            btnArmorDrone.setManaged(false);
            btnComprarDrone.setManaged(false);
            btnContinuarViagen.setManaged(false);

            btnUpgradeCargoHold.setVisible(false);
            btnConverterRecursoNoutro.setVisible(false);
            btnContratarMembro.setVisible(false);
            btnArmorDrone.setVisible(false);
            btnComprarDrone.setVisible(false);
            btnContinuarViagen.setVisible(false);

            if(modeloObs.getShip() instanceof MilitaryShip) {
                btnRealizarUpgradeWeapon.setManaged(false);
                btnRealizarUpgradeWeapon.setVisible(false);
            }

            Button btnTroca = new Button("Trocar recursos");
            Button btnVoltar = new Button("Sair");
            ChoiceBox in = new ChoiceBox(FXCollections.observableArrayList("Black", "Red", "Green", "Blue"));
            ChoiceBox out = new ChoiceBox(FXCollections.observableArrayList("Black", "Red", "Green", "Blue"));


            btnTroca.setMinSize(300, 30);
            btnVoltar.setMinSize(300, 30);

            HBox hbox = new HBox();

            in.setTooltip(new Tooltip("Recurso para troca"));
            out.setTooltip(new Tooltip("Recurso pretendido"));

            in.getSelectionModel().select(0);
            out.getSelectionModel().select(1);

            in.setMinSize(145, 30);
            out.setMinSize(145, 30);

            hbox.setSpacing(10);
            hbox.setPadding(new Insets(5, 5, 5, 5));

            hbox.getChildren().addAll(in, out);
            hbox.setAlignment(Pos.CENTER);
            getChildren().addAll(hbox, btnTroca, btnVoltar);

            btnTroca.setOnAction(es -> {
                SoundLoader.playMusic("menuSound.mp3");
                String op1 = (String) in.getValue();
                String op2 = (String) out.getValue();
                int num1, num2;
                if(op1 == "Black")
                    num1 = 1;
                else if(op1 == "Red")
                    num1 = 2;
                else if(op1 == "Green")
                    num1 = 3;
                else
                    num1 = 4;

                if(op2 == "Black")
                    num2 = 1;
                else if(op2 == "Red")
                    num2 = 2;
                else if(op2 == "Green")
                    num2 = 3;
                else
                    num2 = 4;

                modeloObs.realizaUpgrades(2, num1, num2);
                if(modeloObs.getSemRecurso() == true) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Erro");
                    alert.setHeaderText(null);
                    alert.setContentText("Recursos insuficientes ou troca pelo mesmo recurso.");
                    alert.showAndWait();
                    modeloObs.atualizaSemRecurso();
                }
            });

            btnVoltar.setOnAction(es -> {

                hbox.setManaged(false);
                hbox.setVisible(false);
                btnTroca.setManaged(false);
                btnTroca.setVisible(false);
                btnVoltar.setManaged(false);
                btnVoltar.setVisible(false);
                in.setManaged(false);
                in.setVisible(false);
                out.setManaged(false);
                out.setVisible(false);
                SoundLoader.playMusic("menuSound.mp3");


                btnUpgradeCargoHold.setManaged(true);
                btnConverterRecursoNoutro.setManaged(true);
                btnContratarMembro.setManaged(true);
                btnArmorDrone.setManaged(true);
                btnComprarDrone.setManaged(true);
                btnContinuarViagen.setManaged(true);

                btnUpgradeCargoHold.setVisible(true);
                btnConverterRecursoNoutro.setVisible(true);
                btnContratarMembro.setVisible(true);
                btnArmorDrone.setVisible(true);
                btnComprarDrone.setVisible(true);
                btnContinuarViagen.setVisible(true);

                if(modeloObs.getShip() instanceof MilitaryShip) {
                    btnRealizarUpgradeWeapon.setManaged(true);
                    btnRealizarUpgradeWeapon.setVisible(true);
                }
            });

        });

        btnContratarMembro.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.realizaUpgrades(3, 0, 0);
            if(modeloObs.getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes ou membros já a máximo para completar a ação.");
                alert.showAndWait();
                modeloObs.atualizaSemRecurso();
            }
        });

        btnArmorDrone.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.realizaUpgrades(4, 0, 0);
            if(modeloObs.getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes ou armor do drone já a maximo para completar a ação.");
                alert.showAndWait();
                modeloObs.atualizaSemRecurso();
            }
        });

        btnComprarDrone.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.realizaUpgrades(5, 0, 0);
            if(modeloObs.getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes ou já tem um drone para completar a ação.");
                alert.showAndWait();
                modeloObs.atualizaSemRecurso();
            }
        });

        btnRealizarUpgradeWeapon.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.realizaUpgrades(6, 0, 0);
            if(modeloObs.getSemRecurso() == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText(null);
                alert.setContentText("Recursos insuficientes para completar a ação.");
                alert.showAndWait();
                modeloObs.atualizaSemRecurso();
            }
        });

        btnContinuarViagen.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.continuaViagem();
        });

    }


    private void atualizaVista() {
        if(modeloObs.getShip() instanceof MiningShip) {
            btnRealizarUpgradeWeapon.setVisible(false);
            btnRealizarUpgradeWeapon.setManaged(false);
        }
        setAlignment(Pos.CENTER);
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.SPACE_STATION);
        setManaged(interacaoEsperada == InteracaoEsperada.SPACE_STATION);
    }
}
