package Tp_1920_JoaoValente_2017016033.ui.gui;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstados;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.resources.images.ImageLoader;
import Tp_1920_JoaoValente_2017016033.ui.gui.interfaces.*;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.util.Stack;


public class Gui extends BorderPane {

    private JogoMaqEstadosObservavel jme;

    public Gui(JogoMaqEstadosObservavel jme) {
        this.jme = jme;
        organizaComponentes();
    }

    private void organizaComponentes() {
        BackgroundSize backgroundSize = new BackgroundSize(1200, 720, false, false, false, false);
        BackgroundImage myBI = new BackgroundImage(ImageLoader.getImage("fundoCent.png"), BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        setBackground(new Background(myBI));


        //Cria componentes
        StackPane areaUtil = new StackPane();
        areaUtil.setPadding(new Insets(10));
        //Criação das varias classes que dao origem às interfaces de utilizador de cada estado
        UIWaitingShipSelection uiwaitingship = new UIWaitingShipSelection(jme);
        UIConvertResources uiconvertresources = new UIConvertResources(jme);
        UIEvent uievent = new UIEvent(jme);
        UIGameOver uigameover = new UIGameOver(jme);
        UILandOnThePlanet uilandontheplanet = new UILandOnThePlanet(jme);
        UILastChance uilastchance = new UILastChance(jme);
        UISpaceStation uispacestation = new UISpaceStation(jme);
        UISpaceTravel uispacetravel = new UISpaceTravel(jme);

        VistaLogs vistaLogs = new VistaLogs(jme);
        VistaDados vistaDados = new VistaDados(jme);

        StackPane center = new StackPane(uiwaitingship, uiconvertresources, uievent, uigameover,
                uilandontheplanet, uilastchance, uispacestation, uispacetravel);
        StackPane left = new StackPane(vistaDados);
        StackPane bottom = new StackPane(vistaLogs);

        uiwaitingship.setVisible(true);
        uiconvertresources.setVisible(false);
        uievent.setVisible(false);
        uigameover.setVisible(false);
        uilandontheplanet.setVisible(false);
        uilastchance.setVisible(false);
        uispacestation.setVisible(false);
        uispacetravel.setVisible(false);

        uiwaitingship.setManaged(true);
        uiconvertresources.setManaged(false);
        uievent.setManaged(false);
        uigameover.setManaged(false);
        uilandontheplanet.setManaged(false);
        uilastchance.setManaged(false);
        uispacestation.setManaged(false);
        uispacetravel.setManaged(false);

        center.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null,
                new BorderWidths(2))));
        left.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null,
                new BorderWidths(2))));
        left.setPadding(new Insets(10));

        vistaDados.setMaxWidth(170);
        vistaDados.setMinWidth(170);
        vistaLogs.setMinHeight(100);
        vistaLogs.setMaxHeight(100);
        this.setLeft(vistaDados);
        this.setCenter(center);
        this.setBottom(bottom);

        //Menu
        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem fileSave = new MenuItem("Save");
        MenuItem fileLoad = new MenuItem("Load");
        MenuItem fileExit = new MenuItem("Exit");
        fileMenu.getItems().addAll(fileSave, fileLoad, fileExit);

        Menu aboutMenu = new Menu("About");
        MenuItem aboutInfo = new MenuItem("Info");
        aboutMenu.getItems().addAll(aboutInfo);

        menuBar.getMenus().addAll(fileMenu, aboutMenu);
        setTop(menuBar);

        //Eventos para os menus (deixar para depois)


    }

}
