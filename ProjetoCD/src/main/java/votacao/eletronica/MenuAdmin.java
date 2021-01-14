package votacao.eletronica;
 
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;

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
		
		listaItemsVotacao();
		
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
		   String result = DBBackEnd.removerUtilizador(user_id);
	}
	private static void associarUtilizador() throws Exception {
	       Scanner scan = new Scanner(System.in);
		   System.out.println("Introduza o Id do utilizador:");
		   String user_id = scan.nextLine(); 
		   String result = DBBackEnd.associarUtilizador(user_id);
	}
	
	private static void listaUtilizadoresSessao() throws Exception{
		List<VoterDocument> utilizadoresSessao = DBBackEnd.listaUtilizadoresSessao();
	    for(VoterDocument item : utilizadoresSessao){
            System.out.print("Nome: "+item.get_id() +"\n");
        }
		if(utilizadoresSessao.size()==0) {
	      System.out.println("Não existem utilizadores na sessão");	
		}
	}
	private static void listaUtilizadoresRegistados() throws Exception{
	    System.out.println("listaUtilizadoresRegistados");	
		List<VoterDocument> utilizadoresRegistados = DBBackEnd.listaUtilizadoresRegistados();
	    for(VoterDocument item : utilizadoresRegistados){
            System.out.print("Nome: "+item.get_id() +"\n");
        }
		if(utilizadoresRegistados.size()==0) {
           System.out.println("Não existem utilizadores registados");	
	      }
	}

	private static void itemGanhador() throws Exception {
		List<ResultadoEleicao> ganhador = DBBackEnd.itemGanhador();
		int i = 1;
	      for(ResultadoEleicao resultado:ganhador) {
	    		 System.out.print(i+"º lugar "+ resultado.getNome() + "com "+ resultado.getVotos()+" votos \n" );
	    		 i++;
	      }
	}

	private static void listarResultadosVotacao() throws Exception{
		
		 List<ResultadoEleicao> listaResultadoEleicao = DBBackEnd.listarResultadosVotacao();
			int i = 1;
		      for(ResultadoEleicao resultado:listaResultadoEleicao) {
		    		 System.out.print(i+"º lugar "+ resultado.getNome() + "com "+ resultado.getPercentagem() +" % dos votos \n" );
		    		 i++;
		      }
	}

	private static void numeroTotalVotos() throws Exception {	 
	 System.out.print("Número total de votos: " + DBBackEnd.numeroTotalVotos());
	}

	private static void inicioDaVotacao() throws Exception {
		SessionDocument sessao = DBBackEnd.inicioDaVotacao();
        System.out.print("A sessão tem inicio no dia "+ sessao.getDataInicio() +" às "+ sessao.getHoraInicio() +"\n");
	}
	
	private static void duracaoDataSessao() throws Exception {
		SessionDocument sessao = DBBackEnd.inicioDaVotacao();
        System.out.print("Tem a duração de  "+ sessao.getDuracao()+" min\n");
	}
	
	private static void tempoRestanteSessao() throws Exception {
	   LocalDate localCorrente  = LocalDate.now(); 
		SessionDocument sessao = DBBackEnd.inicioDaVotacao();
		LocalDate dataSessao  = LocalDate.parse(sessao.getDataInicio()); 
		String wfield[] = sessao.getHoraInicio().split(":");
		   int horaSessao = Integer.parseInt(wfield[0]); 
		   int minSessao = Integer.parseInt(wfield[1]); 
		   
		 
		Calendar calSessao = Calendar.getInstance();
		calSessao.set(Calendar.HOUR_OF_DAY,horaSessao);
		calSessao.set(Calendar.MINUTE,minSessao);
		calSessao.set(Calendar.DAY_OF_MONTH,dataSessao.getDayOfMonth());
		calSessao.set(Calendar.MONTH,dataSessao.getMonthValue()-1);
		calSessao.set(Calendar.YEAR,dataSessao.getYear());
		Date dtSessao = calSessao.getTime();
		Date dataCorrente = new Date();
	
		   
	    if ( dtSessao.compareTo(dataCorrente) <= 0) {//Se a data de sessao é inferior à data corrente
 
	    	Date dtSessaoIncremento = new Date(); //now
	    	dtSessaoIncremento = DateUtils.addMinutes(dtSessao , sessao.getDuracao()); //add minute
	 
	        if (dtSessaoIncremento.compareTo(dataCorrente) < 0) {
	            System.out.print("A sessão de votação já terminou\n");
	        }else {
	        	long diffInMillies = Math.abs(dataCorrente.getTime() - dtSessaoIncremento.getTime());
	            long diff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
	            System.out.print("Sessão iniciada, faltam " + diff +" minutos para a terminar\n");
	        }
	     
	    }

	    if ( dtSessao.compareTo(dataCorrente) > 0) {
	    	  System.out.print("A votação não ainda iniciou\n");
	    	  String dt1 = String.valueOf(dataSessao.getDayOfMonth())+"-"+String.valueOf(dataSessao.getMonthValue())+"-"+String.valueOf(dataSessao.getYear());
	    	  dt1+=" "+String.valueOf(dtSessao.getHours())+":"+String.valueOf(dtSessao.getMinutes())+":"+String.valueOf(dtSessao.getSeconds());
	    	  
	    	  String dt2 = String.valueOf(localCorrente.getDayOfMonth())+"-"+String.valueOf(localCorrente.getMonthValue())+"-"+String.valueOf(localCorrente.getYear());
	    	  dt2+=" "+String.valueOf(dataCorrente.getHours())+":"+String.valueOf(dataCorrente.getMinutes())+":"+String.valueOf(dataCorrente.getSeconds());
	    	  
	    	  findDifference(dt2.toString(), dt1.toString());
	   
	    }
    
	}
	private static void	findDifference(String start_date,  String end_date) { 
           


 // SimpleDateFormat converts the 
 // string format to date object 
 SimpleDateFormat sdf 
     = new SimpleDateFormat( 
         "dd-MM-yyyy HH:mm:ss"); 

 // Try Block 
 try { 

     // parse method is used to parse 
     // the text from a string to 
     // produce the date 
     Date d1 = sdf.parse(start_date); 
     Date d2 = sdf.parse(end_date); 

     // Calucalte time difference 
     // in milliseconds 
     long difference_In_Time 
         = d2.getTime() - d1.getTime(); 

     // Calucalte time difference in 
     // seconds, minutes, hours, years, 
     // and days 
     long difference_In_Seconds 
         = (difference_In_Time 
            / 1000) 
           % 60; 

     long difference_In_Minutes 
         = (difference_In_Time 
            / (1000 * 60)) 
           % 60; 

     long difference_In_Hours 
         = (difference_In_Time 
            / (1000 * 60 * 60)) 
           % 24; 

     long difference_In_Years 
         = (difference_In_Time 
            / (1000l * 60 * 60 * 24 * 365)); 

     long difference_In_Days 
         = (difference_In_Time 
            / (1000 * 60 * 60 * 24)) 
           % 365; 

     // Print the date difference in 
     // years, in days, in hours, in 
     // minutes, and in seconds 

     System.out.print( 
         "Difference "
         + "between two dates is: "); 

     System.out.println( 
         difference_In_Years 
         + " years, "
         + difference_In_Days 
         + " days, "
         + difference_In_Hours 
         + " hours, "
         + difference_In_Minutes 
         + " minutes, "
         + difference_In_Seconds 
         + " seconds"); 
 } 

 // Catch the Exception 
 catch (Exception e) { 
     e.printStackTrace(); 
 } 
} 
	private static void verificaHoras(SessionDocument sessao) {
 	           Date horaCorrente = new Date();
			   String wfield[] = sessao.getHoraInicio().split(":");
			   int horaSessao = Integer.parseInt(wfield[0]); 
			   int minSessao = Integer.parseInt(wfield[1]); 
			   System.out.println("horaSessao "+ horaSessao + "\n");	
			   System.out.println("horaCorrente "+ horaCorrente.getHours() + "\n");
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
		try {
		List<ItemDocument> itemsVotacao = DBBackEnd.listaItemsVotacao();
	    for(ItemDocument item : itemsVotacao){
            System.out.print("Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\n");
        }
		} catch (Exception e) {
		    System.out.print("Não foi possivel executar a ação selecionada\n");
			}
		
		
	}
}