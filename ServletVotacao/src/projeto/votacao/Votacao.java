package projeto.votacao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

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
	public static int port = 1099;
	String methodName = null;
	String pageTitle = null;
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
		getRegistryStub(methodName);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = stub.getDate();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + pageTitle + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + msg + "</h1>");
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