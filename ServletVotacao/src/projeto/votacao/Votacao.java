package projeto.votacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maven.example.projetocd.DataBase;
import maven.example.projetocd.ItemDocument;
import maven.example.projetocd.VoterDocument;

/**
 * Servlet implementation class Votacao
 */
@WebServlet("/Votacao")
public class Votacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Interface stub = null;
	public static String host = "localhost";
	public static int port = 1099;	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Votacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void getRegistryStub(String name) {
		try {
			Registry registry = LocateRegistry.getRegistry(host,port);
			stub = (Interface) registry.lookup(name);
		} catch (Exception e) {
			System.err.println("client exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRegistryStub("votacao");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + "Sistema de votacão" + "</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>" + "Área de Login:" + "</h1>");
		out.println("<br>");
		out.println("<label for=\"id\">Identificador:&emsp;&ensp;</label>");
		out.println("<input type=\"text\" id=\"id\" name=\"id\"><br><br>");
		out.println("<label for=\"pass\">Palavra-passe:&emsp;</label>");
		out.println("<input type=\"text\" id=\"pass\" name=\"pass\"><br><br>");
		out.println("<input type=\"submit\" value=\"Autenticar\">");
		out.println("<br>"); out.println("<br>");
		
		List<VoterDocument> utilizadoresRegistados = stub.utilizadoresRegistados();
		out.println("<h1>" + "Utilizadores registados:" + "</h1>");
		for(VoterDocument item : utilizadoresRegistados){
            out.print("Nome: "+item.get_id() +"\n");
        }
		if(utilizadoresRegistados.size()==0) {
           out.println("Não existem utilizadores registados");	
	      }
		out.println("<br>");out.println("<br>");
		
		List<ItemDocument> itemsVotacao = stub.itemsVotacao();
		out.println("<h1>" + "Itens em Votaćão:" + "</h1>");
		out.println("<br>");
		for(ItemDocument item : itemsVotacao){
            out.print("Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\n");
        }
		out.println("<br>"); out.println("<br>");
		
		out.println("</body>");
		out.println("</html>");	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
