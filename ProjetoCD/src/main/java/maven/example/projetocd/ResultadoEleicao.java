package maven.example.projetocd;

public class ResultadoEleicao {
String nome;
long votos;
public ResultadoEleicao(String nome, long votos) {
	this.nome = nome;
	this.votos = votos;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public long getVotos() {
	return votos;
}
public void setVotos(long votos) {
	this.votos = votos;
}

}
