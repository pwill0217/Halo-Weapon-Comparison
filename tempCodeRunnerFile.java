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
        Weapon[] weapons = new Weapon[4];
        weapons[0] = new Weapon("MA37 Assault Rifle", 32, 300, 0.7, 6.3);
        weapons[1] = new Weapon("DMR", 15, 950, 0.9, 17.5);
        weapons[2] = new Weapon("M6G", 12, 80, 0.95, 12.5);
        weapons[3] = new Weapon("Needler", 20, 40, 0.85, 10);

        // Create the GUI and display it
        WeaponGUI gui = new WeaponGUI(weapons);
        gui.setVisible(true);
    }
}
