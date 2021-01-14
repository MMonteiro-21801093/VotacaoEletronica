package votacao.eletronica;

public class ResultadoEleicao    {
String nome;
int votos=0;
double percentagem=0;

 
public ResultadoEleicao(String nome, long  votos) {
	this.nome = nome;
	this.votos = ((int) votos);
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public int getVotos() {
	return votos;
}
public void setVotos(int votos) {
	this.votos = votos;
}
 @Override
public boolean equals(Object obj) {
	   if (obj == null) {
           return false;
        }
        final ResultadoEleicao std = (ResultadoEleicao) obj;
        if (this == std) {
           return true;
        } else {
           return (this.votos == std.getVotos());
        }

}
public void calculaPercentagem(int quantidadeVotos) {
 
		 this.percentagem = (((double) this.votos)/quantidadeVotos)*100;
	 

 }
 public double getPercentagem() {
		return percentagem;
	}
 
}
