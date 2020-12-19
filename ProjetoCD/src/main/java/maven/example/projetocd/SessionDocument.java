package maven.example.projetocd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionDocument {

    public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

 

 

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    private String _id = "9999";
	private String dataInicio = "2020-12-23";
    private String horaInicio= "13:30";
    private int duracao = 9999;
    private String tipo ="Sessao";
    public SessionDocument() {
    }

    public String toString() {
      return "{ id: " + _id + ",\ndataInicio: " + dataInicio.toString() + ",\nhoraInicio: " + horaInicio + ",\nduracao: "+ duracao + ",\ntipo: " + tipo + "\n}";
    }
    public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
}
