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
		return stub.validaUtilizador(dn,user_pwd);
	}
	public String listaItemsVotacao()  throws Exception{
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
	public String obtemDescricaoItemVotado(String idItem)  throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.obtemDescricaoItemVotado(idItem);
	}
	public String votarNoItemSelecionado(String idItem,String userId)  throws Exception {
		getRegistryStub("votacaoEletronica");
		return stub.votarNoItemSelecionado(idItem,userId);
	}
	public  void teste() {
		System.out.println("MENU ADMINISTRADOR");
		System.out.println("0 - Menu inicial");
		System.out.println("1 - Listar itens em vota��o");
		System.out.println("2 - In�cio da sess�o");
		System.out.println("3 - Dura��o da sess�o");
		System.out.println("4 - Tempo restante de vota��o");
		System.out.println("5 - N�mero total de votos");
		System.out.println("6 - Listar resultados de vota��o (%)");
		System.out.println("7 - Item ganhador");
		System.out.println("8 - listar utilizadores registados");
		System.out.println("9 - listar utilizadores da sess�o");
		System.out.println("10 - associar utilizador");
		System.out.println("11 - remover utilizador");
		System.out.println("99 - Sair");
	 
	}
}
