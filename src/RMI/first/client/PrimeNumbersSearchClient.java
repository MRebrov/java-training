package RMI.first.client;

import RMI.first.ClientRegister;
import RMI.first.PrimeChecker;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class PrimeNumbersSearchClient implements PrimeChecker {

    @Override
    public boolean check(BigDecimal number) throws RemoteException {
        boolean isPrime = true;
        BigDecimal i = new BigDecimal(2);

        BigDecimal sqrt = new BigDecimal(Math.sqrt(number.doubleValue()));
        BigDecimal div = number.divide(sqrt, RoundingMode.UP);

        if (sqrt.scale() == 0 && sqrt.intValue() > 1) {

            isPrime = false;

        } else {

            // sqrt must be equal or greater than root of number
            if (div.compareTo(sqrt) == 1) {
                sqrt = div;
            }

            // while i less than sqrt
            while (i.compareTo(sqrt) == -1) {
                if (number.divideAndRemainder(i)[1].compareTo(BigDecimal.ZERO) == 0) {
                    isPrime = false;
                    break;
                }
                i = i.add(BigDecimal.ONE);
            }
        }

        System.out.println(number + ((isPrime) ? " is prime" : " is not prime"));

        return isPrime;
    }

    public static void main(String[] args) {
        PrimeNumbersSearchClient client = new PrimeNumbersSearchClient();

        try {
            Registry registry = LocateRegistry.getRegistry(null, 12345);
            ClientRegister server = (ClientRegister) registry.lookup("ClientRegister");

            PrimeChecker stub = (PrimeChecker) UnicastRemoteObject.exportObject(client, 0);
            server.register(stub);
        } catch (Exception ex) {
            System.out.println("Error occurred: " + ex.getMessage());
            System.exit(1);
        }
    }
}
