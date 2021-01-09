package votacao.eletronica;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/funcoesvotacao")
public class FuncoesVotacao {
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
 
	@GET
	@Path("/items")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String listaItemsVotacao( ) throws RemoteException {
		getRegistryStub("votacaoEletronica");
		try {
		  return stub.listaItemsVotacao();
		} catch (Exception e) {
		  return "Não foi possivel listar itens de votação";
		}
	   }
	@GET
	@Path("/resultados")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String listarResultadosVotacao( ) throws RemoteException {
		getRegistryStub("votacaoEletronica");
		try {
		  return stub.listarResultadosVotacao();
		} catch (Exception e) {
		  return "Não foi possivel listar resultados de votação";
		}
	   }
	@GET
	@Path("/login/{dn}/{pwd}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String validaUtilizador(@PathParam("dn")String dn ,@PathParam("pwd") String user_pwd) throws RemoteException {
		getRegistryStub("votacaoEletronica");
		try {
		  return stub.validaUtilizador(dn, user_pwd);
		} catch (Exception e) {
		  return "Não foi possivel validar utilizador";
		}
	   }
	
	}
