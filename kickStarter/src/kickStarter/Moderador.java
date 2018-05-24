package kickStarter;

import java.util.ArrayList;

public class Moderador extends Usuario{
	private ArrayList<Projeto> autenticarProjetos = new ArrayList<Projeto>();
	
	public Moderador(String nome, String senha, String email) {
		super(nome, senha, email);
	}

	public Projeto getProjeto() {
		return autenticarProjetos.get(0);
	}
	
	public void deleteProjeto() {
		this.autenticarProjetos.remove(0);
	}
	
	public void setAutenticarProjetos(Projeto autenticarProjetos) {
		this.autenticarProjetos.add(autenticarProjetos);
	}
	
	public int quantidadeDeProjetos() {
		return this.autenticarProjetos.size();
	}
	
}
