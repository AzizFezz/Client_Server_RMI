

import service.StringObjectService;
import service.StringObjectServiceImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class serveur {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        //RMI
        LocateRegistry.createRegistry(5000);
        StringObjectServiceImpl objectDistance = new StringObjectServiceImpl();
        System.out.println(objectDistance.toString());
        Naming.rebind("rmi://localhost:5000/String/operations", objectDistance);
    }
}
