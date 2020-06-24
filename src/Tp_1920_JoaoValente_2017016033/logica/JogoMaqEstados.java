package Tp_1920_JoaoValente_2017016033.logica;

import Tp_1920_JoaoValente_2017016033.logica.dados.*;
import Tp_1920_JoaoValente_2017016033.logica.estados.IEstado;
import Tp_1920_JoaoValente_2017016033.logica.estados.WaitingShipSelection;

import java.io.Serializable;
import java.util.List;

public class JogoMaqEstados implements Serializable {
    private IEstado estado;
    private JogoDados dados;

    public JogoMaqEstados() {
        dados = new JogoDados();
        estado = new WaitingShipSelection(dados);
    }

    public IEstado getEstado() {
        return estado;
    }

    public void setEstado(IEstado estado) {
        this.estado = estado;
    }


    public void setDados(JogoDados dados) {
        this.dados = dados;
    }

    public void escolhaDaNave(int i) {
        estado = estado.escolhaDaNave(i);
    }

    public List<String> getMsgLog() {
        return dados.getMsgLog();
    }

    public void clearMsgLog() {
        dados.clearMsgLog();
    }

    public void avancaNoEspaco() {
        estado = estado.continuarExplorar();
    }

    public void aterraPlaneta() {
        estado = estado.aterraPlaneta();
    }

    public void aterraSpaceStation() {
        estado = estado.aterraSpaceStation();
    }

    public void decideconverteRecursos() {
        estado = estado.decideConverterRecursos();
    }

    public void converteRecursos(int opcao) {
        estado = estado.converteRecursos(opcao);
    }

    public void continuaViagem() {
        estado = estado.continuaViagem();
    }

    public void caiEvento() {
        estado = estado.saiDoEvento();
    }

    public void caiEvento(int id) {
        estado = estado.saiDoEvento(id);
    }

    public void realizaUpgrades(int num1, int num2, int num3) {
        estado = estado.realizaUpgrades(num1, num2, num3);
    }

    public void recomecaJogo() {
        estado = estado.recomecaJogo();
    }

    public void trocaTurno() {
        estado = estado.trocaTurno();
    }

    public void trocaMilagrosa(int value2) {
        estado = estado.trocaMilagrosa(value2);
    }

    public void gameOver() {
        estado = estado.desiste();
    }

    public InteracaoEsperada getInteracaoEsperada() {
        return estado.getInteracaoEsperada();
    }

    @Override
    public String toString() {
        return dados.toString();
    }

    public int getxL() {
        return dados.getPlanet().getxL();
    }

    public int getyL() {
        return dados.getPlanet().getyL();
    }

    public int getxR() {
        return dados.getPlanet().getxR();
    }

    public int getyR() {
        return dados.getPlanet().getyR();
    }

    public int getXDrone() {
        return dados.getShip().getDrone().getX();
    }

    public int getYDrone() {
        return dados.getShip().getDrone().getY();
    }

    public Alien getAlien() {
        return dados.getAlien();
    }

    public int getXAl() {
        return dados.getAlien().getX();
    }

    public int getYAl() {
        return dados.getAlien().getY();
    }

    public Ship getShip() {
        return dados.getShip();
    }

    public int getTipoCirculo() {
        return dados.getTipoCirculo();
    }

    public String toStringD() {
        return dados.toString();
    }

    public boolean getSemRecurso() {
        return dados.getShip().getSemRecurso();
    }

    public void atualizaSemRecurso() {
        dados.atualizaSemRecurso();
    }

    public String getMsgLogEsp() {
        return dados.getMsgLogEsp();
    }

    public Planet getPlanet() {
        return dados.getPlanet();
    }

    public int getPremio() {
        return dados.getPlanet().getPremio();
    }

    public Drone getDrone() {
        return dados.getShip().getDrone();
    }

    public int getTemRecurso() {
        return dados.getTemRecurso();
    }
}
