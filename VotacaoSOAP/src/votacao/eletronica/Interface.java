package votacao.eletronica;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Interface  extends Remote {
	String validaUtilizador(String dn ,String user_pwd) throws RemoteException;
	String listaItemsVotacao()throws RemoteException;
	String inicioDaVotacao() throws RemoteException;
	String duracaoDataSessao() throws RemoteException;
	String tempoRestanteSessao()throws RemoteException;
	String numeroTotalVotos() throws RemoteException;
	String listarResultadosVotacao()throws RemoteException;
	String itemGanhador() throws RemoteException;
	String listaUtilizadoresRegistados() throws RemoteException;
	String listaUtilizadoresSessao() throws RemoteException;
	String associarUtilizador(String idUser)throws RemoteException;
	String removerUtilizador(String idUser) throws RemoteException;
	String obtemDescricaoItemVotado(String idItem)throws RemoteException;
	String votarNoItemSelecionado(String idItem,String userId) throws RemoteException;
}
