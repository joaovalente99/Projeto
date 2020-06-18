package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class UISpaceStation extends HBox {

    private Button btnAterrarSpaceStation;
    private JogoMaqEstadosObservavel modeloObs;

    public UISpaceStation(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        Button btnAvancaEspaco = new Button("Avancar no espaco");
        Button btnAterraPlaneta = new Button("Aterrar no planeta");
        Button btnConverterRecursos = new Button("Converter recursos");
        btnAterrarSpaceStation = new Button("Aterrar na Space Station");
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setPadding(new Insets(5, 5, 5, 5));
        //btnAvancaEspaco.setMinSize(500, 500);
        btnAvancaEspaco.setMinSize(200, 80);
        btnAterraPlaneta.setMinSize(200, 80);
        btnConverterRecursos.setMinSize(200, 80);
        btnAterrarSpaceStation.setMinSize(200, 80);
        getChildren().addAll(btnAvancaEspaco, btnAterraPlaneta, btnConverterRecursos, btnAterrarSpaceStation);



        btnAvancaEspaco.setOnAction(actionEvent -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.avancaNoEspaco();
        });
        btnAterraPlaneta.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.aterraPlaneta();
        });
        btnConverterRecursos.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.decideconverteRecursos();
        });

        btnAterrarSpaceStation.setOnAction(e -> {
            SoundLoader.playMusic("menuSound.mp3");
            modeloObs.aterraSpaceStation();
        });

    }


    private void atualizaVista() {
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.SPACE_STATION);
    }
}
