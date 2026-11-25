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

        txtZahl1 = new JTextField(10);
        add(txtZahl1);

        txtZahl2 = new JTextField(10);
        add(txtZahl2);

        btnAdd = new JButton("+");
        add(btnAdd);

        btnSub = new JButton("-");
        add(btnSub);

        txtErgebnis = new JTextField(10);
        txtErgebnis.setEditable(false);
        add(txtErgebnis);

        setListener();

        pack();
        setResizable(false);
    }

    public void setListener() {
        btnAdd.addActionListener();
        btnSub.addActionListener();
    }

    public void onPlus() {
        try{
            int z1 = Integer.parseInt(txtZahl1.getText());
            int z2 = Integer.parseInt(txtZahl2.getText());
            int res = z1 + z2;
            txtErgebnis.setText(String.valueOf(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR " + e.getMessage());
        }
    }
    public void onMinus() {
        try{
            int z1 = Integer.parseInt(txtZahl1.getText());
            int z2 = Integer.parseInt(txtZahl2.getText());
            int res = z1 - z2;
            txtErgebnis.setText(String.valueOf(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR " + e.getMessage());
        }
    }
}
