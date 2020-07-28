package RMI.second;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote {
    final String NAME = "Counter";

    int reset() throws RemoteException;

    int increment() throws RemoteException;
}
