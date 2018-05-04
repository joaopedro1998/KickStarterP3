package kickStarter;

public class Projeto {
	private float valorAtual;
	private Usuario criador;
	private String nome;
	private String descricao;
	private int tempoLimite;
	private float valorMinimo;
	private Categoria categoria;
	
	public Projeto(Usuario criador, String nome, String descricao, int tempoLimite, float valorMinimo, Categoria categoria) {
		super();
		this.setCriador(criador);
		this.nome = nome;
		this.valorAtual = 0;
		this.descricao = descricao;
		this.tempoLimite = tempoLimite;
		this.valorMinimo = valorMinimo;
		this.categoria = categoria;
	}
	
	public void getAllInfos() {
		System.out.println("Criador " + this.criador.getNome());
		System.out.println("Nome do Projeto "+this.nome);
		System.out.println("Descricao: " + this.descricao);
		System.out.println("Tempo Limite: " + this.tempoLimite + " dias");
		System.out.println("Categoria: " + this.categoria.getNomeDaCategoria());
		
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
	public Usuario getCriador() {
		return criador;
	}
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}
	
	
}
