package projeto.votacao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    String getDate() throws RemoteException; 
    void listaItemsVotacao() throws RemoteException;
    void listarResultadosVotacao() throws RemoteException;
    void listaUtilizadoresRegistados() throws RemoteException;    
}
