package topleveltolambda.toplevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.IntBinaryOperator;

public class Rechner extends JFrame {

    private JTextField txtZahl1;
    private JTextField txtZahl2;
    private JButton btnAdd;
    private JButton btnSub;
    private JTextField txtErgebnis;

    // Statische Memberklasse
    static class ButtonAddActionAdapterV2 implements ActionListener {
        private Rechner rechner;
        public ButtonAddActionAdapterV2(Rechner rechner) {
            this.rechner = rechner;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            rechner.onPlus();
        }
    }
    // Nicht-statische Memberklasse
     class ButtonAddActionAdapterV3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             onPlus();
        }
    }
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
        // Lokale Klasse
        // class XYZ { }

//        btnAdd.addActionListener(new ButtonAddActionAdapterV2(this));
//        btnAdd.addActionListener(new ButtonAddActionAdapterV3());
// Anonyme Klasse
//        btnAdd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Rechner.this.onPlus(); // Outer-this
//
//            }
//        });
        btnAdd.addActionListener( (e)-> {
//            if(e.getSource() instanceof JButton tmp) {
//                if(tmp.getText().equals("+")) {
//                    // PLUS
//                } else if(tmp.getText().equals("-")) {
//
//                }
//            }
//            if(e.getSource() == btnAdd) {}
            //this.onPlus();
            this.onCalc( (a,b) -> a+b );
            // this.onCalc( "+" );

            // Funktion mit Parameter a und b
            // Rückgabe a+b

        });
        btnSub.addActionListener(new ButtonSubActionAdapter(this));
    }

    // Parameter ist vom Typ Function<int,int> => int
    public void onCalc(IntBinaryOperator op) {
        try{
            int z1 = Integer.parseInt(txtZahl1.getText());
            int z2 = Integer.parseInt(txtZahl2.getText());
            int res = op.applyAsInt(z1,z2);
            // int res = z1 + z2;
            txtErgebnis.setText(String.valueOf(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR " + e.getMessage());
        }
    }

    public void onCalc(String op) {
        try{
            int z1 = Integer.parseInt(txtZahl1.getText());
            int z2 = Integer.parseInt(txtZahl2.getText());
            int res = switch(op) {
                case "+"-> z1+z2;
                case "-"-> z1-z2;
                default -> 0;
            };
            // int res = z1 + z2;
            txtErgebnis.setText(String.valueOf(res));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ERROR " + e.getMessage());
        }
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
