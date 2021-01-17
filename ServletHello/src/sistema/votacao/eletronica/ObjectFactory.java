
package sistema.votacao.eletronica;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sistema.votacao.eletronica package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RemoverUtilizadorResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "removerUtilizadorResponse");
    private final static QName _TempoRestanteSessao_QNAME = new QName("http://eletronica.votacao.sistema/", "tempoRestanteSessao");
    private final static QName _DuracaoDataSessao_QNAME = new QName("http://eletronica.votacao.sistema/", "duracaoDataSessao");
    private final static QName _VotarNoItemSelecionadoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "votarNoItemSelecionadoResponse");
    private final static QName _ObtemDescricaoItemVotadoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "obtemDescricaoItemVotadoResponse");
    private final static QName _ListaUtilizadoresRegistados_QNAME = new QName("http://eletronica.votacao.sistema/", "listaUtilizadoresRegistados");
    private final static QName _InicioDaVotacaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "inicioDaVotacaoResponse");
    private final static QName _ValidaUtilizador_QNAME = new QName("http://eletronica.votacao.sistema/", "validaUtilizador");
    private final static QName _RemoverUtilizador_QNAME = new QName("http://eletronica.votacao.sistema/", "removerUtilizador");
    private final static QName _NumeroTotalVotos_QNAME = new QName("http://eletronica.votacao.sistema/", "numeroTotalVotos");
    private final static QName _ListaUtilizadoresRegistadosResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "listaUtilizadoresRegistadosResponse");
    private final static QName _VotarNoItemSelecionado_QNAME = new QName("http://eletronica.votacao.sistema/", "votarNoItemSelecionado");
    private final static QName _NumeroTotalVotosResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "numeroTotalVotosResponse");
    private final static QName _DuracaoDataSessaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "duracaoDataSessaoResponse");
    private final static QName _ListarResultadosVotacaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "listarResultadosVotacaoResponse");
    private final static QName _AssociarUtilizadorResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "associarUtilizadorResponse");
    private final static QName _InicioDaVotacao_QNAME = new QName("http://eletronica.votacao.sistema/", "inicioDaVotacao");
    private final static QName _ListaItemsVotacao_QNAME = new QName("http://eletronica.votacao.sistema/", "listaItemsVotacao");
    private final static QName _TempoRestanteSessaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "tempoRestanteSessaoResponse");
    private final static QName _ListaUtilizadoresSessao_QNAME = new QName("http://eletronica.votacao.sistema/", "listaUtilizadoresSessao");
    private final static QName _ItemGanhadorResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "itemGanhadorResponse");
    private final static QName _ValidaUtilizadorResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "validaUtilizadorResponse");
    private final static QName _ItemGanhador_QNAME = new QName("http://eletronica.votacao.sistema/", "itemGanhador");
    private final static QName _Exception_QNAME = new QName("http://eletronica.votacao.sistema/", "Exception");
    private final static QName _ListaItemsVotacaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "listaItemsVotacaoResponse");
    private final static QName _ListaUtilizadoresSessaoResponse_QNAME = new QName("http://eletronica.votacao.sistema/", "listaUtilizadoresSessaoResponse");
    private final static QName _AssociarUtilizador_QNAME = new QName("http://eletronica.votacao.sistema/", "associarUtilizador");
    private final static QName _ListarResultadosVotacao_QNAME = new QName("http://eletronica.votacao.sistema/", "listarResultadosVotacao");
    private final static QName _ObtemDescricaoItemVotado_QNAME = new QName("http://eletronica.votacao.sistema/", "obtemDescricaoItemVotado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sistema.votacao.eletronica
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DuracaoDataSessaoResponse }
     * 
     */
    public DuracaoDataSessaoResponse createDuracaoDataSessaoResponse() {
        return new DuracaoDataSessaoResponse();
    }

    /**
     * Create an instance of {@link NumeroTotalVotos }
     * 
     */
    public NumeroTotalVotos createNumeroTotalVotos() {
        return new NumeroTotalVotos();
    }

    /**
     * Create an instance of {@link ListaUtilizadoresRegistadosResponse }
     * 
     */
    public ListaUtilizadoresRegistadosResponse createListaUtilizadoresRegistadosResponse() {
        return new ListaUtilizadoresRegistadosResponse();
    }

    /**
     * Create an instance of {@link RemoverUtilizador }
     * 
     */
    public RemoverUtilizador createRemoverUtilizador() {
        return new RemoverUtilizador();
    }

    /**
     * Create an instance of {@link VotarNoItemSelecionado }
     * 
     */
    public VotarNoItemSelecionado createVotarNoItemSelecionado() {
        return new VotarNoItemSelecionado();
    }

    /**
     * Create an instance of {@link NumeroTotalVotosResponse }
     * 
     */
    public NumeroTotalVotosResponse createNumeroTotalVotosResponse() {
        return new NumeroTotalVotosResponse();
    }

    /**
     * Create an instance of {@link ListaUtilizadoresRegistados }
     * 
     */
    public ListaUtilizadoresRegistados createListaUtilizadoresRegistados() {
        return new ListaUtilizadoresRegistados();
    }

    /**
     * Create an instance of {@link InicioDaVotacaoResponse }
     * 
     */
    public InicioDaVotacaoResponse createInicioDaVotacaoResponse() {
        return new InicioDaVotacaoResponse();
    }

    /**
     * Create an instance of {@link ValidaUtilizador }
     * 
     */
    public ValidaUtilizador createValidaUtilizador() {
        return new ValidaUtilizador();
    }

    /**
     * Create an instance of {@link TempoRestanteSessao }
     * 
     */
    public TempoRestanteSessao createTempoRestanteSessao() {
        return new TempoRestanteSessao();
    }

    /**
     * Create an instance of {@link RemoverUtilizadorResponse }
     * 
     */
    public RemoverUtilizadorResponse createRemoverUtilizadorResponse() {
        return new RemoverUtilizadorResponse();
    }

    /**
     * Create an instance of {@link VotarNoItemSelecionadoResponse }
     * 
     */
    public VotarNoItemSelecionadoResponse createVotarNoItemSelecionadoResponse() {
        return new VotarNoItemSelecionadoResponse();
    }

    /**
     * Create an instance of {@link ObtemDescricaoItemVotadoResponse }
     * 
     */
    public ObtemDescricaoItemVotadoResponse createObtemDescricaoItemVotadoResponse() {
        return new ObtemDescricaoItemVotadoResponse();
    }

    /**
     * Create an instance of {@link DuracaoDataSessao }
     * 
     */
    public DuracaoDataSessao createDuracaoDataSessao() {
        return new DuracaoDataSessao();
    }

    /**
     * Create an instance of {@link ListaItemsVotacaoResponse }
     * 
     */
    public ListaItemsVotacaoResponse createListaItemsVotacaoResponse() {
        return new ListaItemsVotacaoResponse();
    }

    /**
     * Create an instance of {@link AssociarUtilizador }
     * 
     */
    public AssociarUtilizador createAssociarUtilizador() {
        return new AssociarUtilizador();
    }

    /**
     * Create an instance of {@link ListarResultadosVotacao }
     * 
     */
    public ListarResultadosVotacao createListarResultadosVotacao() {
        return new ListarResultadosVotacao();
    }

    /**
     * Create an instance of {@link ObtemDescricaoItemVotado }
     * 
     */
    public ObtemDescricaoItemVotado createObtemDescricaoItemVotado() {
        return new ObtemDescricaoItemVotado();
    }

    /**
     * Create an instance of {@link ListaUtilizadoresSessaoResponse }
     * 
     */
    public ListaUtilizadoresSessaoResponse createListaUtilizadoresSessaoResponse() {
        return new ListaUtilizadoresSessaoResponse();
    }

    /**
     * Create an instance of {@link ItemGanhador }
     * 
     */
    public ItemGanhador createItemGanhador() {
        return new ItemGanhador();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ItemGanhadorResponse }
     * 
     */
    public ItemGanhadorResponse createItemGanhadorResponse() {
        return new ItemGanhadorResponse();
    }

    /**
     * Create an instance of {@link ValidaUtilizadorResponse }
     * 
     */
    public ValidaUtilizadorResponse createValidaUtilizadorResponse() {
        return new ValidaUtilizadorResponse();
    }

    /**
     * Create an instance of {@link ListaUtilizadoresSessao }
     * 
     */
    public ListaUtilizadoresSessao createListaUtilizadoresSessao() {
        return new ListaUtilizadoresSessao();
    }

    /**
     * Create an instance of {@link ListarResultadosVotacaoResponse }
     * 
     */
    public ListarResultadosVotacaoResponse createListarResultadosVotacaoResponse() {
        return new ListarResultadosVotacaoResponse();
    }

    /**
     * Create an instance of {@link AssociarUtilizadorResponse }
     * 
     */
    public AssociarUtilizadorResponse createAssociarUtilizadorResponse() {
        return new AssociarUtilizadorResponse();
    }

    /**
     * Create an instance of {@link InicioDaVotacao }
     * 
     */
    public InicioDaVotacao createInicioDaVotacao() {
        return new InicioDaVotacao();
    }

    /**
     * Create an instance of {@link ListaItemsVotacao }
     * 
     */
    public ListaItemsVotacao createListaItemsVotacao() {
        return new ListaItemsVotacao();
    }

    /**
     * Create an instance of {@link TempoRestanteSessaoResponse }
     * 
     */
    public TempoRestanteSessaoResponse createTempoRestanteSessaoResponse() {
        return new TempoRestanteSessaoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverUtilizadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "removerUtilizadorResponse")
    public JAXBElement<RemoverUtilizadorResponse> createRemoverUtilizadorResponse(RemoverUtilizadorResponse value) {
        return new JAXBElement<RemoverUtilizadorResponse>(_RemoverUtilizadorResponse_QNAME, RemoverUtilizadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempoRestanteSessao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "tempoRestanteSessao")
    public JAXBElement<TempoRestanteSessao> createTempoRestanteSessao(TempoRestanteSessao value) {
        return new JAXBElement<TempoRestanteSessao>(_TempoRestanteSessao_QNAME, TempoRestanteSessao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuracaoDataSessao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "duracaoDataSessao")
    public JAXBElement<DuracaoDataSessao> createDuracaoDataSessao(DuracaoDataSessao value) {
        return new JAXBElement<DuracaoDataSessao>(_DuracaoDataSessao_QNAME, DuracaoDataSessao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VotarNoItemSelecionadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "votarNoItemSelecionadoResponse")
    public JAXBElement<VotarNoItemSelecionadoResponse> createVotarNoItemSelecionadoResponse(VotarNoItemSelecionadoResponse value) {
        return new JAXBElement<VotarNoItemSelecionadoResponse>(_VotarNoItemSelecionadoResponse_QNAME, VotarNoItemSelecionadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtemDescricaoItemVotadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "obtemDescricaoItemVotadoResponse")
    public JAXBElement<ObtemDescricaoItemVotadoResponse> createObtemDescricaoItemVotadoResponse(ObtemDescricaoItemVotadoResponse value) {
        return new JAXBElement<ObtemDescricaoItemVotadoResponse>(_ObtemDescricaoItemVotadoResponse_QNAME, ObtemDescricaoItemVotadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUtilizadoresRegistados }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaUtilizadoresRegistados")
    public JAXBElement<ListaUtilizadoresRegistados> createListaUtilizadoresRegistados(ListaUtilizadoresRegistados value) {
        return new JAXBElement<ListaUtilizadoresRegistados>(_ListaUtilizadoresRegistados_QNAME, ListaUtilizadoresRegistados.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InicioDaVotacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "inicioDaVotacaoResponse")
    public JAXBElement<InicioDaVotacaoResponse> createInicioDaVotacaoResponse(InicioDaVotacaoResponse value) {
        return new JAXBElement<InicioDaVotacaoResponse>(_InicioDaVotacaoResponse_QNAME, InicioDaVotacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaUtilizador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "validaUtilizador")
    public JAXBElement<ValidaUtilizador> createValidaUtilizador(ValidaUtilizador value) {
        return new JAXBElement<ValidaUtilizador>(_ValidaUtilizador_QNAME, ValidaUtilizador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoverUtilizador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "removerUtilizador")
    public JAXBElement<RemoverUtilizador> createRemoverUtilizador(RemoverUtilizador value) {
        return new JAXBElement<RemoverUtilizador>(_RemoverUtilizador_QNAME, RemoverUtilizador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumeroTotalVotos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "numeroTotalVotos")
    public JAXBElement<NumeroTotalVotos> createNumeroTotalVotos(NumeroTotalVotos value) {
        return new JAXBElement<NumeroTotalVotos>(_NumeroTotalVotos_QNAME, NumeroTotalVotos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUtilizadoresRegistadosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaUtilizadoresRegistadosResponse")
    public JAXBElement<ListaUtilizadoresRegistadosResponse> createListaUtilizadoresRegistadosResponse(ListaUtilizadoresRegistadosResponse value) {
        return new JAXBElement<ListaUtilizadoresRegistadosResponse>(_ListaUtilizadoresRegistadosResponse_QNAME, ListaUtilizadoresRegistadosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VotarNoItemSelecionado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "votarNoItemSelecionado")
    public JAXBElement<VotarNoItemSelecionado> createVotarNoItemSelecionado(VotarNoItemSelecionado value) {
        return new JAXBElement<VotarNoItemSelecionado>(_VotarNoItemSelecionado_QNAME, VotarNoItemSelecionado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumeroTotalVotosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "numeroTotalVotosResponse")
    public JAXBElement<NumeroTotalVotosResponse> createNumeroTotalVotosResponse(NumeroTotalVotosResponse value) {
        return new JAXBElement<NumeroTotalVotosResponse>(_NumeroTotalVotosResponse_QNAME, NumeroTotalVotosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DuracaoDataSessaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "duracaoDataSessaoResponse")
    public JAXBElement<DuracaoDataSessaoResponse> createDuracaoDataSessaoResponse(DuracaoDataSessaoResponse value) {
        return new JAXBElement<DuracaoDataSessaoResponse>(_DuracaoDataSessaoResponse_QNAME, DuracaoDataSessaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResultadosVotacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listarResultadosVotacaoResponse")
    public JAXBElement<ListarResultadosVotacaoResponse> createListarResultadosVotacaoResponse(ListarResultadosVotacaoResponse value) {
        return new JAXBElement<ListarResultadosVotacaoResponse>(_ListarResultadosVotacaoResponse_QNAME, ListarResultadosVotacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociarUtilizadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "associarUtilizadorResponse")
    public JAXBElement<AssociarUtilizadorResponse> createAssociarUtilizadorResponse(AssociarUtilizadorResponse value) {
        return new JAXBElement<AssociarUtilizadorResponse>(_AssociarUtilizadorResponse_QNAME, AssociarUtilizadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InicioDaVotacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "inicioDaVotacao")
    public JAXBElement<InicioDaVotacao> createInicioDaVotacao(InicioDaVotacao value) {
        return new JAXBElement<InicioDaVotacao>(_InicioDaVotacao_QNAME, InicioDaVotacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaItemsVotacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaItemsVotacao")
    public JAXBElement<ListaItemsVotacao> createListaItemsVotacao(ListaItemsVotacao value) {
        return new JAXBElement<ListaItemsVotacao>(_ListaItemsVotacao_QNAME, ListaItemsVotacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TempoRestanteSessaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "tempoRestanteSessaoResponse")
    public JAXBElement<TempoRestanteSessaoResponse> createTempoRestanteSessaoResponse(TempoRestanteSessaoResponse value) {
        return new JAXBElement<TempoRestanteSessaoResponse>(_TempoRestanteSessaoResponse_QNAME, TempoRestanteSessaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUtilizadoresSessao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaUtilizadoresSessao")
    public JAXBElement<ListaUtilizadoresSessao> createListaUtilizadoresSessao(ListaUtilizadoresSessao value) {
        return new JAXBElement<ListaUtilizadoresSessao>(_ListaUtilizadoresSessao_QNAME, ListaUtilizadoresSessao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemGanhadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "itemGanhadorResponse")
    public JAXBElement<ItemGanhadorResponse> createItemGanhadorResponse(ItemGanhadorResponse value) {
        return new JAXBElement<ItemGanhadorResponse>(_ItemGanhadorResponse_QNAME, ItemGanhadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidaUtilizadorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "validaUtilizadorResponse")
    public JAXBElement<ValidaUtilizadorResponse> createValidaUtilizadorResponse(ValidaUtilizadorResponse value) {
        return new JAXBElement<ValidaUtilizadorResponse>(_ValidaUtilizadorResponse_QNAME, ValidaUtilizadorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemGanhador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "itemGanhador")
    public JAXBElement<ItemGanhador> createItemGanhador(ItemGanhador value) {
        return new JAXBElement<ItemGanhador>(_ItemGanhador_QNAME, ItemGanhador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaItemsVotacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaItemsVotacaoResponse")
    public JAXBElement<ListaItemsVotacaoResponse> createListaItemsVotacaoResponse(ListaItemsVotacaoResponse value) {
        return new JAXBElement<ListaItemsVotacaoResponse>(_ListaItemsVotacaoResponse_QNAME, ListaItemsVotacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaUtilizadoresSessaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listaUtilizadoresSessaoResponse")
    public JAXBElement<ListaUtilizadoresSessaoResponse> createListaUtilizadoresSessaoResponse(ListaUtilizadoresSessaoResponse value) {
        return new JAXBElement<ListaUtilizadoresSessaoResponse>(_ListaUtilizadoresSessaoResponse_QNAME, ListaUtilizadoresSessaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociarUtilizador }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "associarUtilizador")
    public JAXBElement<AssociarUtilizador> createAssociarUtilizador(AssociarUtilizador value) {
        return new JAXBElement<AssociarUtilizador>(_AssociarUtilizador_QNAME, AssociarUtilizador.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResultadosVotacao }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "listarResultadosVotacao")
    public JAXBElement<ListarResultadosVotacao> createListarResultadosVotacao(ListarResultadosVotacao value) {
        return new JAXBElement<ListarResultadosVotacao>(_ListarResultadosVotacao_QNAME, ListarResultadosVotacao.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtemDescricaoItemVotado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eletronica.votacao.sistema/", name = "obtemDescricaoItemVotado")
    public JAXBElement<ObtemDescricaoItemVotado> createObtemDescricaoItemVotado(ObtemDescricaoItemVotado value) {
        return new JAXBElement<ObtemDescricaoItemVotado>(_ObtemDescricaoItemVotado_QNAME, ObtemDescricaoItemVotado.class, null, value);
    }

}
