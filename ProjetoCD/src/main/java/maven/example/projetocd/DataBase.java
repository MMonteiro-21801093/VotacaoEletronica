package maven.example.projetocd;
 
 
import java.net.URL;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.views.AllDocsRequestBuilder;
import com.cloudant.client.api.views.AllDocsResponse;
import com.cloudant.client.org.lightcouch.Response;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
public class DataBase {
	static CloudantClient client;
	static Database db;
public static List<ItemDocument> listaItemsVotacao() throws Exception {
	     connectDatabase();
		   List<ItemDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(ItemDocument.class);
		
		   List<ItemDocument> itemsVotacao =
		                    response.stream()
		                    .filter((c) -> c.getTipo().equals("Item"))
		                    .collect(toList());
		   
		return itemsVotacao;
	}

public static SessionDocument inicioDaVotacao()throws Exception  {
	connectDatabase();
	return db.find(SessionDocument.class,"9999");
}
public static int numeroTotalVotos()throws Exception  {
	connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
		
	   List<VoterDocument> itemsVotacao =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votante"))
	                    .collect(toList());
	   
	   List<VoterDocument> numeroVotos =
               response.stream()
               .filter((c) -> c.getItemVoto().equals("")==false)
               .collect(toList());
	   
	return numeroVotos.size();
}
private static void connectDatabase() throws Exception {
	  client  = 
				ClientBuilder.url(new URL("http://localhost:5984"))
				              .username("admin")
				              .password("admin")
				              .build();
		     db = client.database("votacao_db", false);
	
}

public static List<VoterDocument> listaUtilizadoresRegistados()throws Exception {
	 connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
	   List<VoterDocument> utilizadoresRegistados =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .collect(toList());
	
	return utilizadoresRegistados;
}

public static List<VoterDocument> listaUtilizadoresSessao()throws Exception {
	connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
		
	   List<VoterDocument> utilizadoresRegistados =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .filter((c) -> c.getAcesso()== true)
	                    .collect(toList());
	return utilizadoresRegistados; 
}

public static String associarUtilizador(String user_id) throws Exception{
	connectDatabase();
	VoterDocument  votante = db.find(VoterDocument.class,user_id);
	votante.setAcesso(true);
	com.cloudant.client.api.model.Response response = db.update(votante);
	return "OK";
}

public static String removerUtilizador(String user_id) throws Exception{
		connectDatabase();
		VoterDocument  votante = db.find(VoterDocument.class,user_id);
		votante.setAcesso(false);
		com.cloudant.client.api.model.Response response = db.update(votante);
		return "OK";
}

public static List<String> itemGanhador() throws Exception{
	connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
	   List<VoterDocument> utilizadores =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .collect(toList());
	
	   ArrayList<ResultadoEleicao> resultado = new ArrayList<>();
	   
	   long antMan = response.stream()
               .filter((c) -> c.getItemVoto().equals("Ant-Man"))
               .collect(Collectors.counting());
	   
	   ResultadoEleicao resultadoEleicao = new ResultadoEleicao("Ant-Man", antMan);
	   resultado.add(resultadoEleicao);
	   
	   long avengers = response.stream()
               .filter((c) -> c.getItemVoto().equals("Avengers - Age of Ultron"))
               .collect(Collectors.counting());
	   
	   resultadoEleicao = new ResultadoEleicao("Avengers - Age of Ultron", avengers);
	   resultado.add(resultadoEleicao);
	   
	return null;
}

}
