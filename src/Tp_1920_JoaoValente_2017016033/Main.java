package Tp_1920_JoaoValente_2017016033;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstados;
import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstadosObservavel;
import Tp_1920_JoaoValente_2017016033.ui.gui.Gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //TextUserInterface ui = new TextUserInterface(new JogoMaqEstados());
        //ui.run();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        JogoMaqEstados jogoMaqEstados = new JogoMaqEstados();
        JogoMaqEstadosObservavel jogoMaqEstadosObservavel = new JogoMaqEstadosObservavel(jogoMaqEstados);

        Scene scene = new Scene(new Gui(jogoMaqEstadosObservavel), 1200, 720);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("resources/images/planetbound.jpg")));
        stage.setTitle("Planet Bound");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
}
