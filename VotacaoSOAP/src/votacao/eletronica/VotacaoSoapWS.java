package votacao.eletronica;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


 

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
		return stub.validaUtilizador(dn,user_pwd);
	}
	public String listaItemsVotacao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.listaItemsVotacao();
	}
	public String inicioDaVotacao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.inicioDaVotacao();
	}
	public String duracaoDataSessao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.duracaoDataSessao();
	}
	public String tempoRestanteSessao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.tempoRestanteSessao();
	}
	public String numeroTotalVotos() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.numeroTotalVotos();
	}
	public String listarResultadosVotacao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.listarResultadosVotacao();
	}
	public String itemGanhador() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.listarResultadosVotacao();
	}
	public String listaUtilizadoresRegistados() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.listaUtilizadoresRegistados();
	}
	public String listaUtilizadoresSessao() throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.listaUtilizadoresSessao();
	}
	public String associarUtilizador(String idUser) throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.associarUtilizador(idUser);
	}
	public String removerUtilizador(String idUser) throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.removerUtilizador(idUser);
	}
	public String obtemDescricaoItemVotado(String idItem) throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.obtemDescricaoItemVotado(idItem);
	}
	public String votarNoItemSelecionado(String idItem,String userId) throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.votarNoItemSelecionado(idItem,userId);
	}
}
