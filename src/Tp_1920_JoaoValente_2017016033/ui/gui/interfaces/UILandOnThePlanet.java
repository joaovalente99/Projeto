package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.resources.sounds.SoundLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class UILandOnThePlanet extends HBox {

    private JogoMaqEstadosObservavel modeloObs;
    private GridPane gp;
    private ImageView img1;

    public UILandOnThePlanet(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {
        gp = new GridPane();
        BackgroundSize backgroundSize = new BackgroundSize(1200, 720, false, false, false, false);
        BackgroundImage myBI = new BackgroundImage(ImageLoader.getImage("fundoEsq.jpg"), BackgroundRepeat.NO_REPEAT,
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
        img1 = new ImageView(ImageLoader.getImage("militaryShip.png"));

        if(modeloObs.getDados().getShip() != null)
            gp.add(img1, modeloObs.getDados().getShip().getDrone().getX() - 1, modeloObs.getDados().getShip().getDrone().getY() - 1);

        setAlignment(Pos.CENTER);

        getChildren().addAll(gp);
    }


    private void atualizaVista() {

        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.LAND_ON_THE_PLANET);
        setManaged(interacaoEsperada == InteracaoEsperada.LAND_ON_THE_PLANET);
    }
}
