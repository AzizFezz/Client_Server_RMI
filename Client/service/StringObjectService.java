package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringObjectService extends Remote {
    public int ppcm(int a, int b)
            throws RemoteException;
    public int pgcd(int a, int b) throws
            RemoteException;
}