
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package votacao.eletronica;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.13
 * 2021-01-16T00:47:00.823Z
 * Generated source version: 2.6.13
 * 
 */

@javax.jws.WebService(
                      serviceName = "VotacaoSoapWSService",
                      portName = "VotacaoSoapWSPort",
                      targetNamespace = "http://eletronica.votacao/",
                      wsdlLocation = "http://localhost:8080/VotacaoSOAP/services/VotacaoSoapWSPort?wsdl",
                      endpointInterface = "votacao.eletronica.VotacaoSoapWS")
                      
public class VotacaoSoapWSImpl implements VotacaoSoapWS {

    private static final Logger LOG = Logger.getLogger(VotacaoSoapWSImpl.class.getName());

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#numeroTotalVotos(*
     */
    public java.lang.String numeroTotalVotos() throws Exception_Exception    { 
        LOG.info("Executing operation numeroTotalVotos");
        try {
            java.lang.String _return = "_return1161513464";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#itemGanhador(*
     */
    public java.lang.String itemGanhador() throws Exception_Exception    { 
        LOG.info("Executing operation itemGanhador");
        try {
            java.lang.String _return = "_return1030967162";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#removerUtilizador(java.lang.String  arg0 )*
     */
    public java.lang.String removerUtilizador(java.lang.String arg0) throws Exception_Exception    { 
        LOG.info("Executing operation removerUtilizador");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return76175156";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    public java.lang.String votanteAtivo(java.lang.String arg0) throws Exception_Exception    { 
        LOG.info("Executing operation votanteAtivo");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return1397765493";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

	/* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#votarNoItemSelecionado(java.lang.String  arg0 ,)java.lang.String  arg1 )*
     */
    public java.lang.String votarNoItemSelecionado(java.lang.String arg0,java.lang.String arg1) throws Exception_Exception    { 
        LOG.info("Executing operation votarNoItemSelecionado");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            java.lang.String _return = "_return305001369";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#teste(*
     */
    public void teste() { 
        LOG.info("Executing operation teste");
        try {
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#associarUtilizador(java.lang.String  arg0 )*
     */
    public java.lang.String associarUtilizador(java.lang.String arg0) throws Exception_Exception    { 
        LOG.info("Executing operation associarUtilizador");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-1695580730";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#listarResultadosVotacao(*
     */
    public java.lang.String listarResultadosVotacao() throws Exception_Exception    { 
        LOG.info("Executing operation listarResultadosVotacao");
        try {
            java.lang.String _return = "_return1990078884";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#obtemDescricaoItemVotado(java.lang.String  arg0 )*
     */
    public java.lang.String obtemDescricaoItemVotado(java.lang.String arg0) throws Exception_Exception    { 
        LOG.info("Executing operation obtemDescricaoItemVotado");
        System.out.println(arg0);
        try {
            java.lang.String _return = "_return-1989068274";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#tempoRestanteSessao(*
     */
    public java.lang.String tempoRestanteSessao() throws Exception_Exception    { 
        LOG.info("Executing operation tempoRestanteSessao");
        try {
            java.lang.String _return = "_return-1494257132";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#inicioDaVotacao(*
     */
    public java.lang.String inicioDaVotacao() throws Exception_Exception    { 
        LOG.info("Executing operation inicioDaVotacao");
        try {
            java.lang.String _return = "_return245624495";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#listaItemsVotacao(*
     */
    public java.lang.String listaItemsVotacao() throws Exception_Exception    { 
      //  LOG.info("Executing operation listaItemsVotacao");
        try {
            java.lang.String _return = "_return198333851";
            return _return;
        } catch (java.lang.Exception ex) {
           // ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#duracaoDataSessao(*
     */
    public java.lang.String duracaoDataSessao() throws Exception_Exception    { 
        LOG.info("Executing operation duracaoDataSessao");
        try {
            java.lang.String _return = "_return-1500665030";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#validaUtilizador(java.lang.String  arg0 ,)java.lang.String  arg1 )*
     */
    public java.lang.String validaUtilizador(java.lang.String arg0,java.lang.String arg1) throws Exception_Exception    { 
        LOG.info("Executing operation validaUtilizador");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            java.lang.String _return = "_return601295509";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#listaUtilizadoresRegistados(*
     */
    public java.lang.String listaUtilizadoresRegistados() throws Exception_Exception    { 
        LOG.info("Executing operation listaUtilizadoresRegistados");
        try {
            java.lang.String _return = "_return-1314839667";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

    /* (non-Javadoc)
     * @see votacao.eletronica.VotacaoSoapWS#listaUtilizadoresSessao(*
     */
    public java.lang.String listaUtilizadoresSessao() throws Exception_Exception    { 
        LOG.info("Executing operation listaUtilizadoresSessao");
        try {
            java.lang.String _return = "_return-1146277629";
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new Exception_Exception("Exception...");
    }

}
