package kickStarter;

public abstract class ProjetoAbstractClass {
	protected float valorAtual;
	protected UsuarioPadrao criador;
	protected String nome;
	protected String descricao;
	protected int tempoLimite;
	protected float valorMinimo;
	protected Categoria categoria;
	
	public abstract void getAllInfos();
	public abstract boolean jaFinanciado();
	public abstract float getValorAtual();
	public abstract void setValorAtual(float valorAtual);
	public abstract Categoria getCategoria();
	public abstract void setCategoria(Categoria categoria);
	public abstract String getNome();
	public abstract void setNome(String nome);
	public abstract String getDescricao();
	public abstract void setDescricao(String descricao);
	public abstract int getTempoLimite();
	public abstract void setTempoLimite(int tempoLimite);
	public abstract float getValorMinimo();
	public abstract void setValorMinimo(float valorMinimo);
	public abstract UsuarioPadrao getCriador();
	public abstract void setCriador(UsuarioPadrao criador);
	
}
