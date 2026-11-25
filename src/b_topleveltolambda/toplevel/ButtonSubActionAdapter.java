package b_topleveltolambda.toplevel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSubActionAdapter implements ActionListener {
    private Rechner rechner;
    public ButtonSubActionAdapter(Rechner rechner) {
        this.rechner = rechner;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        rechner.onMinus();
    }
}
