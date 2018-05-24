package kickStarter;

public class Doacao {
	private Projeto projeto;
	private float valorDoado;	
	public Doacao(Projeto projeto, float valorDoado) {
		super();
		this.projeto = projeto;
		this.valorDoado = valorDoado;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	public float getValorDoado() {
		return valorDoado;
	}
	public void setValorDoado(float valorDoado) {
		this.valorDoado = valorDoado;
	}
	
	
}
