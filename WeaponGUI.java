
/**
 * The WeaponGUI class creates a graphical user interface that displays information about different
 * weapons in a JComboBox and a JTextArea.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class WeaponGUI extends JFrame {
    private JComboBox<String> weaponList;
    private JTextArea weaponInfo;

    public WeaponGUI(Weapon[] weapons) {
        // Set up the window
        setTitle("Weapon Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        // Create a combo box to display the list of weapons
        weaponList = new JComboBox<>();
        for (Weapon weapon : weapons) {
            weaponList.addItem(weapon.getName());
        }
        weaponList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display the information for the selected weapon
                int index = weaponList.getSelectedIndex();
                Weapon weapon = weapons[index];
                String info = weapon.getName() + ":\n"
                        + "Ammo Count: " + weapon.getAmmoCount() + " Rounds per Mag\n"
                        + "Range: " + weapon.getRange() + " Meters\n"
                        + "Accuracy: " + weapon.getAccuracy() + "\n"
                        + "DPS: " + weapon.getDps() + " Damage per Shot\n";
                weaponInfo.setText(info);
            }
        });

        // Create a text area to display the weapon information
        weaponInfo = new JTextArea();
        weaponInfo.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(weaponInfo);

        // Add the components to the window
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(weaponList, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Create an array of weapons
        Weapon[] weapons = new Weapon[10];
        weapons[0] = new Weapon("MA37 Assault Rifle", 32, 300, 0.7, 6.3);
        weapons[1] = new Weapon("DMR", 15, 950, 0.9, 17.5);
        weapons[2] = new Weapon("M6G", 12, 80, 0.95, 12.5);
        weapons[3] = new Weapon("Shotgun", 6, 5, 0.25, 48);
        weapons[4] = new Weapon("Sniper Rifle", 4, 2000, 1.0, 80);
        weapons[5] = new Weapon("Rocket Launcher", 2, 150, 0.90, 600);
        weapons[6] = new Weapon("Grenade Launcher", 4, 75, 0.80, 72);
        weapons[7] = new Weapon("Plasma Pistol", 100, 50, 0.80, 24);
        weapons[8] = new Weapon("Needler", 20, 40, 0.85, 10);
        weapons[9] = new Weapon("Plasma Repeater", 50, 75, 0.7, 7.2);
        // Create the GUI and display it
        WeaponGUI gui = new WeaponGUI(weapons);
        gui.setVisible(true);
    }
}
