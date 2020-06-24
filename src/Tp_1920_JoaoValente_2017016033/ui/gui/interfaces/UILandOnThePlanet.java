package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.logica.dados.*;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

public class UILandOnThePlanet extends HBox {

    private JogoMaqEstadosObservavel modeloObs;
    private GridPane gp;
    private ImageView imgNave;
    private ImageView imgDrone;
    private ImageView imgAlien;
    private ImageView imgRecurso;
    private ImageView imgInicio;

    public UILandOnThePlanet(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        Button bt = new Button();
        gp = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(1200, 720, false, false, false, false);
        BackgroundImage myBI = new BackgroundImage(ImageLoader.getImage("tabuleiro.jpg"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        gp.setBackground(new Background(myBI));
        gp.setMaxSize(600, 600);
        gp.setMinSize(600, 600);
        gp.setPadding(new Insets(5, 5, 5, 5));
        for(int i = 0; i < 6; i++) {
            RowConstraints row = new RowConstraints(100);
            gp.getRowConstraints().add(row);
            ColumnConstraints column = new ColumnConstraints(100);
            gp.getColumnConstraints().add(column);
        }

        bt.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER)
                modeloObs.trocaTurno();
        });
        bt.setManaged(false);
        setAlignment(Pos.CENTER);

        getChildren().addAll(gp, bt);
    }


    private void atualizaVista() {
        if(modeloObs.getShip() instanceof MilitaryShip)
            imgNave = new ImageView(ImageLoader.getImage("militaryShip.png"));
        else
            imgNave = new ImageView(ImageLoader.getImage("miningShip.png"));

        if(modeloObs.getAlien() instanceof BlackAlien)
            imgAlien = new ImageView(ImageLoader.getImage("blackAlienWithEyes.png"));
        else if(modeloObs.getAlien() instanceof RedAlien)
            imgAlien = new ImageView(ImageLoader.getImage("redAlienWithEyes.png"));
        else if(modeloObs.getAlien() instanceof BlueAlien)
            imgAlien = new ImageView(ImageLoader.getImage("blueAlienWithEyes.png"));
        else
            imgAlien = new ImageView(ImageLoader.getImage("greenAlienWithEyes.png"));

        if(modeloObs.getPlanet() != null) {
            if (modeloObs.getPremio() == 1)
                imgRecurso = new ImageView(ImageLoader.getImage("blackResource.png"));
            else if (modeloObs.getPremio() == 2)
                imgRecurso = new ImageView(ImageLoader.getImage("redResource.png"));
            else if (modeloObs.getPremio() == 3)
                imgRecurso = new ImageView(ImageLoader.getImage("blueResource.png"));
            else if (modeloObs.getPremio() == 4)
                imgRecurso = new ImageView(ImageLoader.getImage("greenResource.png"));
            else
                imgRecurso = new ImageView(ImageLoader.getImage("artefacto.png"));

            if(modeloObs.getDrone() != null)
                imgDrone = new ImageView(ImageLoader.getImage("drone.png"));
        }




        gp.getChildren().clear();
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.LAND_ON_THE_PLANET);
        setManaged(interacaoEsperada == InteracaoEsperada.LAND_ON_THE_PLANET);
        if(modeloObs.getPlanet() != null)
            gp.add(imgNave, modeloObs.getxL() - 1,
                    modeloObs.getyL() - 1);

        if(modeloObs.getAlien() != null)
            gp.add(imgAlien, modeloObs.getXAlien() - 1,
                    modeloObs.getYAlien() - 1);

        if(modeloObs.getPlanet() != null && modeloObs.getTemRecurso() == 0)
            gp.add(imgRecurso, modeloObs.getxR() - 1,
                    modeloObs.getyR() - 1);

        if(modeloObs.getPlanet() != null) {
            if(modeloObs.getDrone() != null)
                gp.add(imgDrone, modeloObs.getXDrone() - 1,
                        modeloObs.getYDrone() - 1);
        }

    }
}
