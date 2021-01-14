package votacao.eletronica;
import java.rmi.Remote;
import java.rmi.RemoteException;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.views.AllDocsRequestBuilder;
import com.cloudant.client.api.views.AllDocsResponse;
import com.cloudant.client.org.lightcouch.Response;

public interface Interface  extends Remote {
	String validaUtilizador(String dn ,String user_pwd) throws RemoteException;
	String listaItemsVotacao()throws Exception;
	String inicioDaVotacao() throws Exception;
	String duracaoDataSessao() throws Exception;
	String tempoRestanteSessao() throws Exception;
	String numeroTotalVotos() throws Exception;
	String listarResultadosVotacao() throws Exception;
	String itemGanhador() throws Exception;
	String listaUtilizadoresRegistados() throws Exception;
	String listaUtilizadoresSessao() throws Exception;
	String associarUtilizador(String idUser) throws Exception;
	String removerUtilizador(String idUser) throws Exception;
	String obtemDescricaoItemVotado(String idItem) throws Exception;
	String votarNoItemSelecionado(String idItem,String userId) throws Exception;
    String votanteAtivo(String id)throws Exception;
}
