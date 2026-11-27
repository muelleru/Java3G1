package j_rmiclient;

import j_rmi.Hamster;
import j_rmi.HamsterService;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    static void main() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            HamsterService service = (HamsterService) registry.lookup("HamsterService");
            // Der Service ist ein Remote-Objekt
          for (int i = 1 ; i<=5;i++) {
              try {
                  Hamster h = service.getHamster(i); // Kopie holen
                  System.out.println(h);
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }
          }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
