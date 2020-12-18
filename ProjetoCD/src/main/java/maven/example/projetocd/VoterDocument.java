package maven.example.projetocd;

public class VoterDocument {
    private String _id = "";
    private String _rev = null;
    private Boolean acesso = false;
    private String itemVoto="";
    private String tipo ="Votantes";
    public VoterDocument(String id) {
      this._id = id;
    }

    public String toString() {
      return "{ id: " + _id + ",\nrev: " + _rev + ",\ntipo: " +tipo + ",\nacesso: " + acesso + ",\nitemVoto: " + itemVoto + "\n}";
    }
}
