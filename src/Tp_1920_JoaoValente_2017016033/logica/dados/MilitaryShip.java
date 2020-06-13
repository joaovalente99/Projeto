package Tp_1920_JoaoValente_2017016033.logica.dados;

public class MilitaryShip extends Ship {
    private int weaponLevel; //nivel da weapon

    public MilitaryShip() {
        super(9, 35, 9);
        weaponLevel = 0;
    }

    public int getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(int weaponLevel) {
        this.weaponLevel = weaponLevel;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Weapon Level: " + weaponLevel + "\n";
        str += super.toString();
        return str;
    }

    @Override
    public boolean upgradeCargoHold() {
        if(getOfficers() != Officer.CARGO_HOLD)
            return false;
        if(getCargoHoldLevel() < 1 && getBlack() >= 2 && getBlue() >= 2 && getGreen() >= 2 && getRed() >= 2) {
            super.setCargoHoldLevel(super.getCargoHoldLevel() + 1);
            setBlack(getBlack() - 2);
            setGreen(getGreen() - 2);
            setRed(getRed() - 2);
            setBlue(getBlue() - 2);
            return true;
        }
        else
            return false;
    }

    @Override
    public int upgradeWeapon() {
        if(weaponLevel == 1)
            return WEAPON_LEVEL_MAXIMO;
        else {
            if(getBlack() >= 2 && getBlue() >= 2 && getGreen() >= 2 && getRed() >= 2) {
                setBlack(getBlack() - 2);
                setBlue(getBlue() - 2);
                setGreen(getGreen() - 2);
                setRed(getRed() - 2);
                weaponLevel = 2;
                setWeapon(18);
                return 1;
            }
            else
                return RECURSOS_INSUFICIENTES;
        }
    }
}
