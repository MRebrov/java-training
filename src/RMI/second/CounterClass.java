package RMI.second;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CounterClass extends UnicastRemoteObject implements Counter {

    private static final long serialVersionUID = 1L;
    private int counter;

    public CounterClass() throws RemoteException {
    }

    @Override
    public synchronized int reset() throws RemoteException {
        this.counter = 0;
        return this.counter;
    }

    @Override
    public synchronized int increment() throws RemoteException {
        this.counter++;
        return this.counter;
    }
}
