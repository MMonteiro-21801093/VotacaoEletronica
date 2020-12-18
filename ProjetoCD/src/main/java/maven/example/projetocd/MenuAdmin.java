package maven.example.projetocd;
 
import java.util.List;
import java.util.Scanner;

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
			    break;
			    default:
			    System.out.println("Opção inválida");	
				}
			}	
			else {
				System.out.println("AUTH: false");
			} 
			
			
	}

	private static  void listaItemsVotacao() throws Exception {
		List<ItemDocument> itemsVotacao = DataBase.listaItemsVotacao();
	    for(ItemDocument item : itemsVotacao){
            System.out.print("Nome: "+item.getNome() +" Abrev: "+ item.getAbrev()+"\n");
        }
	}
}
