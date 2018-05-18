package kickStarter;

public class Cartao {
	private String numeroDoCartao;
	private String codigoDeSeguranca;
	public Cartao(String numeroDoCartao, String codigoDeSeguranca) {
		super();
		this.numeroDoCartao = numeroDoCartao;
		this.codigoDeSeguranca = codigoDeSeguranca;
	}
	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}
	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}
	public String getCodigoDeSeguranca() {
		return codigoDeSeguranca;
	}
	public void setCodigoDeSeguranca(String codigoDeSeguranca) {
		this.codigoDeSeguranca = codigoDeSeguranca;
	}
	
}
