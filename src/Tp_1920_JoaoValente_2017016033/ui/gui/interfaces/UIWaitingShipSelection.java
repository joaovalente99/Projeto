package Tp_1920_JoaoValente_2017016033.ui.gui.interfaces;

import Tp_1920_JoaoValente_2017016033.logica.InteracaoEsperada;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;


public class UIWaitingShipSelection extends VBox {

    private JogoMaqEstadosObservavel modeloObs;

    public UIWaitingShipSelection(JogoMaqEstadosObservavel modelo) {
        this.modeloObs = modelo;
        this.modeloObs.addPropertyChangeListener(evt -> atualizaVista());
        organizaComponentes();
        atualizaVista();

    }



    private void organizaComponentes() {

        HBox hbox = new HBox();
        Button btnMilitaryShip = new Button("Military Ship");
        Button btnMiningShip = new Button("Mining Ship");
        btnMilitaryShip.setMinSize(200, 100);
        btnMiningShip.setMinSize(200, 100);
        ImageView fund = new ImageView(ImageLoader.getImage("planetbound.jpg"));
        setAlignment(Pos.TOP_CENTER);
        setSpacing(50);
        setPadding(new Insets(50, 5, 5, 5));
        hbox.getChildren().addAll(btnMilitaryShip, btnMiningShip);
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(10);
        getChildren().addAll(fund, hbox);
        btnMiningShip.setOnAction(
                actionEvent -> modeloObs.escolhaDaNave(1)
        );
        btnMilitaryShip.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                modeloObs.escolhaDaNave(2);
            }
        });


    }


    private void atualizaVista() {
        InteracaoEsperada interacaoEsperada = modeloObs.getInteracaoEsperada();
        setVisible(interacaoEsperada == InteracaoEsperada.WAITING_SHIP_SELECTION);
    }
}
