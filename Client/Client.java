import service.StringObjectService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;



public class Client {
    static int UID = 0;
    static HashMap<Integer, ArrayList<Integer>> history = new HashMap<>();
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        UID = generateUniqueUID();
        StringObjectService stub = (StringObjectService) Naming.lookup("rmi://localhost:5000/String/operations");
        Scanner sc = new Scanner(System.in);

        while (true) {
            menu();
            int a, b;
            System.out.println("Choose an option");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose a:");
                    a = sc.nextInt();
                    System.out.println("Choose b:");
                    b = sc.nextInt();
                    System.out.println(stub.pgcd(a, b));
                    updateHistory(1);
                    break;
                case 2:
                    System.out.println("Choose a:");
                    a = sc.nextInt();
                    System.out.println("Choose b:");
                    b = sc.nextInt();
                    System.out.println(stub.ppcm(a, b));
                    updateHistory(2);
                    break;
                case 0:
                    displayHistory();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option");
            }}}

    static void menu() {
        System.out.println("Menu");
        System.out.println("0. Exit");
        System.out.println("1. PGCD");
        System.out.println("2. PPCM");
    }

    static int generateUniqueUID() {
        return UID++;
    }

    static void updateHistory(int option) {
        if (history.containsKey(UID)) {
            history.get(UID).add(option);
        } else {
            ArrayList<Integer> hist = new ArrayList<>();
            hist.add(option);
            history.put(UID, hist);
        }
    }
    static void displayHistory() {
        System.out.println("Client History (UID: " + UID + ")");
        if (history.containsKey(UID)) {
            System.out.println("Options chosen: " + history.get(UID));
        } else {
            System.out.println("No history available for this client.");
        }
    }
}