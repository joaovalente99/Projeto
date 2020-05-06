package Tp_1920_JoaoValente_2017016033;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstados;
import Tp_1920_JoaoValente_2017016033.ui.text.TextUserInterface;

public class Main {

    public static void main(String[] args) {
        TextUserInterface ui = new TextUserInterface(new JogoMaqEstados());
        ui.run();
    }
}
