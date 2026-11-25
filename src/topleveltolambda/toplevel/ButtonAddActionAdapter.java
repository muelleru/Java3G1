package topleveltolambda.toplevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAddActionAdapter implements ActionListener {
    private Rechner rechner;
    public ButtonAddActionAdapter(Rechner rechner) {
        this.rechner = rechner;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        rechner.onPlus();
    }
}
