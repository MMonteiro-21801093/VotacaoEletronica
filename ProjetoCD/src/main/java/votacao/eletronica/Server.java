package votacao.eletronica;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;
 
public class Server implements Interface  {
	
public Server() {}

	private static Registry newRegistry(int port) throws RemoteException{
		LocateRegistry.createRegistry(port);
		Registry reg = LocateRegistry.getRegistry(port);
		return reg;
	}
    public static void main(String args[]) {
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
	public String listaItemsVotacao(){
		List<ItemDocument> itemsVotacao;
		String items ="";
		try {
			itemsVotacao = DataBase.listaItemsVotacao();
			
		    for(ItemDocument item : itemsVotacao){
		    	items+="Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\r\n";
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return items;
	}
	public String inicioDaVotacao()  throws Exception{
		SessionDocument sessao = DataBase.inicioDaVotacao();
		return "A sessão tem inicio no dia "+ sessao.getDataInicio() +" às "+ sessao.getHoraInicio() ;
	}
	public String duracaoDataSessao()  throws Exception{
		SessionDocument sessao = DataBase.inicioDaVotacao();
		return"Tem a duração de  "+ sessao.getDuracao();
	}

	public String tempoRestanteSessao() throws Exception {
	    LocalDate dataCorrente  = LocalDate.now(); 
		SessionDocument sessao = DataBase.inicioDaVotacao();
		LocalDate dataSessao  = LocalDate.parse(sessao.getDataInicio());  
		 String result ="";
	    if ( dataSessao.compareTo(dataCorrente) < 0) {
	    	result =  verificaHoras(sessao);
	    }
	    if ( dataSessao.compareTo(dataCorrente)==0) {
	      	result =   verificaHoras(sessao); 	
	    }
	    if ( dataSessao.compareTo(dataCorrente) > 0) {
	    	   result = "A votação não ainda iniciou\n";
	    	  Period period = Period.between(dataCorrente, dataSessao); 
	           if(period.getMonths() > 1) {
	        	   result+="Faltam  "+ period.getMonths() + " Meses e " + period.getDays() + " dias\n";
	    	    }
	            if(period.getMonths() ==0) {
	               result+="Faltam " + period.getDays() + " dias\n";
	    	    }
	   
	    }
    return result;
	}

	private  String verificaHoras(SessionDocument sessao) {
         Date horaCorrente = new Date();
		   String wfield[] = sessao.getHoraInicio().split(":");
		   int horaSessao = Integer.parseInt(wfield[0]); 
		   int minSessao = Integer.parseInt(wfield[1]); 

		   if(horaSessao>horaCorrente.getHours()) {
		      return "Faltam " + (horaSessao -horaCorrente.getHours())  + " horas e "+(minSessao - horaCorrente.getMinutes())  + " minutos para o inicio da sessão\n";
		   }
		   
	 
		   if(horaSessao<=horaCorrente.getHours()) {
			   if(minSessao>horaCorrente.getMinutes()) {
				   return"Faltam 0 horas e "+(minSessao - horaCorrente.getMinutes())  + " minutos para o inicio da sessão\n";
			   }
			   if(minSessao<=horaCorrente.getMinutes()) {
				   return"A votação já iniciou\n";
			   }  
			 }
		   return"";
}
	
	public String numeroTotalVotos()  throws Exception{
		return"Número total de votos: " + DataBase.numeroTotalVotos();
	}
	public String listarResultadosVotacao()  throws Exception{
		 List<ResultadoEleicao> listaResultadoEleicao = DataBase.listarResultadosVotacao();
			int i = 1;
			String res ="";
		      for(ResultadoEleicao resultado:listaResultadoEleicao) {
		    	  res+=i+"º lugar "+ resultado.getNome() + "com "+ resultado.getPercentagem() +" % dos votos \r\n" ;
		    		 i++;
		      }
		return res;
	}
	public String itemGanhador()  throws Exception{
		List<ResultadoEleicao> ganhador = DataBase.itemGanhador();
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
		resultado="listaUtilizadoresRegistados\n";	
			List<VoterDocument> utilizadoresRegistados = DataBase.listaUtilizadoresRegistados();
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
		List<VoterDocument> utilizadoresSessao = DataBase.listaUtilizadoresSessao();
	    for(VoterDocument item : utilizadoresSessao){
	    	resultado+="Nome: "+item.get_id() +"\n";
        }
		if(utilizadoresSessao.size()==0) {
			resultado="Não existem utilizadores na sessão";	
		}
		return resultado;
	}
	public String associarUtilizador(String idUser)  throws Exception{
		return DataBase.associarUtilizador(idUser);
	}
	public String removerUtilizador(String idUser)  throws Exception{
		return DataBase.removerUtilizador(idUser);
	}
	public String obtemDescricaoItemVotado(String idItem)  throws Exception{
		return DataBase.obtemDescricaoItemVotado(idItem);
	}
	public String votarNoItemSelecionado(String idItem,String userId)  throws Exception{
		return DataBase.votarNoItemSelecionado(idItem,userId);
	}
}
