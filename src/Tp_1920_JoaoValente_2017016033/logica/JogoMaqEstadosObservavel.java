package Tp_1920_JoaoValente_2017016033.logica;

import Tp_1920_JoaoValente_2017016033.logica.dados.*;
import Tp_1920_JoaoValente_2017016033.logica.estados.IEstado;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JogoMaqEstadosObservavel {

    private PropertyChangeSupport propertyChangeSupport;
    private JogoMaqEstados jogoMaqEstados;

    public JogoMaqEstadosObservavel(JogoMaqEstados jogoMaqEstados) {
        this.jogoMaqEstados = jogoMaqEstados;
        propertyChangeSupport = new PropertyChangeSupport(jogoMaqEstados);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void escolhaDaNave(int i) {
        this.jogoMaqEstados.escolhaDaNave(i);
        propertyChangeSupport.firePropertyChange(null, null, null);
    }

    public void avancaNoEspaco() {
        this.jogoMaqEstados.avancaNoEspaco();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void aterraPlaneta() {
        this.jogoMaqEstados.aterraPlaneta();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void aterraSpaceStation() {
        this.jogoMaqEstados.aterraSpaceStation();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void decideconverteRecursos() {
        this.jogoMaqEstados.decideconverteRecursos();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void converteRecursos(int opcao) {
        this.jogoMaqEstados.converteRecursos(opcao);
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void continuaViagem() {
        this.jogoMaqEstados.continuaViagem();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void caiEvento() {
        this.jogoMaqEstados.caiEvento();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void caiEvento(int id) {
        this.jogoMaqEstados.caiEvento(id);
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void realizaUpgrades(int num1, int num2, int num3) {
        this.jogoMaqEstados.realizaUpgrades(num1, num2, num3);
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void recomecaJogo() {
        this.jogoMaqEstados.recomecaJogo();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void trocaTurno() {
        this.jogoMaqEstados.trocaTurno();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void trocaMilagrosa(int value2) {
        this.jogoMaqEstados.trocaMilagrosa(value2);
        propertyChangeSupport.firePropertyChange(null, false, true);
    }

    public void gameOver() {
        this.jogoMaqEstados.gameOver();
        propertyChangeSupport.firePropertyChange(null, false, true);
    }


    public void setDados(JogoDados dados) {
        jogoMaqEstados.setDados(dados);
    }
    public IEstado getEstado() {
        return jogoMaqEstados.getEstado();
    }

    public void setEstado(IEstado ies) {
        jogoMaqEstados.setEstado(ies);
    }

    public JogoMaqEstados getJogoMaqEstados() {
        return jogoMaqEstados;
    }

    public void setJogoMaqEstados(JogoMaqEstados jmq) {
        jogoMaqEstados = jmq;
    }

    @Override
    public String toString() {
        return jogoMaqEstados.toString();
    }

    public InteracaoEsperada getInteracaoEsperada() {
        return jogoMaqEstados.getInteracaoEsperada();
    }


    public boolean getSemRecurso() {
        return jogoMaqEstados.getSemRecurso();
    }

    public void atualizaSemRecurso() {
        jogoMaqEstados.atualizaSemRecurso();
    }

    public Ship getShip() {
        return jogoMaqEstados.getShip();
    }

    public String getMsgLogEsp() {
        return jogoMaqEstados.getMsgLogEsp();
    }

    public Alien getAlien() {
        return jogoMaqEstados.getAlien();
    }

    public Planet getPlanet() {
        return jogoMaqEstados.getPlanet();
    }

    public int getPremio() {
        return jogoMaqEstados.getPremio();
    }

    public Drone getDrone() {
        return jogoMaqEstados.getDrone();
    }

    public int getxL() {
        return jogoMaqEstados.getxL();
    }

    public int getyL() {
        return jogoMaqEstados.getyL();
    }

    public int getXAlien() {
        return jogoMaqEstados.getXAl();
    }

    public int getYAlien() {
        return jogoMaqEstados.getYAl();
    }

    public int getTemRecurso() {
        return jogoMaqEstados.getTemRecurso();
    }

    public int getxR() {
        return jogoMaqEstados.getxR();
    }

    public int getyR() {
        return jogoMaqEstados.getyR();
    }

    public int getXDrone() {
        return jogoMaqEstados.getXDrone();
    }

    public int getYDrone() {
        return jogoMaqEstados.getYDrone();
    }

    public int getTipoCirculo() {
        return jogoMaqEstados.getTipoCirculo();
    }
}
