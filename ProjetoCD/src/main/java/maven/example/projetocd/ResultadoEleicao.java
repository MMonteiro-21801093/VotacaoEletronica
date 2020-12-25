package maven.example.projetocd;

public class ResultadoEleicao {
String nome;
int votos;
double percentagem;

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
 public void calculaPercentagem(int quantidadeVotos) {
	 this.percentagem = (this.percentagem/quantidadeVotos)*100;
 }
 public double getPercentagem() {
		return percentagem;
	}
}
