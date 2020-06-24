package Tp_1920_JoaoValente_2017016033.logica.estados;

import Tp_1920_JoaoValente_2017016033.logica.dados.JogoDados;

import java.io.Serializable;

public abstract class EstadoAdapter implements IEstado, Serializable {
    protected JogoDados jogo;

    public EstadoAdapter(JogoDados jogo) {
        this.jogo = jogo;
    }

    public JogoDados getJogo() {
        return jogo;
    }

    public void setJogo(JogoDados jogo) {
        this.jogo = jogo;
    }

    @Override
    public IEstado escolhaDaNave(int i) {
        return this;
    }

    @Override
    public IEstado continuarExplorar() {
        return this;
    }

    @Override
    public IEstado saiDoEvento() {
        return this;
    }

    @Override
    public IEstado aterraSpaceStation() {
        return this;
    }

    @Override
    public IEstado realizaUpgrades(int num1, int num2, int num3) {
        return this;
    }

    @Override
    public IEstado decideConverterRecursos() {
        return this;
    }

    @Override
    public IEstado aterraPlaneta() {
        return this;
    }

    @Override
    public IEstado trocaTurno() {
        return this;
    }

    @Override
    public IEstado converteRecursos(int opcao) {
        return this;
    }

    @Override
    public IEstado trocaMilagrosa(int value) {
        return this;
    }

    @Override
    public IEstado desiste() {
        return this;
    }

    @Override
    public IEstado continuaViagem() {
        return this;
    }

    @Override
    public IEstado recomecaJogo() {
        return this;
    }

    @Override
    public IEstado saiDoEvento(int id) {
        return this;
    }
}
