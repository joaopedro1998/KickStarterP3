package kickStarter;

public class Mensagens {
	private boolean recebido; //false = message received, true = message send
	private String texto;
	private UsuarioPadrao amigo;
	private boolean visualizou;
		
	public Mensagens(boolean recebido, String texto, UsuarioPadrao amigo, boolean visualizou) {
		super();
		this.recebido = recebido;
		this.texto = texto;
		this.amigo = amigo;
		this.visualizou = visualizou;
	}

	public void infoMensagens()
	{
		if(!this.recebido)
			System.out.print("Mensagem enviada por ");
		else
			System.out.print("Mensagem enviada para ");
		System.out.println(amigo.getNome() + ":");
		System.out.println(texto);
		System.out.println("==============================");
		
	}

	public boolean isRecebido() {
		return recebido;
	}

	public void setRecebido(boolean recebido) {
		this.recebido = recebido;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public UsuarioPadrao getAmigo() {
		return amigo;
	}

	public void setAmigo(UsuarioPadrao amigo) {
		this.amigo = amigo;
	}

	public boolean isVisualizou() {
		return visualizou;
	}

	public void setVisualizou(boolean visualizou) {
		this.visualizou = visualizou;
	}
	
	
}