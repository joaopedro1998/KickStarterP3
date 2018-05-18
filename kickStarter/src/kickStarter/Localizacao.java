package kickStarter;

import java.util.ArrayList;

public class Localizacao {
	private String nomeDoLocal;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
	
	public Localizacao(String nome) {
		this.nomeDoLocal = nome;
	}

	public String getNomeDoLocal() {
		return nomeDoLocal;
	}

	public void setNomeDoLocal(String nomeDoLocal) {
		this.nomeDoLocal = nomeDoLocal;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuario) {
		this.usuarios.add(usuario);
	}

	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Projeto projeto) {
		this.projetos.add(projeto);
	}
	
	
}
