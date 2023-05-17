public class Weapon {
    private String name;
    private int ammoCount;
    private int range;
    private double accuracy;
    private double dps;

    public Weapon(String name, int ammoCount, int range, double accuracy, double dps) {
        this.name = name;
        this.ammoCount = ammoCount;
        this.range = range;
        this.accuracy = accuracy;
        this.dps = dps;
    }

    public String getName() {
        return name;
    }

    public int getAmmoCount() {
        return ammoCount;
    }

    public int getRange() {
        return range;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getDps() {
        return dps;
    }

    public static void main(String[] args) {
        // Creating an array of weapons, and then printing out the information for each
        // weapon.
        Weapon[] weapons = new Weapon[10];
        weapons[0] = new Weapon("MA37 Assault Rifle", 32, 300, 0.7, 6.3);
        weapons[1] = new Weapon("DMR", 15, 950, 0.9, 17.5);
        weapons[2] = new Weapon("M6G", 12, 80, 0.95, 12.5);
        weapons[3] = new Weapon("Needler", 20, 40, 0.85, 10);
        for (int i = 0; i < weapons.length; i++) {
            String name = weapons[i].getName();
            int ammoCount = weapons[i].getAmmoCount();
            int range = weapons[i].getRange();
            double accuracy = weapons[i].getAccuracy();
            double dps = weapons[i].getDps();
            System.out.println(name + ":");
            System.out.println("Ammo Count: " + ammoCount + " Rounds per Mag");
            System.out.println("Range: " + range + " Meters");
            System.out.println("Accuracy: " + accuracy);
            System.out.println("DPS: " + dps + " Damage per Shot");
            System.out.println();
        }
    }
}
