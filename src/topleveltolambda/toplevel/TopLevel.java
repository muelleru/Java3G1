package topleveltolambda.toplevel;

import global.Workable;

import javax.swing.*;

public class TopLevel extends Workable {
    @Override

    public void doWork() {
        SwingUtilities.invokeLater( () -> {

         new Rechner();

        });
    }


}
