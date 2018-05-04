package kickStarter;

import java.util.ArrayList;

public class Categoria {
	private String nomeDaCategoria;
	private ArrayList<Projeto> projetos = new ArrayList<Projeto>();
	
	public Categoria(String nomeDaCategoria) {
		super();
		this.nomeDaCategoria = nomeDaCategoria;
	}
	
	public String getNomeDaCategoria() {
		return nomeDaCategoria;
	}
	public void setNomeDaCategoria(String nomeDaCategoria) {
		this.nomeDaCategoria = nomeDaCategoria;
	}
	public ArrayList<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(Projeto projeto) {
		this.projetos.add(projeto);
	}
	
	
}
