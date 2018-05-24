package kickStarter;

public class Projeto extends ProjetoAbstractClass{
	
	
	public Projeto(UsuarioPadrao criador, String nome, String descricao, int tempoLimite, float valorMinimo, Categoria categoria) {
		super();
		this.criador = criador;
		this.nome = nome;
		this.valorAtual = 0;
		this.descricao = descricao;
		this.tempoLimite = tempoLimite;
		this.valorMinimo = valorMinimo;
		this.categoria = categoria;
	}
	
	public void getAllInfos() {
		System.out.println("Esses sao os dados do projeto " + this.nome);
		System.out.println("Criador " + this.criador.getNome());
		System.out.println("Descricao: " + this.descricao);
		System.out.println("Tempo Limite: " + this.tempoLimite + " dias");
		System.out.println("Categoria: " + this.categoria.getNomeDaCategoria());
		System.out.println("Valor necessario: " + this.valorMinimo);
		System.out.println("Valor arrecadado: " + this.valorAtual);
	}
	
	public boolean jaFinanciado() {
		if(this.valorMinimo < this.valorAtual) {
			return true; 
		}
		return false;
	}
	public float getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(float valorAtual) {
		this.valorAtual += valorAtual;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTempoLimite() {
		return tempoLimite;
	}
	public void setTempoLimite(int tempoLimite) {
		this.tempoLimite = tempoLimite;
	}
	public float getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public UsuarioPadrao getCriador() {
		return criador;
	}
	public void setCriador(UsuarioPadrao criador) {
		this.criador = criador;
	}
	
	
}
