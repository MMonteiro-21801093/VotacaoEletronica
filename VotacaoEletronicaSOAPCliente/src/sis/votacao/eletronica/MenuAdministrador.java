package sis.votacao.eletronica;

import java.io.File;
import java.lang.Exception;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

import javax.xml.namespace.QName;
import votacao.eletronica.*;
 
public class MenuAdministrador {
    private static final QName SERVICE_NAME = new QName("http://eletronica.votacao/", "VotacaoSoapWSService");
    static URL wsdlURL = VotacaoSoapWSService.WSDL_LOCATION;
    static VotacaoSoapWSService ss = new VotacaoSoapWSService(wsdlURL, SERVICE_NAME);
    static   VotacaoSoapWS port = ss.getVotacaoSoapWSPort(); 
    public static void main(String[] args)   throws java.lang.Exception {
    
		String user_id = ""; // user id
		String user_pwd = ""; // user password
		String base = "ou=prod,dc=example,dc=com";
		String user_rdn ="ou=admin"; // user RDN (relative distinguished names)
		String dn = "uid=" + user_id + "," + user_rdn + "," + base; // DN (distinguished name)
		String opcaoSelecionada ="";
 
	       Scanner scan = new Scanner(System.in);
		   System.out.println("login:");
		     user_id = scan.nextLine();  // Read user input
		    System.out.println("password:");
              user_pwd = scan.nextLine();  // Read user input
		     dn = "uid=" + user_id + "," + user_rdn + "," + base; 
		
        do {
			if (port.validaUtilizador(dn, user_pwd).equals("OK")) {
				System.out.println(" ");
				System.out.println("MENU ADMINISTRADOR");
				System.out.println("0 - Menu inicial");
				System.out.println("1 - Listar itens em votação");
				System.out.println("2 - Início da sessão");
				System.out.println("3 - Duração da sessão");
				System.out.println("4 - Tempo restante de votação");
				System.out.println("5 - Número total de votos");
				System.out.println("6 - Listar resultados de votação (%)");
				System.out.println("7 - Item ganhador");
				System.out.println("8 - listar utilizadores registados");
				System.out.println("9 - listar utilizadores da sessão");
				System.out.println("10 - associar utilizador");
				System.out.println("11 - remover utilizador");
				System.out.println("99 - Sair");
			    opcaoSelecionada = scan.nextLine();
	
				switch(opcaoSelecionada) {
				case "1":
				listaItemsVotacao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
				break;
				case "2":
			    inicioDaVotacao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "3":
			  	duracaoDataSessao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "4":
			    tempoRestanteSessao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "5":
			     numeroTotalVotos();
			 	System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "6":
			    listarResultadosVotacao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "7":
			    itemGanhador();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "8":
			    listaUtilizadoresRegistados();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "9":
			    listaUtilizadoresSessao();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "10":
		        associarUtilizador();
		    	System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "11":
			    removerUtilizador();
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
			    break;
				case "99":
			    System.out.println("A sair");  
			    System.out.println("Cliente Desconectado..");   
			    break;
			    default:
			    System.out.println("Opção inválida");
				System.out.println("Prima ENTER para continuar");
			    opcaoSelecionada = scan.nextLine();
				}
			}	
			else {
				System.out.println("Autenticação inválida");
				System.out.println(" ");
			    scan = new Scanner(System.in);
			    System.out.println("login:");
			    user_id = scan.nextLine();  // Read user input
			    System.out.println("password:");
		        user_pwd = scan.nextLine();  // Read user input
			    dn = "uid=" + user_id + "," + user_rdn + "," + base; 
	 
			} 
			
        }while(!opcaoSelecionada.equals("99"));
    }
	private static void listaItemsVotacao() throws Exception_Exception {
	 
			System.out.println(port.listaItemsVotacao());
	 
	}
	private static void removerUtilizador() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Introduza o Id do utilizador:");
		   String user_id = scan.nextLine(); 
		   String result = port.removerUtilizador(user_id);
		   System.out.println(result);
	}
	private static void associarUtilizador() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Introduza o Id do utilizador:");
		   String user_id = scan.nextLine(); 
		   String result = port.associarUtilizador(user_id);
		   System.out.println(result);
	}
	private static void listaUtilizadoresSessao() throws Exception{
		System.out.println(port.listaUtilizadoresSessao());
	}
	private static void listaUtilizadoresRegistados() throws Exception{
		System.out.println(port.listaUtilizadoresRegistados());
	}

	private static void itemGanhador() throws Exception {
		System.out.println(port.itemGanhador());
	}
	private static void listarResultadosVotacao() throws Exception{
		System.out.println(port.listarResultadosVotacao());
	}

	private static void numeroTotalVotos() throws Exception {	 
		System.out.println(port.numeroTotalVotos());
	}

	private static void inicioDaVotacao() throws Exception {
		System.out.println(port.inicioDaVotacao());
	}
	
	private static void duracaoDataSessao() throws Exception {
		System.out.println(port.duracaoDataSessao());
	}
	private static void tempoRestanteSessao() throws Exception {
		System.out.println(port.tempoRestanteSessao());
	}
	
}
