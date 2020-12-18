package maven.example.projetocd;
 
import java.net.URL;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.views.AllDocsRequestBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
 
import static java.util.stream.Collectors.*;
public class DataBase {
 
 
public static List<ItemDocument> listaItemsVotacao() throws Exception {
		CloudantClient client  = 
				ClientBuilder.url(new URL("http://localhost:5984"))
				              .username("admin")
				              .password("admin")
				              .build();
		   Database db = client.database("votacao_db", false);
		   
	
		   List<ItemDocument> response = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(ItemDocument.class);
		
		   List<ItemDocument> itemsVotacao =
		                    response.stream()
		                    .filter((c) -> c.getTipo().equals("Item"))
		                    .collect(toList());
		   
 
		return itemsVotacao;
	}
 
}
