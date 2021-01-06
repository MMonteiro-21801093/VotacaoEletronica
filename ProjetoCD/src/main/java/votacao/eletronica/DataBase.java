package votacao.eletronica;
 
 
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

import java.io.IOException;
public class DataBase {
	static CloudantClient client;
	static Database db;
public static List<ItemDocument> listaItemsVotacao() throws Exception   {
	   List<ItemDocument> itemsVotacao = null;
	     
			connectDatabase();
 
		   List<ItemDocument> response;
		 
			response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(ItemDocument.class);
			 itemsVotacao =
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

public static List<ResultadoEleicao> itemGanhador() throws Exception{
	connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
	   List<VoterDocument> utilizadores =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .collect(toList());
	
	   ArrayList<ResultadoEleicao> resultado = new ArrayList<>();
	   
	   long antMan = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("1"))
               .collect(Collectors.counting());
	   
	   ItemDocument  item = db.find(ItemDocument.class,"1");
	   
	   ResultadoEleicao resultadoEleicao = new ResultadoEleicao(item.getNome(), antMan);
	   resultado.add(resultadoEleicao);
	   
	   long avengers = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("2"))
               .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"2");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), avengers);
	   resultado.add(resultadoEleicao);
	   
	   long capitanAmerica = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("3"))
               .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"3");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), capitanAmerica);
	   resultado.add(resultadoEleicao);
	   
	   long guardiansGalaxy = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("4"))
               .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"4");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), guardiansGalaxy);
	   resultado.add(resultadoEleicao);
	   
	   long ironMan = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("5"))
               .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"5");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), ironMan);
	   resultado.add(resultadoEleicao);
	   
	   long darkWorld = utilizadores.stream()
               .filter((c) -> c.getItemVoto().equals("6"))
               .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"6");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), darkWorld);
	   resultado.add(resultadoEleicao);
	   
	   
	   List<ResultadoEleicao> listaResultadoEleicao =
			   resultado.stream()
                       .sorted((c1, c2) -> c1.getVotos() - c2.getVotos())
                       .collect(toList());
	   
	return listaResultadoEleicao;
}

public static String obtemDescricaoItemVotado(String id)throws Exception {
    connectDatabase();
	ItemDocument item = db.find(ItemDocument.class,id);
	return item.getNome();
}

public static String votarNoItemSelecionado(String item,String idVotante)throws Exception {
	connectDatabase();
	VoterDocument  votante = db.find(VoterDocument.class,idVotante);
	votante.setItemVoto(item);
	com.cloudant.client.api.model.Response response = db.update(votante);
	return "OK";
	
}

public static List<ResultadoEleicao> listarResultadosVotacao() throws Exception {
	connectDatabase();
	 List<VoterDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(VoterDocument.class);
	   List<VoterDocument> utilizadores =
	                    response.stream()
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .collect(toList());
	
	   ArrayList<ResultadoEleicao> resultado = new ArrayList<>();
	   int quantidadeVotos = utilizadores.size();
	   
	   long antMan = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("1"))
              .collect(Collectors.counting());
	   
	   ItemDocument  item = db.find(ItemDocument.class,"1");
	   
	   ResultadoEleicao resultadoEleicao = new ResultadoEleicao(item.getNome(), antMan);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   long avengers = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("2"))
              .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"2");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), avengers);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   long capitanAmerica = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("3"))
              .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"3");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), capitanAmerica);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   long guardiansGalaxy = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("4"))
              .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"4");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), guardiansGalaxy);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   long ironMan = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("5"))
              .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"5");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), ironMan);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   long darkWorld = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("6"))
              .collect(Collectors.counting());
	   
	   item = db.find(ItemDocument.class,"6");
	   
	   resultadoEleicao = new ResultadoEleicao(item.getNome(), darkWorld);
	   resultadoEleicao.calculaPercentagem(quantidadeVotos);
	   resultado.add(resultadoEleicao);
	   
	   
	   List<ResultadoEleicao> listaResultadoEleicao =
			   resultado.stream()
                      .sorted((c1, c2) -> c1.getVotos() - c2.getVotos())
                      .collect(toList());
	return listaResultadoEleicao;
}

}
