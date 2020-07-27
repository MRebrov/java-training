package RMI.first.server;

import RMI.first.ClientRegister;
import RMI.first.PrimeChecker;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PrimeNumbersSearchServer implements ClientRegister {

    private BlockingQueue<PrimeChecker> availableCheckers = new LinkedBlockingQueue<PrimeChecker>();

    private BigDecimal number = BigDecimal.ZERO;

    public void register(PrimeChecker checker) throws RemoteException {
        availableCheckers.add(checker);
    }

    public void startSearch() {
        while (true) {
            try {
                final PrimeChecker checker = availableCheckers.take();
                final BigDecimal numberToCheck = increment();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (checker.check(numberToCheck)) {
                                System.out.println(numberToCheck);
                            }
                            availableCheckers.add(checker);
                        } catch (RemoteException ex) {
                            System.out.println("Client disconnected or unknown error occurred");
                        }
                    }
                }).start();
            } catch (InterruptedException e) {

            }
        }
    }

    private synchronized BigDecimal increment() {
        number = number.add(BigDecimal.ONE);
        return number;
    }

    public static void main(String[] args) {
        PrimeNumbersSearchServer server = new PrimeNumbersSearchServer();

        try {
            ClientRegister stub = (ClientRegister) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.createRegistry(12345);
            registry.bind("ClientRegister", stub);

            server.startSearch();
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            System.exit(1);
        }
    }

}
