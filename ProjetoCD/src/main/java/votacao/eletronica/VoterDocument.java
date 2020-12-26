package votacao.eletronica;

public class VoterDocument {
    private String _id = "";
    private String _rev = null;
    private Boolean acesso = false;
    private String itemVoto="";
    private String tipo ="Votantes";
    public VoterDocument(String id) {
      this._id = id;
    }

    public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_rev() {
		return _rev;
	}

	public void set_rev(String _rev) {
		this._rev = _rev;
	}

	public Boolean getAcesso() {
		return acesso;
	}

	public void setAcesso(Boolean acesso) {
		this.acesso = acesso;
	}

	public String getItemVoto() {
		return itemVoto;
	}

	public void setItemVoto(String itemVoto) {
		this.itemVoto = itemVoto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
      return "{ id: " + _id + ",\nrev: " + _rev + ",\ntipo: " +tipo + ",\nacesso: " + acesso + ",\nitemVoto: " + itemVoto + "\n}";
    }
}
