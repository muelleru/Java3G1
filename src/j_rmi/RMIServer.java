package j_rmi;

import global.Workable;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer extends Workable {
    @Override
    public void doWork() {
        try {
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.bind("HamsterService", new HamsterServiceImpl());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
