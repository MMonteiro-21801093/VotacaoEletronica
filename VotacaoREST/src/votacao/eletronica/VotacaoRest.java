package votacao.eletronica;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class Votacao
 */
@WebServlet("/VotacaoRest")
public class VotacaoRest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotacaoRest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		 
					String base = "ou=prod,dc=example,dc=com";
					String user_rdn ="ou=people"; // user RDN (relative distinguished names)
					String dn = "uid=" + "" + "," + user_rdn + "," + base; // DN (distinguished name)
					String uname = request.getParameter("uname");
					String password = request.getParameter("password");
				    if(uname.equals("101010")) {
				    	 user_rdn ="ou=admin";
				    }
					 dn = "uid=" + uname + "," + user_rdn + "," + base; // DN (distinguished name)
					 
				      String uri = "http://localhost:8080/VotacaoREST/rest/funcoesvotacao/login/"+dn+"/"+password;
				        ClientConfig config = new ClientConfig();
				        Client client = ClientBuilder.newClient(config);
				        WebTarget target = client.target(uri);
				         
				        String result = target.request()
				                    .accept(MediaType.TEXT_PLAIN)
				                    .get(String.class);
				        
				        
					    if(result.equals("OK")){
					      response.sendRedirect(request.getContextPath()+"/Opcoes.jsp");
					      }
	 
	}
}
