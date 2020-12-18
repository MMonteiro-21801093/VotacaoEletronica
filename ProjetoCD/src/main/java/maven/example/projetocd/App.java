package maven.example.projetocd;

import java.net.URL;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import java.util.List;
 
/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
    	
    	CloudantClient client =
    	ClientBuilder.url(new URL("http://localhost:5984"))
    	              .username("admin")
    	              .password("admin")
    	              .build();

    	// Show the server version
    	System.out.println("Server Version: " + client.serverVersion());

    	// Get a List of all the databases this Cloudant account
    	List<String> databases = client.getAllDbs();
    	System.out.println("All my databases : ");
    	for ( String db : databases ) {
    		System.out.println(db);
    	}

    	// Working with data

    	// Create a new database.
    	// client.createDB("votacao_db");

    	// Get a Database instance to interact with, but don't create it if it doesn't already exist
    	Database db = client.database("votacao_db", false);

    	// Create an ExampleDocument and save it in the database
        db.save(new SessionDocument());
    	//System.out.println("You have inserted the document");
 
       	db.save(new ItemDocument("1","AM","Ant-Man"));
        db.save(new ItemDocument("2","AV","Avengers - Age of Ultron"));
        db.save(new ItemDocument("3","CA","Captain America - The Winter Soldier"));
        db.save(new ItemDocument("4","GG","Guardians of the Galaxy"));
        db.save(new ItemDocument("5","IM","Iron Man 3"));
        db.save(new ItemDocument("6","TR","Thor - The Dark World"));
    	
    	
       	db.save(new VoterDocument("2233322"));
       	db.save(new VoterDocument("2211198"));
     	db.save(new VoterDocument("2344442"));
     	db.save(new VoterDocument("2133331"));
     	db.save(new VoterDocument("2666286"));
     	db.save(new VoterDocument("2121199"));
     	db.save(new VoterDocument("2122119"));
     	db.save(new VoterDocument("2299992"));
     	db.save(new VoterDocument("2131456"));
     	db.save(new VoterDocument("2511211"));
    	db.save(new VoterDocument("2111188"));
    	db.save(new VoterDocument("2511151"));
    	db.save(new VoterDocument("2177888"));
    	db.save(new VoterDocument("2122116"));
    	db.save(new VoterDocument("2122116"));
    	// Get an ExampleDocument out of the database and deserialize the JSON into a Java type
    	//	SessionDocument doc = db.find(SessionDocument.class,"1");
    	//System.out.println(doc);

    	// Delete a database we created previously.
    	//client.deleteDB("example_db");
    	
    }
}
