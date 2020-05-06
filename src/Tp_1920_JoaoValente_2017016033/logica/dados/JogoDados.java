package Tp_1920_JoaoValente_2017016033.logica.dados;

import java.util.ArrayList;
import java.util.List;

public class JogoDados implements Constantes {
    private Ship ship;
    private int contEvent; //contador para saber se é evento ou não
    private int tipoCirculo; //0 se for branco, 1 se for vermelho
    private List<String> msgLog; //Vai conter as mensagens de logs
    private int contUpg; //contador para apenas fazer um upgrade ao cargo da nave por space station
    private Alien alien;
    private Planet planet;
    private int turnosAlien; //turnos ate aparecer novo alien
    private int temRecurso; // 0 se o drone nao tiver o recurso, 1 se tiver


    public JogoDados() {
        msgLog = new ArrayList<>();
    }

    public Ship getShip() {
        return ship;
    }

    public Alien getAlien() {
        return alien;
    }

    public Planet getPlanet() {
        return planet;
    }

    public int getTurnosAlien() {
        return turnosAlien;
    }

    public int getTipoCirculo() {
        return tipoCirculo;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setContUpg(int contUpg) {
        this.contUpg = contUpg;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public int getTemRecurso() {
        return temRecurso;
    }

    public void setTemRecurso(int temRecurso) {
        this.temRecurso = temRecurso;
    }


    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public void inicializa(int i) {
        if(i == 1)
            ship = new MiningShip();
        else
            ship = new MilitaryShip();
        contEvent = 0;
    }

    public int exploracao() {
        int ind = (int) (Math.random() * 8) + 1;
        if(ind == 1) {
            ship.caiBuracoNegro();
            addMsgLog("Caiu num buraco negro.");
        }
        else
            ship.gastaCombustivel();
        if(ship.getOfficers() == Officer.DEATH) {
            addMsgLog("Ficou sem membros da equipa.");
            return CREW_FINISH;
        }
        if(ship.getFuel() <= 0) {
            addMsgLog("Ficou sem combustivel.");
            return COMBUSTIVEL_ESGOTADO;
        }

        if(contEvent-- == 0) {
            addMsgLog("Caiu num evento.");
            contEvent = 1;
            return CAI_EVENTO;
        }

        ind = (int) (Math.random() * 10) + 1;
        if(ind < 3) {
            addMsgLog("Calhou num sitio com space station.");
            tipoCirculo = 1;
            contUpg = 1;
            return CIRCULO_VERMELHO;
        }
        else {
            tipoCirculo = 0;
            return CIRCULO_BRANCO;
        }
    }

    public void clearMsgLog() {
        msgLog.clear();
    }

    public void addMsgLog(String msg) {
        msgLog.add(msg);
    }

    public List<String> getMsgLog() {
        return msgLog;
    }

    public void converteRecursos(int opcao) {
        if(ship.getOfficers() != Officer.CARGO_HOLD)
            addMsgLog("Sem Cargo hold Officer para realizar trocas.");
        else if(opcao == 1) {
            if(ship.transformarEnergyShield() == false)
                addMsgLog("Recursos insuficientes para a transformacao");
        }
        else if(opcao == 2) {
            if(ship.transformarAmmo() == false)
                addMsgLog("Recursos insuficientes para a transformacao");
        }
        else if(opcao == 3) {
            if(ship.tranformarFuel() == false)
                addMsgLog("Recursos insuficientes para a transformacao");
        }
    }

    public void caiEvento() {
        int ind = (int) (Math.random() * 6) + 1;
        if(ind == 1) {
            if(ship.getOfficers() == Officer.CAPTAIN || ship.getOfficers() == Officer.NAVIGATION || ship.getOfficers() == Officer.LANDING_PARTY)
                ship.crewDeath();
            ship.crewDeath();
            addMsgLog("[Evento 1] Um membro da equipa morreu.");
        }
        else if(ind == 2) {
            String msg = ship.salvageShip();
            addMsgLog("[Evento 2] Aumentou os seus recursos em + " + msg + ".");
        }
        else if(ind == 3) {
            String msg = ship.cargoLoss();
            addMsgLog("[Evento 3] Perdeu os seguintes recursos: " + msg + ".");
        }
        else if(ind == 4) {
            if(ship.getOfficers() == Officer.CAPTAIN || ship.getOfficers() == Officer.NAVIGATION || ship.getOfficers() == Officer.LANDING_PARTY)
                ship.gastaCombustivel();
            ship.gastaCombustivel();
            addMsgLog("[Evento 4] Perdeu combustivel.");
        }
        else if(ind == 5)
            addMsgLog("[Evento 5] Nao caiu em nenhum evento.");
        else if(ind == 6) {
            ship.crewRescue();
            addMsgLog("[Evento 6] Encontrou um membro da equipa.");
        }

    }

    public void caiEvento(int ind) {
        if(ind == 1) {
            ship.crewDeath();
            addMsgLog("[Evento 1] Um membro da equipa morreu.");
        }
        else if(ind == 2) {
            String msg = ship.salvageShip();
            addMsgLog("[Evento 2] Aumentou os seus recursos em + " + msg + ".");
        }
        else if(ind == 3) {
            String msg = ship.cargoLoss();
            addMsgLog("[Evento 3] Perdeu os seguintes recursos: " + msg + ".");
        }
        else if(ind == 4) {
            ship.gastaCombustivel();
            addMsgLog("[Evento 4] Perdeu combustivel.");
        }
        else if(ind == 5)
            addMsgLog("[Evento 5] Nao caiu em nenhum evento.");
        else if(ind == 6) {
            ship.crewRescue();
            addMsgLog("[Evento 6] Encontrou um membro da equipa.");
        }
        else
            addMsgLog("Evento inexistente.");
    }

    @Override
    public String toString() {
        return "JogoDados{" +
                "ship=" + ship.toString() +
                ", cont=" + contEvent +
                ", tipoCirculo=" + tipoCirculo +
                ", msgLog=" + msgLog +
                '}';
    }

    public void realizaUpgrades(int num1, int num2, int num3) {
        if(num1 == 1) {
            if(contUpg == 1) {
                if(ship.upgradeCargoHold() == false)
                    addMsgLog("Level maximo atingido, recursos insuficientes ou sem Cargo hold Officer.");
                else {
                    contUpg = 0;
                    addMsgLog("Upgrade realizado com sucesso.");
                }
            }
            else
                addMsgLog("Ja fez um upgrade do cargo hold nesta space station, dirija-se a outra para um novo upgrade.");
        }
        else if(num1 == 2) {
            int msg = ship.trocaRecursos(num2, num3);
            if(msg == RECURSOS_INSUFICIENTES)
                addMsgLog("Recursos insuficientes para efetuar a troca.");
            else if(msg == TROCA_PELO_MESMO_RECURSO)
                addMsgLog("Nao pode trocar um tipo de recurso igual.");
            else
                addMsgLog("Troca de recursos efetuada com sucesso.");
        }
        else if(num1 == 3) {
            int msg = ship.compraCrew();
            if(msg == RECURSOS_INSUFICIENTES)
                addMsgLog("Recursos insuficientes para a compra.");
            else if(msg == TRIPULACAO_MAXIMA)
                addMsgLog("Ja tem o numero maximo de tripulacao.");
            else
                addMsgLog("Contratacao de membro efetuada com sucesso.");
        }
        else if(num1 == 4) {
            int msg = ship.droneArmor();
            if(msg == RECURSOS_INSUFICIENTES)
                addMsgLog("Recursos insuficientes para a compra.");
            else if(msg == ARMOR_MAXIMO)
                addMsgLog("Ja tem o armor a maximo.");
            else
                addMsgLog("Aumento de armor realizado com sucesso.");
        }
        else if(num1 == 5) {
            int msg = ship.comprarDrone();
            if(msg == RECURSOS_INSUFICIENTES)
                addMsgLog("Recursos insuficientes para a compra.");
            else if(msg == DRONE_JA_TEM)
                addMsgLog("Ja tem um drone.");
            else
                addMsgLog("Drone comprado com sucesso.");
        }
        else if(num1 == 6 && ship instanceof MilitaryShip) {
            int msg = ship.upgradeWeapon();
            if(msg == RECURSOS_INSUFICIENTES)
                addMsgLog("Recursos insuficientes para a compra.");
            else if(msg == WEAPON_LEVEL_MAXIMO)
                addMsgLog("Ja tem a weapon a level maximo.");
            else
                addMsgLog("Upgrade feito com sucesso.");
        }

    }

    public int trocaTurno() {
        if(alien == null) {
            if(turnosAlien-- == 0) {
                alienRespawn();
                addMsgLog("Um novo alien nasceu.");
            }
        }
        if(temRecurso == 0) {
            if (ship.getDrone().getX() != planet.getxR()) {
                if(ship.getDrone().getX() < planet.getxR())
                    ship.getDrone().avancaX();
                else
                    ship.getDrone().recuaX();
            }
            else {
                if(ship.getDrone().getY() < planet.getyR())
                    ship.getDrone().avancaY();
                else
                    ship.getDrone().recuaY();
            }
            if(ship.getDrone().getX() == planet.getxR() && ship.getDrone().getY() == planet.getyR()) {
                addMsgLog("Apanhou o recurso.");
                temRecurso = 1;
            }
        }
        else {
            if (ship.getDrone().getX() != planet.getxL()) {
                if(ship.getDrone().getX() < planet.getxL())
                    ship.getDrone().avancaX();
                else
                    ship.getDrone().recuaX();
            }
            else {
                if(ship.getDrone().getY() < planet.getyL())
                    ship.getDrone().avancaY();
                else
                    ship.getDrone().recuaY();
            }
            if(ship.getDrone().getX() == planet.getxL() && ship.getDrone().getY() == planet.getyL()) {
                addMsgLog("Voltou com sucesso a nave.");
                planet.apanhaPremio();
                return SUCESSO_SAQUE;
            }
        }
        if(alien != null) {
            if (alien.getX() != ship.getDrone().getX()) {
                if (alien.getX() < ship.getDrone().getX())
                    alien.avancaX();
                else
                    alien.recuaX();
            } else {
                if (alien.getY() < ship.getDrone().getY())
                    alien.avancaY();
                else
                    alien.recuaY();
            }

            int dis = (int) Math.sqrt(((alien.getX() - ship.getDrone().getX()) * (alien.getX() - ship.getDrone().getX())) +
                    ((alien.getY() - ship.getDrone().getY()) * (alien.getY() - ship.getDrone().getY())));
            if (dis <= 1) {
                addMsgLog("Entrou na batalha com o alien.");
                int msg = fight();
                if (msg == VITORIA_ALIEN) {
                    addMsgLog("Drone destruido.");
                    return VITORIA_ALIEN;
                } else if (msg == VITORIA_DRONE) {
                    addMsgLog("Matou o alien.");
                    addMsgLog("Ficou com " + ship.getDrone().getArmor() + " armor.");
                    return VITORIA_DRONE;
                }
            }
        }
        return 0;
    }

    private int fight() {
        boolean sair = false;

        while(!sair) {
            int num = (int) (Math.random() * 6) + 1;
            if(alien.defense(num) == MORTE) {
                alien = null;
                turnosAlien = (int) (Math.random() * 6) + 1;
                addMsgLog("Alien vai nascer em " + turnosAlien + " turnos.");
                return VITORIA_DRONE;
            }
            num = (int) (Math.random() * 6) + 1;
            if(alien.atack(num) == ATAQUE_SUCESSO) {
                ship.getDrone().recebeDano();
                if(ship.getDrone().getArmor() == 0) {
                    ship.setDrone(null);
                    return VITORIA_ALIEN;
                }
            }
        }
        return 0;
    }

    private void alienRespawn() {
        int num = (int) (Math.random() * 4) + 1;
        int x = (int) (Math.random() * 6) + 1;
        int y = (int) (Math.random() * 6) + 1;
        if(num == 1)
            alien = new BlackAlien(x, y);
        else if(num == 2)
            alien = new RedAlien(x, y);
        else if(num == 3)
            alien = new GreenAlien(x, y);
        else if(num == 4)
            alien = new BlueAlien(x, y);
    }

    public int aterraPlaneta() {
        if(ship.getDrone() == null) {
            addMsgLog("Sem drone para explorar.");
            return 0;
        }
        if(ship.getOfficers() == Officer.CAPTAIN || ship.getOfficers() == Officer.NAVIGATION) {
            addMsgLog("Sem landing party officer para explorar.");
            return 0;
        }
        if(planet == null)
            planet = new Planet();
        int msg = planet.renova();
        if(msg == PLANETA_VAZIO) {
            addMsgLog("Planeta sem mais recursos para explorar.");
            return 0;
        }
        else if(msg == 1)
            addMsgLog("Black Resource.");
        else if(msg == 2)
            addMsgLog("Red Resource.");
        else if(msg == 3)
            addMsgLog("Blue Resource.");
        else if(msg == 4)
            addMsgLog("Green Resource.");
        else
            addMsgLog("Artefact resource.");
        alienRespawn();
        ship.lancaDrone(planet.getxL(), planet.getyL());
        temRecurso = 0;
        return 1;
    }

    public int recompensaDada() {
        int num = (int) (Math.random() * 6) + 1;
        if(planet.getPremio() == 1) {
            ship.setBlack(ship.getBlack() + num);
            addMsgLog("Encontrou " + num + " black.");
        }
        else if(planet.getPremio() == 2) {
            ship.setRed(ship.getRed() + num);
            addMsgLog("Encontrou " + num + " red.");
        }
        else if(planet.getPremio() == 3) {
            ship.setBlue(ship.getBlue() + num);
            addMsgLog("Encontrou " + num + " blue.");
        }
        else if(planet.getPremio() == 4) {
            ship.setGreen(ship.getGreen() + num);
            addMsgLog("Encontrou " + num + " green.");
        }
        else {
            ship.setArtefact(ship.getArtefact() + 1);
            if(ship.getArtefact() == 5) {
                addMsgLog("Encontrou todos os artefactos!");
                return 1;
            }
            addMsgLog("Encontrou um artefacto.");
        }
        return 0;
    }

    public boolean lastChance() {
        if(ship.getBlack() >= 1 && ship.getRed() >= 1 && ship.getGreen() >= 1)
            return true;
        return false;
    }

    public void trocaMilagrosa(int value) {
        for(int i = 0; i < value; i++) {
            if(ship.tranformarFuel() == false) {
                addMsgLog("Sem recursos para tanta troca de combustivel (a troca foi realizada dentro do possivel).");
                break;
            }
        }
    }

}
