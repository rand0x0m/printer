package shared.helpers;

import shared.ObjectNotFoundException;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIHelper {

    private static Registry registry;
    private static boolean initialized;

    public static boolean createRegistry(int localPort) {
        if (!initialized) {
            try {
                registry = LocateRegistry.createRegistry(localPort);
                initialized = true;
                return true;
            } catch (RemoteException e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }

    public static Remote getObject(String host, String objectName) throws ObjectNotFoundException {
        return getObject(host, 1099, objectName);
    }

    public static Remote getObject(String host, int remotePort, String objectName) throws ObjectNotFoundException {
        try {
            Registry registry = LocateRegistry.getRegistry(host, remotePort);
            return registry.lookup(objectName);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new ObjectNotFoundException();
        }
    }

    public static boolean bindObject(Remote remoteObject, String bindName)  {
        if (initialized) {
            try {
                Remote remote1 = UnicastRemoteObject.exportObject(remoteObject, 0);
                registry.bind(bindName, remote1);
                return true;
            } catch (RemoteException | AlreadyBoundException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static boolean unbindObject(String bindName) {
        if (initialized) {
            try {
                registry.unbind(bindName);
                return true;
            } catch (RemoteException | NotBoundException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
