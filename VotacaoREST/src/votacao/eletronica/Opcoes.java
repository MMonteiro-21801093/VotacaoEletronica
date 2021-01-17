package votacao.eletronica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class OpcoesAdmin
 */
@WebServlet("/Opcoes")
public class Opcoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Opcoes() {
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
		   
		   RequestDispatcher rd = request.getRequestDispatcher("Opcoes.jsp");
		   String action = request.getParameter("action");
 
         if("listar itens em votação".equals(action)) {
      	   String uri = "http://localhost:8080/VotacaoREST/rest/funcoesvotacao/items";
           request.setAttribute("resultado", retornoREST(uri));
             }
           
           
           if("listar resultados de votação (%)".equals(action)) {
        	   String uri = "http://localhost:8080/VotacaoREST/rest/funcoesvotacao/resultados";
               request.setAttribute("resultado", retornoREST(uri));
             }

           if("Log In".equals(action)) {
        	   rd = request.getRequestDispatcher("LogIn.jsp");
             }
        
           rd.forward(request, response);
		 
	}

	private String retornoREST(String uri) {
		   ClientConfig config = new ClientConfig();
 	        Client client = ClientBuilder.newClient(config);
 	        WebTarget target = client.target(uri);
 	         
 	        String result = target.request()
 	                    .accept(MediaType.TEXT_PLAIN)
 	                    .get(String.class);
		return result;
	}
	

}
