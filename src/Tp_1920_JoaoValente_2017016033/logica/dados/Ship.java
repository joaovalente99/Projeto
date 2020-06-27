package Tp_1920_JoaoValente_2017016033.logica.dados;

import java.io.Serializable;

public abstract class Ship implements Constantes, Serializable {
    private int weapon; //quantidade de armas que tem
    private int fuel;   //quantidade de combustivel que tem
    private int shield; //quantidade de armadura que tem
    private Drone drone;
    private int cargoHoldLevel; //nivel da carga atual
    private int black, blue, red, green; //Numero de recursos
    private boolean semRecursos; //Caso não tenha recursos para uma troca -> true;
    private int artefact; //Numero de artefactos
    private Officer officers; //tripulantes da nave

    //CONSTRUTOR
    public Ship(int weapon, int fuel, int shield) {
        officers = Officer.CARGO_HOLD;
        this.weapon = weapon;
        this.fuel = fuel;
        black = blue = red = green = 0;
        cargoHoldLevel = 0;
        drone = new Drone();
        this.shield = shield;
    }

    public Officer getOfficers() {
        return officers;
    }

    //GETTERS
    public int getFuel() {
        return fuel;
    }

    public boolean getSemRecurso() {
        return semRecursos;
    }

    public int getShield() {
        return shield;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getBlack() {
        return black;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public int getCargoHoldLevel() {
        return cargoHoldLevel;
    }

    public Drone getDrone() {
        return drone;
    }

    public int getArtefact() {
        return artefact;
    }

    //SETTERS

    public void setSemRecursos(boolean rec) {
        this.semRecursos = rec;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public void setCargoHoldLevel(int cargoHoldLevel) {
        this.cargoHoldLevel = cargoHoldLevel;
    }

    public void setBlack(int black) {
        if (cargoHoldLevel == 0) {
            if (black > 6)
                this.black = 6;
            else
                this.black = black;
        }
        else if(cargoHoldLevel == 1) {
            if(black > 12)
                this.black = 12;
            else
                this.black = black;
        }
        else if(cargoHoldLevel == 2) {
            if (black > 18)
                this.black = 18;
            else
                this.black = black;
        }
        else if(cargoHoldLevel == 3) {
            if(black > 24)
                this.black = 24;
            else
                this.black = black;
        }
    }

    public void setBlue(int blue) {
        if (cargoHoldLevel == 0) {
            if (blue > 6)
                this.blue = 6;
            else
                this.blue = blue;
        }
        else if(cargoHoldLevel == 1) {
            if(blue > 12)
                this.blue = 12;
            else
                this.blue = blue;
        }
        else if(cargoHoldLevel == 2) {
            if (blue > 18)
                this.blue = 18;
            else
                this.blue = blue;
        }
        else if(cargoHoldLevel == 3) {
            if(blue > 24)
                this.blue = 24;
            else
                this.blue = blue;
        }
    }

    public void setGreen(int green) {
        if (cargoHoldLevel == 0) {
            if (green > 6)
                this.green = 6;
            else
                this.green = green;
        }
        else if(cargoHoldLevel == 1) {
            if(green > 12)
                this.green = 12;
            else
                this.green = green;
        }
        else if(cargoHoldLevel == 2) {
            if (green > 18)
                this.green = 18;
            else
                this.green = green;
        }
        else if(cargoHoldLevel == 3) {
            if(green > 24)
                this.green = 24;
            else
                this.green = green;
        }
    }

    public void setRed(int red) {
        if (cargoHoldLevel == 0) {
            if (red > 6)
                this.red = 6;
            else
                this.red = red;
        }
        else if(cargoHoldLevel == 1) {
            if(red > 12)
                this.red = 12;
            else
                this.red = red;
        }
        else if(cargoHoldLevel == 2) {
            if (red > 18)
                this.red = 18;
            else
                this.red = red;
        }
        else if(cargoHoldLevel == 3) {
            if(red > 24)
                this.red = 24;
            else
                this.red = red;
        }
    }

    public void setArtefact(int artefact) {
        this.artefact = artefact;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    //FUNCOES DE FUNCIONAMENTO

    public void caiBuracoNegro() {
        int aux = shield;

        if(officers == Officer.CAPTAIN || officers == Officer.NAVIGATION || officers == Officer.LANDING_PARTY) { //caso nao tenha shield officer
            fuel--;
            aux -= 2;
        }
        fuel -= 3;
        aux -= 2;
        if(fuel < 0)
            fuel = 0;
        if(aux < 0) {
            shield = 0;
            crewDeath();
        }
        else
            shield = aux;
    }

    public void gastaCombustivel() {
        fuel--;
        if(fuel < 0)
            fuel = 0;
    }

    public boolean transformarEnergyShield() {
        if(black >= 1 && blue >= 1 && green >= 1) {
            black--;
            blue--;
            green--;
            shield++;
            return true;
        }
        semRecursos = true;
        return false;
    }

    public boolean transformarAmmo() {
        if(black >= 1 && blue >= 1) {
            black--;
            blue--;
            weapon++;
            return true;
        }
        semRecursos = true;
        return false;
    }

    public boolean tranformarFuel() {
        if(black >= 1 && red >= 1 && green >= 1) {
            black--;
            red--;
            green--;
            fuel++;
            return true;
        }
        semRecursos = true;
        return false;
    }

    public void crewDeath() {
        switch(officers) {
            case CARGO_HOLD:
                officers = Officer.WEAPONS;
                break;
            case WEAPONS:
                officers = Officer.SHIELDS;
                break;
            case SHIELDS:
                officers = Officer.LANDING_PARTY;
                break;
            case LANDING_PARTY:
                officers = Officer.NAVIGATION;
                break;
            case NAVIGATION:
                officers = Officer.CAPTAIN;
                break;
            case CAPTAIN:
                officers = Officer.DEATH;
                break;
        }
    }

    public String salvageShip() {
        int ind = (int) (Math.random() * 4) + 1;
        int quant = (int) (Math.random() * 6) + 1;
        if(ind == 1) {
            setBlack(quant + black);
            return quant + " black";
        }
        else if(ind == 2) {
            setGreen(quant + green);
            return quant + " green";
        }
        else if(ind == 3) {
            setRed(quant + red);
            return quant + " red";
        }
        else {
            setBlue(quant + blue);
            return quant + " blue";
        }
    }

    public String cargoLoss() {
        int ind = (int) (Math.random() * 4) + 1; //Calcula qual cargo ira perder
        int quant = (int) (Math.random() * 3) + 1; //Calcula a qunatidade de cargo que ira perder
        if(officers == Officer.CAPTAIN || officers == Officer.NAVIGATION || officers == Officer.LANDING_PARTY)
            quant *= 2;
        if(ind == 1) {
            black -= quant;
            if(black < 0)
                black = 0;
            return quant + " black";
        }
        else if(ind == 2) {
            green -= quant;
            if(green < 0)
                green = 0;
            return quant + " green";
        }
        else if(ind == 3) {
            red -= quant;
            if(red < 0)
                red = 0;
            return quant + " red";
        }
        else {
            blue -= quant;
            if(blue < 0)
                blue = 0;
            return quant + " blue";
        }
    }

    public void crewRescue() {
        switch(officers) {
            case WEAPONS:
                officers = Officer.CARGO_HOLD;
                break;
            case SHIELDS:
                officers = Officer.WEAPONS;
                break;
            case LANDING_PARTY:
                officers = Officer.SHIELDS;
                break;
            case NAVIGATION:
                officers = Officer.LANDING_PARTY;
                break;
            case CAPTAIN:
                officers = Officer.NAVIGATION;
                break;
        }
    }

    public int trocaRecursos(int num1, int num2) {
        if(num1 == num2) {
            semRecursos = true;
            return TROCA_PELO_MESMO_RECURSO;
        }
        if(num1 == 1) {
            if(black == 0) {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
            if(num2 == 2) {
                black--;
                red++;
                return 1;
            }
            if(num2 == 3) {
                black--;
                green++;
                return 1;
            }
            if(num2 == 4) {
                black--;
                blue++;
                return 1;
            }
        }
        if(num1 == 2) {
            if(red == 0) {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
            if(num2 == 1) {
                red--;
                black++;
                return 1;
            }
            if(num2 == 3) {
                red--;
                green++;
                return 1;
            }
            if(num2 == 4) {
                red--;
                blue++;
                return 1;
            }
        }
        if(num1 == 3) {
            if(green == 0) {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
            if(num2 == 1) {
                green--;
                black++;
                return 1;
            }
            if(num2 == 2) {
                green--;
                red++;
                return 1;
            }
            if(num2 == 4) {
                green--;
                blue++;
                return 1;
            }
        }
        if(num1 == 4) {
            if(blue == 0) {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
            if(num2 == 1) {
                blue--;
                black++;
                return 1;
            }
            if(num2 == 2) {
                blue--;
                red++;
                return 1;
            }
            if(num2 == 3) {
                blue--;
                green++;
                return 1;
            }
        }
        semRecursos = true;
        return 0;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Weapon: " + weapon + "\n";
        str += "Fuel: " + fuel + "\n";
        str += "Shield: " + shield + "\n";
        str += "Nivel de Cargo Hold: " + cargoHoldLevel + "\n";
        if(drone != null) {
            str += "Drone Armor: " + drone.getArmor() + "\n";
        }
        str += "\n" + "Numero de recursos:\n";
        str += "Black: " + black + "\n";
        str += "Blue: " + blue + "\n";
        str += "Red: " + red + "\n";
        str += "Green: " + green + "\n";
        str += "Artefactos encontrados: " + artefact + "\n";
        str += "\nOfficers na nave:\n";
        switch (officers) {
            case CAPTAIN:
                str += "Captain\n";
                break;
            case NAVIGATION:
                str += "Captain\nNavigation\n";
                break;
            case LANDING_PARTY:
                str += "Captain\nNavigation\nLanding Party\n";
                break;
            case SHIELDS:
                str += "Captain\nNavigation\nLanding Party\nShield\n";
                break;
            case WEAPONS:
                str += "Captain\nNavigation\nLanding Party\nShield\nWeapon\n";
                break;
            case CARGO_HOLD:
                str += "Captain\nNavigation\nLanding Party\nShield\nWeapon\nCargo Hold\n";
                break;
        }
        return str;
    }

    public abstract boolean upgradeCargoHold();

    public int compraCrew() {
        if(officers == Officer.CARGO_HOLD) {
            semRecursos = true;
            return TRIPULACAO_MAXIMA;
        }
        else {
            if(black >= 1 && blue >= 1 && green >= 1 && red >= 1) {
                black--;
                blue--;
                green--;
                red--;
                crewRescue();
                return 1;
            }
            else {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
        }
    }

    public int droneArmor() {
        if(drone == null)
            return NAO_TEM_DRONE;
        if(drone.getArmor() == 6) {
            semRecursos = true;
            return ARMOR_MAXIMO;
        }

        else {
            if(black >= 1 && blue >= 1 && green >= 1 && red >= 1) {
                black--;
                blue--;
                green--;
                red--;
                drone.setArmor(6);
                return 1;
            }
            else {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
        }
    }

    public int comprarDrone() {
        if(drone != null) {
            semRecursos = true;
            return DRONE_JA_TEM;
        }
        else {
            if(black >= 3 && blue >= 3 && green >= 3 && red >= 3) {
                black -= 3;
                blue -= 3;
                green -= 3;
                red -= 3;
                drone = new Drone();
                return 1;
            }
            else {
                semRecursos = true;
                return RECURSOS_INSUFICIENTES;
            }
        }
    }

    public abstract int upgradeWeapon();

    public void lancaDrone(int getxL, int getyL) {
        drone.setX(getxL);
        drone.setY(getyL);
    }
}
