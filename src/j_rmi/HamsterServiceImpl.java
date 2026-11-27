package j_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Map.entry;

public class HamsterServiceImpl extends UnicastRemoteObject implements HamsterService{

    private Map<Integer, Hamster> hliste;

    protected HamsterServiceImpl() throws RemoteException {
        hliste = new HashMap<>(Map.ofEntries(
                entry(1,new Hamster(1,"Donald","Rot")),
                entry(2,new Hamster(2,"Fritz","Schwarz")),
                entry(3,new Hamster().setId(3))
        ));
    }

    @Override
    public Hamster getHamster(int id) {
        if(hliste.containsKey(id)) {
            return hliste.get(id);
        }
        else {
            throw new NoSuchElementException("Hamster " + id + " gibt es nicht");
        }
    }
    @Override
    public String getName(int id) {
        return "Dummy";
    }
}
