package votacao.eletronica;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpcoesAdmin
 */
@WebServlet("/OpcoesAdmin")
public class OpcoesAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Interface stub = null;
	public static String host = "localhost";//192.168.56.101
	public static int port = 1099;	/**
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpcoesAdmin() {
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
		   RequestDispatcher rd = request.getRequestDispatcher("OpcoesAdmin.jsp");
		   String action = request.getParameter("action");
           if("listar itens em votação".equals(action)) {
               request.setAttribute("resultado",  stub.listaItemsVotacao());
             }
           if("listar resultados de votação (%)".equals(action)) {
               request.setAttribute("resultado",  stub.listarResultadosVotacao());
             }
           if("listar utilizadores registados".equals(action)) {
               request.setAttribute("resultado",  stub.listaUtilizadoresRegistados());
             }
           if("Log In".equals(action)) {
        	   rd = request.getRequestDispatcher("LogIn.jsp");
             }
        
           rd.forward(request, response);
		 
	}

}
