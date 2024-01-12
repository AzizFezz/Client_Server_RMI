package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringObjectServiceImpl extends UnicastRemoteObject implements StringObjectService {
    public StringObjectServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int ppcm(int a, int b) throws RemoteException {
        int p = a * b;
        while(a!=b){
            if(a<b)  b-=a;
            else  a-=b;
        }
        return p/a;
    }

    @Override
    public int pgcd(int a, int b) throws RemoteException {
        if(b>a){
            int t = a;  a = b;  b = t;
        }
        int r = 0;
         do {
             r = a % b;  a = b;  b = r;
         }while(r!=0);
        return a ;
    }
}
