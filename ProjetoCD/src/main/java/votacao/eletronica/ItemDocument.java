package votacao.eletronica;

public class ItemDocument {
    private String _id = "";
    private String _rev = null;
    private String nome;
    private String abrev;
    private String tipo ="Item";
    public ItemDocument(String id,String abrev,String nome) {
      this._id = id;
      this.abrev = abrev;
      this.nome = nome;
    }
	 public String getDescription(){
		   return "ItemDocument";
		  }
    public String toString() {
      return "{ id: " + _id + ",\nrev: " + _rev + ",\ntipo: " +tipo + ",\nabrev: " + abrev + ",\nnome: " + nome + "\n}";
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    public String getTipo() {
    	return tipo;
    }

}
