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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import votacao.eletronica.ResultadoEleicao;
import votacao.eletronica.SessionDocument;
import votacao.eletronica.VoterDocument;
import votacao.eletronica.ItemDocument;
import static java.util.stream.Collectors.*;

import java.io.IOException;
public class DBBackEnd {
	public DBBackEnd() {
		super();
	}

	static CloudantClient client;
	static Database db;

	 
public static List<ItemDocument> listaItemsVotacao() throws Exception   {
	   List<ItemDocument> itemsVotacao = new ArrayList<ItemDocument>();
	     
			connectDatabase();
 
		   List<ItemDocument> response;
		 
			response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(ItemDocument.class);
			
			for(ItemDocument doc:response) {
				if(doc.getTipo().equals("Item")) {
					itemsVotacao.add(doc);
				}
			}
		//	itemsVotacao =
		//	       response.stream()
		//	    .filter((c) -> c.getTipo().equals("Item"))
		//	    .collect(toList());
	 
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
	                    .filter((c) -> c.getTipo().equals("Votantes"))
	                    .collect(toList());
	   
	   List<VoterDocument> numeroVotos =
			   itemsVotacao.stream()
               .filter((c) -> !c.getItemVoto().equals(""))
               .collect(toList());
	   
	return numeroVotos.size();
}
private static void connectDatabase() throws Exception {
 
          client = 
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
                       .sorted(Comparator.comparing(ResultadoEleicao::getVotos).reversed())
                       .collect(Collectors.toList());
 
	return listaResultadoEleicao;
}

public static String obtemDescricaoItemVotado(String id)throws Exception {
    connectDatabase();
	ItemDocument item = db.find(ItemDocument.class,id);
	return item.getNome();
}
public static String votanteAtivo(String id)throws Exception {
    connectDatabase();
    VoterDocument voter = db.find(VoterDocument.class,id);
    if( voter.getAcesso()) {
    	
    	return "OK";
    }else {
    	return "Votante sem acesso ao voto";
    }

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
	   int quantidadeVotos = 0;
	   
	   long antMan = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("1"))
              .collect(Collectors.counting());
	   
	   quantidadeVotos+= antMan;
	   
	   ItemDocument  item = db.find(ItemDocument.class,"1");
	   
	   ResultadoEleicao resultadoEleicaoAntMan = new ResultadoEleicao(item.getNome(), antMan);
	   
	 
	   
	   long avengers = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("2"))
              .collect(Collectors.counting());
	   
	   quantidadeVotos+= avengers;
	   
	   item = db.find(ItemDocument.class,"2");
	   
	   ResultadoEleicao resultadoEleicaoAvengers = new ResultadoEleicao(item.getNome(), avengers);
	 
	   
	   long capitanAmerica = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("3"))
              .collect(Collectors.counting());
	   
	   
	   quantidadeVotos+= capitanAmerica;
	   
	   
	   item = db.find(ItemDocument.class,"3");
	   
	   ResultadoEleicao resultadoEleicaoCapitanAmerica = new ResultadoEleicao(item.getNome(), capitanAmerica);
	
	   
	   long guardiansGalaxy = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("4"))
              .collect(Collectors.counting());
	   
	   
	   quantidadeVotos+= guardiansGalaxy;
	   
	   item = db.find(ItemDocument.class,"4");
	   
	   ResultadoEleicao resultadoEleicaoGuardiansGalaxy = new ResultadoEleicao(item.getNome(), guardiansGalaxy);
	
	   
	   long ironMan = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("5"))
              .collect(Collectors.counting());
	   
	   quantidadeVotos+= ironMan;
	   
	   item = db.find(ItemDocument.class,"5");
	   
	   ResultadoEleicao resultadoEleicaoIronMan = new ResultadoEleicao(item.getNome(), ironMan);

	   
	   long darkWorld = utilizadores.stream()
              .filter((c) -> c.getItemVoto().equals("6"))
              .collect(Collectors.counting());
	   
	   quantidadeVotos+= darkWorld;
	   
	   item = db.find(ItemDocument.class,"6");
	   
	   ResultadoEleicao resultadoEleicaoDarkWorld = new ResultadoEleicao(item.getNome(), darkWorld);

	   
	   
	   
	   
	   
	   if(antMan> 0) {
		   resultadoEleicaoAntMan.calculaPercentagem(quantidadeVotos);  
	   }
	   if(avengers> 0) {
		   resultadoEleicaoAvengers.calculaPercentagem(quantidadeVotos);  
	   }
	   if(capitanAmerica> 0) {
		   resultadoEleicaoCapitanAmerica.calculaPercentagem(quantidadeVotos);  
	   }
	   if(guardiansGalaxy> 0) {
		   resultadoEleicaoGuardiansGalaxy.calculaPercentagem(quantidadeVotos);  
	   }
	   if(ironMan> 0) {
		   resultadoEleicaoIronMan.calculaPercentagem(quantidadeVotos);  
	   }
	   if(darkWorld> 0) {
		   resultadoEleicaoDarkWorld.calculaPercentagem(quantidadeVotos);  
	   }

	   resultado.add(resultadoEleicaoAntMan);
	   resultado.add(resultadoEleicaoAvengers);	
	   resultado.add(resultadoEleicaoCapitanAmerica);
	   resultado.add(resultadoEleicaoGuardiansGalaxy);
	   resultado.add(resultadoEleicaoIronMan);
	   resultado.add(resultadoEleicaoDarkWorld);
	   
	   
	   List<ResultadoEleicao> listaResultadoEleicao =
			   resultado.stream()
                       .sorted(Comparator.comparing(ResultadoEleicao::getVotos).reversed())
                       .collect(Collectors.toList());
	 
	   
	
	return listaResultadoEleicao;
}

}
