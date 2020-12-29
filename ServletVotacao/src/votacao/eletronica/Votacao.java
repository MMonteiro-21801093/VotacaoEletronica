package votacao.eletronica;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Votacao
 */
@WebServlet("/Votacao")
public class Votacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Interface stub = null;
	public static String host = "localhost";
	public static int port = 1099;	/**
    /**
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    getRegistryStub("votacaoEletronica");
	 
				String base = "ou=prod,dc=example,dc=com";
				String user_rdn ="ou=people"; // user RDN (relative distinguished names)
				String dn = "uid=" + "" + "," + user_rdn + "," + base; // DN (distinguished name)
				String uname = request.getParameter("uname");
				String password = request.getParameter("password");
			    if(uname.equals("101010")) {
			    	 user_rdn ="ou=admin";
			    }
				 dn = "uid=" + uname + "," + user_rdn + "," + base; // DN (distinguished name)
				 
			 
				    if(stub.validaUtilizador(dn, password).equals("OK") && uname.equals("101010")) {
				      response.sendRedirect(request.getContextPath()+"/OpcoesAdmin.jsp");
				      }
				    if(stub.validaUtilizador(dn, password).equals("OK") && !uname.equals("101010")) {
					    response.sendRedirect(request.getContextPath()+"/OpcoesVotante.jsp");
				       }
	
 
	 
	}

}
