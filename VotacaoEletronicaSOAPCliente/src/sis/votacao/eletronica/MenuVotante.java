package sis.votacao.eletronica;

import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;

 
import votacao.eletronica.Exception_Exception;
import votacao.eletronica.VotacaoSoapWS;
import votacao.eletronica.VotacaoSoapWSService;

public class MenuVotante {
    private static final QName SERVICE_NAME = new QName("http://eletronica.votacao/", "VotacaoSoapWSService");
    static URL wsdlURL = VotacaoSoapWSService.WSDL_LOCATION;
    static VotacaoSoapWSService ss = new VotacaoSoapWSService(wsdlURL, SERVICE_NAME);
    static   VotacaoSoapWS port = ss.getVotacaoSoapWSPort(); 
	public static void main(String[] args)  throws java.lang.Exception {
	  	String teste ="";
			String user_id = ""; // user id
			String user_pwd = ""; // user password
			String base = "ou=prod,dc=example,dc=com";
			String user_rdn ="ou=people"; // user RDN (relative distinguished names)
			String dn = "uid=" + user_id + "," + user_rdn + "," + base; // DN (distinguished name)
			String opcaoSelecionada ="";
	   //2111188
		       Scanner scan = new Scanner(System.in);
			   System.out.println("login:");
			     user_id = scan.nextLine();  // Read user input
			    System.out.println("password:");
	              user_pwd = scan.nextLine();  // Read user input
			     dn = "uid=" + user_id + "," + user_rdn + "," + base; 

			     
			     do {
					  if (port.validaUtilizador(dn, user_pwd).equals("OK")) {
							System.out.println(" ");
							System.out.println("MENU VOTANTE");
							System.out.println("0 - Menu inicial");
							System.out.println("1 - Listar itens em votação");
							System.out.println("2 - Tempo restante da votação");
							System.out.println("3 - Votar");
							System.out.println("4 - Número total de votos");
							System.out.println("5 - Listar resultados de votação (%)");
							System.out.println("6 - Item ganhador");
							System.out.println("99 - Sair");
						    opcaoSelecionada = scan.nextLine();
				
							switch(opcaoSelecionada) {
							case "1":
								listaItemsVotacao();
								System.out.println("Prima ENTER para continuar");
							    opcaoSelecionada = scan.nextLine();
								break;
							case "2":
							    tempoRestanteSessao();
								System.out.println("Prima ENTER para continuar");
							    opcaoSelecionada = scan.nextLine();
								break;
							case "3":
								votar(user_id);
								System.out.println("Prima ENTER para continuar");
							    opcaoSelecionada = scan.nextLine();
								break;
							case "4":
								numeroTotalVotos();
								System.out.println("Prima ENTER para continuar");
							    opcaoSelecionada = scan.nextLine();
								break;
							case "5":
								listarResultadosVotacao();
								System.out.println("Prima ENTER para continuar");
							    opcaoSelecionada = scan.nextLine();
								break;
							case "6":
							    itemGanhador();
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
	private static void votar(String user_id) throws Exception {
	       Scanner scan = new Scanner(System.in);
	       String opt="";
	       String codigo="";
	       String itemVotado ="";
	       String tempo = port.tempoRestanteSessao();
	  
	       if(tempo.startsWith("Sessão iniciada")) {
	    	    String possoVotar = port.votanteAtivo(user_id);
	            
	             if(possoVotar.equals("OK")) {
	            	  do{
	         	         System.out.println("Digite o código do voto?\n ");
	         	         codigo = scan.nextLine();
	         			 itemVotado= port.obtemDescricaoItemVotado(codigo);
	         		     System.out.print("Confirma o voto em "+ itemVotado+" ? (S/N)\n");
	         		     opt = scan.nextLine();
	         	      }while(!opt.equals("S"));
	         	       port.votarNoItemSelecionado(codigo,user_id);
	         	       System.out.print("Obrigado, votou em  "+ itemVotado+" \n");
	             }else {
	         	       System.out.print( possoVotar+" \n"); 
	             }
	       }else {
	    	   System.out.print(tempo+" \n");
	       }
       
	      
	       
	}
	private static void listaItemsVotacao() throws Exception_Exception {
		System.out.println(port.listaItemsVotacao());
		
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
 
	private static void tempoRestanteSessao() throws Exception {
		System.out.println(port.tempoRestanteSessao());
	}
	
}
