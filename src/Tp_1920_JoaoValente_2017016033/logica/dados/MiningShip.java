package Tp_1920_JoaoValente_2017016033.logica.dados;

public class MiningShip extends Ship {

    public MiningShip() {
        super(9, 53, 18);

    }

    @Override
    public boolean upgradeCargoHold() {
        if(getOfficers() != Officer.CARGO_HOLD) {
            setSemRecursos(true);
            return false;
        }
        if(getCargoHoldLevel() < 3 && getBlack() >= 2 && getBlue() >= 2 && getGreen() >= 2 && getRed() >= 2) {
            super.setCargoHoldLevel(super.getCargoHoldLevel() + 1);
            setBlack(getBlack() - 2);
            setGreen(getGreen() - 2);
            setRed(getRed() - 2);
            setBlue(getBlue() - 2);
            return true;
        }
        else {
            setSemRecursos(true);
            return false;
        }
    }

    @Override
    public int upgradeWeapon() {
        return 0;
    }
}
