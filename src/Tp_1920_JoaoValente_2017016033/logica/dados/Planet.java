package Tp_1920_JoaoValente_2017016033.logica.dados;

import java.io.Serializable;

public class Planet implements Constantes, Serializable {
    private int tipoRecurso; //Tipo de recurso que calhou neste planeta; 1-black; 2- red; 3- blue; 4- green
    private int black;
    private int red;
    private int blue;
    private int green;
    private int artefacto; //se tem artefacto ou nao
    private int xL, yL; //coordenadas onde cai
    private int xR, yR; //coordenadas onde esta o recurso
    private int numRecursos; //numero de recursos do planeta
    private int premio; //recurso que está disponivel para o drone; 1- black; 2- red; 3- blue; 4- green; 5- artefacto

    public Planet() {
        black = red = blue = green = artefacto = 0;
        inicializa();
    }

    public int getPremio() {
        return premio;
    }

    public int getNumRecursos() {
        return numRecursos;
    }

    private void inicializa() {
        tipoRecurso = (int) (Math.random() * 4) + 1; //calcula que recursos é que tem neste planeta
        if(tipoRecurso == 1) { //Se calhar preto
            black = 1;
            blue = 1;
        }
        else if(tipoRecurso == 2) { //se calhar vermelho
            red = 1;
            blue = 1;
        }
        else if(tipoRecurso == 3) { //se calhar azul
            black = 1;
            green = 1;
            blue = 1;
            artefacto = 1;
        }
        else if(tipoRecurso == 4) { //se calhar verde
            red = 1;
            green = 1;
        }
        numRecursos = black + red + green + blue + artefacto;
    }

    public int getTipoRecurso() {
        return tipoRecurso;
    }

    public int getBlack() {
        return black;
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getArtefacto() {
        return artefacto;
    }

    public int getxL() {
        return xL;
    }

    public int getyL() {
        return yL;
    }

    public int getxR() {
        return xR;
    }

    public int getyR() {
        return yR;
    }

    public int renova() {
        int num;
        if(numRecursos == 0)
            return PLANETA_VAZIO;
        if(tipoRecurso == 1) { //Se o planeta tiver recurso preto
            if(black > 0 && blue > 0) {
                num = (int) (Math.random() * 2) + 1;
                if (num == 1)
                    premio = 1; //black
                else
                    premio = 3; //blue
            }
            else if(black > 0)
                premio = 1;
            else
                premio = 3;
        }
        else if(tipoRecurso == 2) {  //se o planeta tiver recurso vermelho
            if(red > 0 && blue > 0) {
                num = (int) (Math.random() * 2) + 1;
                if (num == 1)
                    premio = 2; //red
                else
                    premio = 3; //blue
            }
            else if(red > 0)
                premio = 2;
            else
                premio = 3;
        }
        else if(tipoRecurso == 3) { //se o planeta tiver recurso azul
            int sair = 1;
             do {
                num = (int) (Math.random() * 4) + 1;
                if (num == 1)
                    premio = 1; //black
                else if (num == 2)
                    premio = 4; //green
                else if (num == 3)
                    premio = 3; //blue
                else
                    premio = 5; //artefacto
                if(premio == 1 && black > 0)
                    sair = 0;
                else if(premio == 3 && blue > 0)
                    sair = 0;
                else if(premio == 4 && green > 0)
                    sair = 0;
                else if(premio == 5 && artefacto > 0)
                    sair = 0;
            } while(sair == 1);
        }
        else {   //se tiver recurso verde
            if(red > 0 && green > 0) {
                num = (int) (Math.random() * 2) + 1;
                if (num == 1)
                    premio = 2; //red
                else if (num == 2)
                    premio = 4; //green
            }
            else if(red > 0)
                premio = 2;
            else
                premio = 4;
        }

        xL = (int) (Math.random() * 6) + 1;
        yL = (int) (Math.random() * 6) + 1;
        xR = (int) (Math.random() * 6) + 1;
        if(xR == xL) {
            do {
                yR = (int) (Math.random() * 6) + 1;
            } while(yL == yR);
        }
        else
            yR = (int) (Math.random() * 6) + 1;
        return premio;
    }

    public void apanhaPremio() {
        if(premio == 1)
            black--;
        else if(premio == 2)
            red--;
        else if(premio == 3)
            blue--;
        else if(premio == 4)
            green--;
        else
            artefacto--;
        numRecursos--;
    }

    @Override
    public String toString() {
        String str = "";
        if(tipoRecurso == 1)
            str += "Tipo de Planeta: Black\n";
        else if(tipoRecurso == 2)
            str += "Tipo de Planeta: Red\n";
        else if(tipoRecurso == 3)
            str += "Tipo de Planeta: Blue\n";
        else
            str += "Tipo de Planeta: Green\n";
        str += "Recursos disponíveis:\n";
        str += "Black: " + black + "\n";
        str += "Red: " + red + "\n";
        str += "Green: " + green + "\n";
        str += "Blue: " + blue + "\n";
        str += "Artefacto: " + artefacto + "\n";
        return str;
    }
}
