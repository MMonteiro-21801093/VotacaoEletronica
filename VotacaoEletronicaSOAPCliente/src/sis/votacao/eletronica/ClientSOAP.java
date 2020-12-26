package sis.votacao.eletronica;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import votacao.eletronica.*;

import votacao.eletronica.VotacaoSoapWS;
import votacao.eletronica.VotacaoSoapWSService;
 
public class ClientSOAP {
    private static final QName SERVICE_NAME = new QName("http://eletronica.votacao/", "VotacaoSoapWSService");
    public static void main(String[] args)   throws java.lang.Exception {
        URL wsdlURL = VotacaoSoapWSService.WSDL_LOCATION;
  
        VotacaoSoapWSService ss = new VotacaoSoapWSService(wsdlURL, SERVICE_NAME);
        VotacaoSoapWS port = ss.getVotacaoSoapWSPort();  
        java.lang.String _listaUtilizadoresRegistados__return = port.listaItemsVotacao();
		System.out.println("listaUtilizadoresRegistados.result=" + _listaUtilizadoresRegistados__return);
    }

}
