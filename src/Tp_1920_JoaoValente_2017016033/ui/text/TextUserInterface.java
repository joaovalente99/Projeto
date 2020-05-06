package Tp_1920_JoaoValente_2017016033.ui.text;

import Tp_1920_JoaoValente_2017016033.logica.JogoMaqEstados;
import Tp_1920_JoaoValente_2017016033.logica.dados.MilitaryShip;
import Tp_1920_JoaoValente_2017016033.logica.estados.*;

import java.util.Scanner;

public class TextUserInterface {

    private JogoMaqEstados jme;
    private Scanner s;
    private boolean exit;

    public TextUserInterface(JogoMaqEstados game) {
        jme = game;
        s = new Scanner(System.in);
        exit = false;
    }

    public void run() {
        while(!exit) {
            if(jme.getMsgLog().size() > 0) {
                System.out.println();
                for(String msg : jme.getMsgLog())
                    System.out.println("---> " + msg);
                jme.clearMsgLog();
            }
            if(jme.getEstado() instanceof WaitingShipSelection)
                UIWaitingShipSelection();
            else if(jme.getEstado() instanceof SpaceTravel)
                UISpaceTravel();
            else if(jme.getEstado() instanceof ConvertResources)
                UIConvertResources();
            else if(jme.getEstado() instanceof Event)
                UIEvent();
            else if(jme.getEstado() instanceof SpaceStation)
                UISpaceStation();
            else if(jme.getEstado() instanceof LandOnThePlanet)
                UILandOnThePlanet();
            else if(jme.getEstado() instanceof LastChance)
                UILastChance();
            else if(jme.getEstado() instanceof GameOver)
                UIGameOver();
        }
    }

    private void UILastChance() {
        int value;
        System.out.println("1- Realizar troca de combustivel e continuar a jogar;");
        System.out.println("2- Desistir e terminar o jogo.");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1) {
            int value2;
            System.out.println("Quantos combustivel pretende trocar?");
            while(!s.hasNextInt())
                s.next();
            value2 = s.nextInt();
            jme.trocaMilagrosa(value2);
        }
        else {
            jme.gameOver();
        }
    }

    private void UIGameOver() {
        int value;
        System.out.println("1- Recomecar jogo;");
        System.out.println("2- Sair");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1) {
            jme.recomecaJogo();
        }
        else
            exit = true;
    }

    private void UILandOnThePlanet() {
        int value;
        char [][] matriz = new char[6][6];
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++)
                matriz[i][j] = '_';
        }
        matriz[jme.getDados().getPlanet().getxL() - 1][jme.getDados().getPlanet().getyL() - 1] = 'S';
        matriz[jme.getDados().getPlanet().getxR() - 1][jme.getDados().getPlanet().getyR() - 1] = 'R';
        matriz[jme.getDados().getShip().getDrone().getX() - 1][jme.getDados().getShip().getDrone().getY() - 1] = 'd';
        if(jme.getDados().getAlien() != null)
            matriz[jme.getDados().getAlien().getX() - 1][jme.getDados().getAlien().getY() - 1] = 'a';
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++)
                System.out.print(matriz[i][j] + "\t");
            System.out.println();
        }
        System.out.println("1- Avancar");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1) {
            jme.trocaTurno();
        }

    }

    private void UISpaceStation() {
        int value;
        System.out.println("1-Realizar upgrades;");
        System.out.println("2- Continuar a viajar.");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1) {
            System.out.println("1- Realizar upgrade a Cargo Hold;");
            System.out.println("2- Converter um recurso noutro;");
            System.out.println("3- Contratar um membro para a equipa;");
            System.out.println("4- Meter a armor do drone a maximo; ");
            System.out.println("5 - Comprar outro drone;");
            if(jme.getDados().getShip() instanceof MilitaryShip)
                System.out.println("6 - Realizar upgrade ao weapon system.");
            while(!s.hasNextInt())
                s.next();
            value = s.nextInt();
            if(value == 1)
                jme.realizaUpgrades(value, 0, 0);
            else if(value == 2) {
                System.out.println("Qual material pretende trocar?");
                System.out.println("1- Black");
                System.out.println("2- Red");
                System.out.println("3- Green");
                System.out.println("4- Blue");
                while(!s.hasNextInt())
                    s.next();
                int value2 = s.nextInt();
                System.out.println("Por qual material esta interessado?");
                System.out.println("1- Black");
                System.out.println("2- Red");
                System.out.println("3- Green");
                System.out.println("4- Blue");
                while(!s.hasNextInt())
                    s.next();
                int value3 = s.nextInt();
                jme.realizaUpgrades(value, value2, value3);
            }
            else if(value == 3)
                jme.realizaUpgrades(value, 0, 0);
            else if(value == 4)
                jme.realizaUpgrades(value, 0, 0);
            else if(value == 5)
                jme.realizaUpgrades(value, 0, 0);
            else if(value == 6 && jme.getDados().getShip() instanceof MilitaryShip)
                jme.realizaUpgrades(value, 0, 0);
        }
        else
            jme.continuaViagem();
    }

    private void UIEvent() {
        int value;
        System.out.println("1- Evento random;");
        System.out.println("2- Evento especifico");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1)
            jme.caiEvento();
        else {
            System.out.println("Qual evento deseja? [1 - 6]");
            while(!s.hasNextInt())
                s.next();
            value = s.nextInt();
            jme.caiEvento(value);
        }
    }

    private void UIConvertResources() {
        int value;
        System.out.println("1- Converter shield;");
        System.out.println("2- Converter ammo;");
        System.out.println("3- Converter fuel;");
        System.out.println("4- Continuar viagem.");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1 || value == 2 || value == 3)
            jme.converteRecursos(value);
        else if(value == 4)
            jme.continuaViagem();
    }

    private void UIWaitingShipSelection() {
        int value;
        System.out.println("Escolha a sua nave:");
        System.out.println("1- Mining Ship;");
        System.out.println("2- Military ship");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1 || value == 2)
            jme.escolhaDaNave(value);
    }

    private void UISpaceTravel() {
        int value;
        System.out.println("1- Avancar no espaco");
        System.out.println("2- Aterrar no planeta");
        System.out.println("3- Converter Recursos");
        System.out.println("4- Verificar os dados do jogo");
        if(jme.getDados().getTipoCirculo() == 1)
            System.out.println("5- Aterrar na space station");
        while(!s.hasNextInt())
            s.next();
        value = s.nextInt();
        if(value == 1)
            jme.avancaNoEspaco();
        else if(value == 2)
            jme.aterraPlaneta();
        else if(value == 3)
            jme.decideconverteRecursos();
        else if(value == 4)
            System.out.println(jme.getDados().toString());
        else if(value == 5 && jme.getDados().getTipoCirculo() == 1)
            jme.aterraSpaceStation();
    }
}
