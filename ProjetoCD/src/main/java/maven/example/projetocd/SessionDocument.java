package maven.example.projetocd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SessionDocument {
    private String _id = "9999";
    private Date dataInicio = StringToDate("2020-12-18");
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }
}
