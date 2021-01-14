package votacao.eletronica;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;

import votacao.eletronica.*;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Document;
import com.cloudant.client.api.views.AllDocsRequestBuilder;
import com.cloudant.client.api.views.AllDocsResponse;
import com.cloudant.client.org.lightcouch.Response;


public class Server implements Interface  {
	
public Server() {}

	private static Registry newRegistry(int port) throws RemoteException{
		LocateRegistry.createRegistry(port);
		Registry reg = LocateRegistry.getRegistry(port);
		return reg;
	}
    public static void main(String args[])   {
            int port = 1099;

        try {
        	Server obj = new Server();
        	Interface  stub = (Interface) UnicastRemoteObject.exportObject(obj, 0);
           Registry registry = newRegistry(port);
            registry.bind("votacaoEletronica", stub);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
	public String validaUtilizador(String dn, String user_pwd)  {
		if (LDAPUtils.auth(dn, user_pwd)) {
			if (LDAPUtils.auth(dn, user_pwd)) {
				return "OK";
			}else {
				return "password inválida";
			}
		}	
		else {
			return "utilizador inexistente";
		} 
		
	}
	
 
	public String listaItemsVotacao() throws Exception{
	   List<ItemDocument> itemsVotacao;
	 
	   String items ="";
	   itemsVotacao = DBBackEnd.listaItemsVotacao();
			
		    for(ItemDocument item : itemsVotacao){
		      	items+="Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\r\n";
	      }
 
	
		return items;
	}
	public String inicioDaVotacao()  throws Exception{
		SessionDocument sessao = DBBackEnd.inicioDaVotacao();
		return "A sessão tem inicio no dia "+ sessao.getDataInicio() +" às "+ sessao.getHoraInicio() ;
	}
	public String duracaoDataSessao()  throws Exception{
		SessionDocument sessao = DBBackEnd.inicioDaVotacao();
		return"Tem a duração de  "+ sessao.getDuracao() +" minutos";
	}

	public String tempoRestanteSessao() throws Exception {
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
		Date dtCorrente = new Date();
		
		
		 String result ="";
		   
	    if ( dtSessao.compareTo(dtCorrente) <= 0) {//Se a data de sessao é inferior ou ingual à data corrente

	    	Date dtSessaoIncremento = new Date(); //now
	    	dtSessaoIncremento = DateUtils.addMinutes(dtSessao , sessao.getDuracao()); //add minute
	 
	        if (dtSessaoIncremento.compareTo(dtCorrente) < 0) {
	           return"A sessão de votação já terminou \n";
	        }else {
	        	long diffInMillies = Math.abs(dtCorrente.getTime() - dtSessaoIncremento.getTime());
	            long tempoExpirar = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
	            return"Sessão iniciada, faltam " + tempoExpirar +" minutos para a terminar \n";
	        }
	     
	        }
 
	    	 
	    	  String strDtSessao = String.valueOf(dataSessao.getDayOfMonth())
	    			  +"-"+String.valueOf(dataSessao.getMonthValue())
	    			  +"-"+String.valueOf(dataSessao.getYear());
	    	  
	    	  strDtSessao+=" "+String.valueOf(dtSessao.getHours())
	    	  +":"+String.valueOf(dtSessao.getMinutes())
	    	  +":"+String.valueOf(dtSessao.getSeconds());
	    	  
	    	  String strDtCorrente = String.valueOf(localCorrente.getDayOfMonth())
	    			  +"-"+String.valueOf(localCorrente.getMonthValue())
	    			  +"-"+String.valueOf(localCorrente.getYear());
	    	  
	    	  strDtCorrente+=" "+String.valueOf(dtCorrente.getHours())
	    	  +":"+String.valueOf(dtCorrente.getMinutes())
	    	  +":"+String.valueOf(dtCorrente.getSeconds());
	    	  

	 
    return findDifference(strDtCorrente.toString(), strDtSessao.toString());
	}
	
	
private  String findDifference(String start_date,  String end_date) { 
 
 SimpleDateFormat sdf 
     = new SimpleDateFormat( 
         "dd-MM-yyyy HH:mm:ss"); 
String result ="";
 
 try { 

 
     Date d1 = sdf.parse(start_date); 
     Date d2 = sdf.parse(end_date); 
 
     long difference_In_Time 
         = d2.getTime() - d1.getTime(); 
 
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
 
     result= "Faltam " +  difference_In_Days + " dias, "  + difference_In_Hours + "horas, " 
     + difference_In_Minutes  + " minutos, "+ difference_In_Seconds  + " segundos para o inicio da sessão";
     
 } 

 
 catch (Exception e) { 
	 return "Não foi possivel verificar o tempo que falta para o inicio da sessão";
 }
 
return result; 
} 

	
	public String numeroTotalVotos()  throws Exception{
		return"Número total de votos: " + DBBackEnd.numeroTotalVotos() +"\n";
	}
	public String listarResultadosVotacao()  throws Exception{
		DBBackEnd db = new DBBackEnd();
		 List<ResultadoEleicao> listaResultadoEleicao = db.listarResultadosVotacao();
			int i = 1;
			String res ="";
		      for(ResultadoEleicao resultado:listaResultadoEleicao) {
		    	  res+=i+"º lugar "+ resultado.getNome() + "com "+ resultado.getPercentagem() +" % dos votos \r\n" ;
		    		 i++;
		      }
		return res;
	}
	public String itemGanhador()  throws Exception{
		List<ResultadoEleicao> ganhador = DBBackEnd.itemGanhador();
		int i = 1;
		String res ="";
	      for(ResultadoEleicao resultado:ganhador) {
	    	  res+=i+"º lugar "+ resultado.getNome() + "com "+ resultado.getVotos()+" votos \r\n";
	    	   i++;
	      }
	      return res;
	}
	public String listaUtilizadoresRegistados()  throws Exception{
		String resultado ="";
		resultado="";	
			List<VoterDocument> utilizadoresRegistados = DBBackEnd.listaUtilizadoresRegistados();
		    for(VoterDocument item : utilizadoresRegistados){
		    	resultado+="Nome: "+item.get_id() +"\r\n";
	        }
			if(utilizadoresRegistados.size()==0) {
				resultado="Não existem utilizadores registados";	
		      }
		return resultado;
	}
	public String listaUtilizadoresSessao()  throws Exception{
		String resultado ="";
		List<VoterDocument> utilizadoresSessao = DBBackEnd.listaUtilizadoresSessao();
	    for(VoterDocument item : utilizadoresSessao){
	    	resultado+="Nome: "+item.get_id() +"\n";
        }
		if(utilizadoresSessao.size()==0) {
			resultado="Não existem utilizadores na sessão";	
		}
		return resultado;
	}
	public String associarUtilizador(String idUser)  throws Exception{
		return DBBackEnd.associarUtilizador(idUser);
	}
	public String removerUtilizador(String idUser)  throws Exception{
		return DBBackEnd.removerUtilizador(idUser);
	}
	public String obtemDescricaoItemVotado(String idItem)  throws Exception{
		return DBBackEnd.obtemDescricaoItemVotado(idItem);
	}
	public String votarNoItemSelecionado(String idItem,String userId)  throws Exception{
		return DBBackEnd.votarNoItemSelecionado(idItem,userId);
	}
	public String votanteAtivo(String id)  throws Exception{
		return DBBackEnd.votanteAtivo(id);
	}
}
