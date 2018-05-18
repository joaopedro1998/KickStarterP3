package kickStarter;

import java.util.ArrayList;

public class UsuarioPadrao extends Usuario{

	private Localizacao local;
	private ArrayList<UsuarioPadrao> seguindo = new ArrayList<UsuarioPadrao>();
	private Cartao cartao;
	private ArrayList<Projeto> projetosCriados = new ArrayList<Projeto>();
	private ArrayList<Projeto> projetosFavoritos = new ArrayList<Projeto>();
	private ArrayList<Mensagens> mensagens = new ArrayList<Mensagens>();
	private ArrayList<Doacao> doacoes = new ArrayList<Doacao>();
	
	public UsuarioPadrao(String nome, String senha, String email, Localizacao local) {
		super(nome, senha, email);
		this.local = local;
		this.doacoes = null;
		this.mensagens = null;
		this.projetosFavoritos = null;
		this.projetosCriados = null;
	}
	
	
	public ArrayList<Projeto> getProjetosCriados() {
		return projetosCriados;
	}


	public void setProjetosCriados(Projeto projetosCriados) {
		this.projetosCriados.add(projetosCriados);
	}


	public ArrayList<Doacao> getDoacoes() {
		return doacoes;
	}


	public void setDoacoes(Doacao doacoes) {
		this.doacoes.add(doacoes);
	}


	public ArrayList<Mensagens> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Mensagens mensagens) {
		this.mensagens.add(mensagens);
	}
	
	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public Localizacao getLocal() {
		return local;
	}

	public void setLocal(Localizacao local) {
		this.local = local;
	}

	public ArrayList<UsuarioPadrao> getSeguindo() {
		return seguindo;
	}

	public void setSeguindo(UsuarioPadrao seguindo) {
		this.seguindo.add(seguindo);
	}

	public ArrayList<Projeto> getProjetosFavoritos() {
		return projetosFavoritos;
	}

	public void setProjetosFavoritos(Projeto projetoFavorito) {
		this.projetosFavoritos.add(projetoFavorito);
	}	
	
	
}
