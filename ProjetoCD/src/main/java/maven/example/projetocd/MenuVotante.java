package maven.example.projetocd;
 
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.Period;
import com.cloudant.client.api.views.AllDocsResponse;

public class MenuVotante {

	public static  void main(String[] args) throws Exception  {
	
				String user_id = ""; // user id
		String user_pwd = ""; // user password
		String base = "ou=prod,dc=example,dc=com";
		String user_rdn ="ou=admin"; // user RDN (relative distinguished names)
		String dn = "uid=" + user_id + "," + user_rdn + "," + base; // DN (distinguished name)
		//2122116
			
	     Scanner scan = new Scanner(System.in);
		   System.out.println("login:");
		     user_id = scan.nextLine();  // Read user input
		    System.out.println("password:");
              user_pwd = scan.nextLine();  // Read user input
		   dn = "uid=" + user_id + "," + user_rdn + "," + base; 
		   
	 	// validate dn
			if (LDAPUtils.validDn(dn)) {
				System.out.println("DN: true");
			}	
			else {
				LDAPUtils.closeConnection();
				System.out.println("DN: false");
				System.exit(-1);
			}

			// auth
			if (LDAPUtils.auth(dn, user_pwd)) {
				System.out.println("MENU VOTANTE");
				System.out.println("0 - Menu inicial");
				System.out.println("1 - Listar itens em votação");
				System.out.println("2 - Tempo restante da votação");
				System.out.println("3 - Votar");
				System.out.println("4 - Número total de votos");
				System.out.println("5 - Listar resultados de votação (%)");
				System.out.println("6 - Item ganhador");
				System.out.println("99 - Sair");
				String opcaoSelecionada = scan.nextLine();
				System.out.println(opcaoSelecionada);
				
				switch(opcaoSelecionada) {
				case "1":
				listaItemsVotacao();
				break;
				case "2":
			    tempoRestanteSessao();
			    break;
				case "3":
			     votar();
			    break;
				case "4":
				numeroTotalVotos();
			    break;
				case "5":
				listarResultadosVotacao();
			    break;
				case "6":
			    itemGanhador();
			    break;
			    default:
			    System.out.println("Opção inválida");	
				}
			}	
			else {
				System.out.println("AUTH: false");
			} 			
	}

	private static void itemGanhador() throws Exception {
		List<String> ganhador = DataBase.itemGanhador();
	
	}

	private static void listarResultadosVotacao() {
		
		
	}

	private static void numeroTotalVotos() throws Exception {	 
	 System.out.print("Número total de votos: " + DataBase.numeroTotalVotos());
	}
	
	private static void tempoRestanteSessao() throws Exception {
	    LocalDate dataCorrente  = LocalDate.now(); 
		SessionDocument sessao = DataBase.inicioDaVotacao();
		LocalDate dataSessao  = LocalDate.parse(sessao.getDataInicio());  
 
	    if (( dataSessao.compareTo(dataCorrente) < 0) || ( dataSessao.compareTo(dataCorrente)==0)){
	        verificaHoras(sessao);
	    }
	    if ( dataSessao.compareTo(dataCorrente) > 0) {
	    	  System.out.print("A votação não ainda iniciou\n");
	    	  Period period = Period.between(dataCorrente, dataSessao); 
	           if(period.getMonths() > 1) {
	    	 	    System.out.print("Faltam  "+ period.getMonths() + " Meses e " + period.getDays() + " dias\n");
	    	    }
	            if(period.getMonths() ==0) {
	    	 	    System.out.print("Faltam " + period.getDays() + " dias\n");
	    	    }	   
	    }  
	}
 
	private static void verificaHoras(SessionDocument sessao) {
 	           Date horaCorrente = new Date();
			   String wfield[] = sessao.getHoraInicio().split(":");
			   int horaSessao = Integer.parseInt(wfield[0]); 
			   int minSessao = Integer.parseInt(wfield[1]); 
			   
			   if(horaSessao>horaCorrente.getHours()) {
			      System.out.print("Faltam " + (horaSessao -horaCorrente.getHours())  + " horas e "+(minSessao - horaCorrente.getMinutes())  + " minutos para o inicio da sessão\n");
			   }
			   
		 
			   if(horaSessao<=horaCorrente.getHours()) {
				   if(minSessao>horaCorrente.getMinutes()) {
					   System.out.print("Faltam 0 horas e "+(minSessao - horaCorrente.getMinutes())  + " minutos para o inicio da sessão\n");
				   }
				   if(minSessao<=horaCorrente.getMinutes()) {
					   System.out.print("A votação já iniciou\n");
				   }  
				 }
	}



	private static  void listaItemsVotacao() throws Exception {
		List<ItemDocument> itemsVotacao = DataBase.listaItemsVotacao();
	    for(ItemDocument item : itemsVotacao){
            System.out.print("Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\n");
        }
	}
	
	private static void votar() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Voto? ");
		   String opt = scan.nextLine(); 
		   //TODO		 
	}
}
