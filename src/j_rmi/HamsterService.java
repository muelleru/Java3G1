package j_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HamsterService extends Remote {
    Hamster getHamster(int id) throws RemoteException;
    String getName(int id) throws RemoteException;
}
