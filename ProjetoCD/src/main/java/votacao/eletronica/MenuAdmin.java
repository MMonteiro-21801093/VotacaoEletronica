package votacao.eletronica;
 
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.Period;
import com.cloudant.client.api.views.AllDocsResponse;

public class MenuAdmin {

	public static  void main(String[] args) throws Exception  {
		
		String teste ="";
		String user_id = ""; // user id
		String user_pwd = ""; // user password
		String base = "ou=prod,dc=example,dc=com";
		String user_rdn ="ou=admin"; // user RDN (relative distinguished names)
		String dn = "uid=" + user_id + "," + user_rdn + "," + base; // DN (distinguished name)
		//101010
		

		
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
				String opcaoSelecionada = scan.nextLine();
				System.out.println(opcaoSelecionada);
				switch(opcaoSelecionada) {
				case "1":
				listaItemsVotacao();
				break;
				case "2":
			    inicioDaVotacao();
			    break;
				case "3":
			  	duracaoDataSessao();
			    break;
				case "4":
			    tempoRestanteSessao();
			    break;
				case "5":
			     numeroTotalVotos();
			    break;
				case "6":
			    listarResultadosVotacao();
			    break;
				case "7":
			    itemGanhador();
			    break;
				case "8":
			    listaUtilizadoresRegistados();
			    break;
				case "9":
			    listaUtilizadoresSessao();
			    break;
				case "10":
		        associarUtilizador();
			    break;
				case "11":
			    removerUtilizador();
			    break;
			    default:
			    System.out.println("Opção inválida");	
				}
			}	
			else {
				System.out.println("AUTH: false");
			} 
			
			
	}
	private static void removerUtilizador() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Introduza o Id do utilizador:");
		   String user_id = scan.nextLine(); 
		   String result = DataBase.removerUtilizador(user_id);
	}
	private static void associarUtilizador() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Introduza o Id do utilizador:");
		   String user_id = scan.nextLine(); 
		   String result = DataBase.associarUtilizador(user_id);
	}
	
	private static void listaUtilizadoresSessao() throws Exception{
		List<VoterDocument> utilizadoresSessao = DataBase.listaUtilizadoresSessao();
	    for(VoterDocument item : utilizadoresSessao){
            System.out.print("Nome: "+item.get_id() +"\n");
        }
		if(utilizadoresSessao.size()==0) {
	      System.out.println("Não existem utilizadores na sessão");	
		}
	}
	private static void listaUtilizadoresRegistados() throws Exception{
	    System.out.println("listaUtilizadoresRegistados");	
		List<VoterDocument> utilizadoresRegistados = DataBase.listaUtilizadoresRegistados();
	    for(VoterDocument item : utilizadoresRegistados){
            System.out.print("Nome: "+item.get_id() +"\n");
        }
		if(utilizadoresRegistados.size()==0) {
           System.out.println("Não existem utilizadores registados");	
	      }
	}

	private static void itemGanhador() throws Exception {
		List<ResultadoEleicao> ganhador = DataBase.itemGanhador();
		int i = 1;
	      for(ResultadoEleicao resultado:ganhador) {
	    		 System.out.print(i+"º lugar "+ resultado.getNome() + "com "+ resultado.getVotos()+" votos" );
	    		 i++;
	      }
	}

	private static void listarResultadosVotacao() throws Exception{
		
		 List<ResultadoEleicao> listaResultadoEleicao = DataBase.listarResultadosVotacao();
			int i = 1;
		      for(ResultadoEleicao resultado:listaResultadoEleicao) {
		    		 System.out.print(i+"º lugar "+ resultado.getNome() + "com "+ resultado.getPercentagem() +" % dos votos \n" );
		    		 i++;
		      }
	}

	private static void numeroTotalVotos() throws Exception {	 
	 System.out.print("Número total de votos: " + DataBase.numeroTotalVotos());
	}

	private static void inicioDaVotacao() throws Exception {
		SessionDocument sessao = DataBase.inicioDaVotacao();
        System.out.print("A sessão tem inicio no dia "+ sessao.getDataInicio() +" às "+ sessao.getHoraInicio() +"\n");
	}
	
	private static void duracaoDataSessao() throws Exception {
		SessionDocument sessao = DataBase.inicioDaVotacao();
        System.out.print("Tem a duração de  "+ sessao.getDuracao()+" min\n");
	}
	
	private static void tempoRestanteSessao() throws Exception {
	    LocalDate dataCorrente  = LocalDate.now(); 
		SessionDocument sessao = DataBase.inicioDaVotacao();
		LocalDate dataSessao  = LocalDate.parse(sessao.getDataInicio());  
 
	    if ( dataSessao.compareTo(dataCorrente) < 0) {
	        verificaHoras(sessao);
	    }
	    if ( dataSessao.compareTo(dataCorrente)==0) {
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
}
