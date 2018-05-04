package kickStarter;

import java.util.ArrayList;

public class UsuarioPadrao extends Usuario{

	private Localizacao local;
	private ArrayList<UsuarioPadrao> seguidores = new ArrayList<UsuarioPadrao>();
	private Cartao cartao;
	
	public UsuarioPadrao(String nome, String senha, String email, Localizacao local) {
		super(nome, senha, email);
		this.local = local;
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

	public ArrayList<UsuarioPadrao> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(UsuarioPadrao seguidor) {
		this.seguidores.add(seguidor);
	}	
	
	
}
