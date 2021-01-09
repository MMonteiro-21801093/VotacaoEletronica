package votacao.eletronica;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interface  extends Remote {
	String validaUtilizador(String dn ,String user_pwd) throws RemoteException;
	String listaItemsVotacao() throws RemoteException;
    String listarResultadosVotacao() throws RemoteException;
    
}
