package RMI.second;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CounterServer {

    public static void main(String[] args) throws IOException, AlreadyBoundException {
        CounterClass counter = new CounterClass();
        Registry localReg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

        localReg.bind(Counter.NAME, counter);
        System.out.println("Counter Server runs");
    }

}
