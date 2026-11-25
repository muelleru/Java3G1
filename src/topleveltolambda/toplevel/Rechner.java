package topleveltolambda.toplevel;

import javax.swing.*;
import java.awt.*;

public class Rechner extends JFrame {

    private JTextField txtZahl1;
    private JTextField txtZahl2;
    private JButton btnAdd;
    private JButton btnSub;
    private JTextField txtErgebnis;

    public Rechner() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10,10,200,200);
        setVisible(true);
        setLayout(new FlowLayout());

        txtZahl1 = new JTextField();
        add(txtZahl1);

        txtZahl2 = new JTextField();
        add(txtZahl2);

        btnAdd = new JButton("+");
        add(btnAdd);

        btnSub = new JButton("-");
        add(btnSub);

        txtErgebnis = new JTextField();
        txtErgebnis.setEditable(false);
        add(txtErgebnis);

    }

}
