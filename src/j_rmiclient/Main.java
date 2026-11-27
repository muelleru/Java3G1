package j_rmiclient;

import j_rmi.Hamster;
import j_rmi.HamsterService;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    static void main() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5000);
            HamsterService service = (HamsterService) registry.lookup("HamsterService");
            // Der Service ist ein Remote-Objekt
            Hamster h = service.getHamster(3); // Kopie holen
            System.out.println(h);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
