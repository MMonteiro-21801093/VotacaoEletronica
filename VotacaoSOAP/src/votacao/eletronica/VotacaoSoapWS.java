package votacao.eletronica;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.jws.WebService;


 

@WebService(targetNamespace = "http://eletronica.votacao/", portName = "VotacaoSoapWSPort", serviceName = "VotacaoSoapWSService")
public class VotacaoSoapWS {
	public static Interface stub = null;
	public static String host = "localhost";
	public static int port = 1099;
	
	protected void getRegistryStub(String name) {
		try {
			Registry registry = LocateRegistry.getRegistry(host,port);
			stub = (Interface) registry.lookup(name);
		} catch (Exception e) {
			System.err.println("client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	public String validaUtilizador(String dn ,String user_pwd) throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
		  return stub.validaUtilizador(dn,user_pwd);
		} catch (Exception e) {
		  return e.getMessage().toString();
		}
	
	}
	public String listaItemsVotacao()  throws Exception{
		getRegistryStub("votacaoEletronica");
		try {
	    	return stub.listaItemsVotacao();
		} catch (Exception e) {
		return e.getMessage().toString();
		}
	
	}
	public String inicioDaVotacao() throws Exception {
		getRegistryStub("votacaoEletronica");
	
		try {
		    	return stub.inicioDaVotacao();
			} catch (Exception e) {
				return "Não foi possivel executar a ação selecionada";
			}
	}
	public String duracaoDataSessao() throws Exception {
		getRegistryStub("votacaoEletronica");		
		try {
			return stub.duracaoDataSessao();
		} catch (Exception e) {
			return "Não foi possivel obter duração da sessão";
		}
	}
	public String tempoRestanteSessao() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.tempoRestanteSessao();
		} catch (Exception e) {
			return "Não foi possivel obter tempo restante da sessão";
		}
	}
	public String numeroTotalVotos() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.numeroTotalVotos();
		} catch (Exception e) {
			return "Não foi possivel obter nº total de votos";
		}
	}
	public String listarResultadosVotacao() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.listarResultadosVotacao();
		} catch (Exception e) {
			return "Não foi possivel listar resultados da votação";
		}
		
	}
	public String itemGanhador() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.itemGanhador();
		} catch (Exception e) {
			return "Não foi possivel listar item ganhador";
		}
	
	}
	public String listaUtilizadoresRegistados() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.listaUtilizadoresRegistados();
		} catch (Exception e) {
			return "Não foi possivel listar utilizadores registados";
		}
		
	}
 
	public String listaUtilizadoresSessao() throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.listaUtilizadoresSessao();
		} catch (Exception e) {
			return "Não foi possivel listar utilizadores da sessão";
		}
	
	}
	public String associarUtilizador(String idUser) throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.associarUtilizador(idUser);
		} catch (Exception e) {
			return "Não foi possivel associar utilizador";
		}
		
	}
	public String removerUtilizador(String idUser) throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.removerUtilizador(idUser);
		} catch (Exception e) {
			return "Não foi possivel remover utilizador";
		}

	}
	public String obtemDescricaoItemVotado(String idItem)  throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.obtemDescricaoItemVotado(idItem);
		} catch (Exception e) {
			return "Não foi possivel obter descrição do item votado";
		}
	
	}
	public String votarNoItemSelecionado(String idItem,String userId)  throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.votarNoItemSelecionado(idItem,userId);
		} catch (Exception e) {
			return "Não foi possivel votar no item selecionado";
		}
	
	}
	public String votanteAtivo(String id) throws Exception {
		getRegistryStub("votacaoEletronica");
		try {
			return stub.votanteAtivo(id);
		} catch (Exception e) {
			return "Não foi possivel obter se votante está ativo";
		}
	
	}
}
