package kickStarter;

import org.junit.jupiter.api.Test;

public class UnitTests {
	
	@Test
	public void criarCartao() {
		Cartao cartao = new Cartao("123","123");
		assert(cartao != null);
	}
	
	@Test
	public void criarCategoria() {
		Categoria categoria = new Categoria("test");
		assert(categoria != null);
	}
	
	@Test
	public void criarUsuario() {
		Usuario usuario = new Usuario("test","test","test");
		assert(usuario != null);
	}
	
	@Test
	public void criarUsuarioPadrao() {
		UsuarioPadrao usuario = new UsuarioPadrao("test","test","test",new Localizacao("test"));
		assert(usuario != null);
	}
	
	@Test
	public void criarProjeto() {
		Projeto projeto = new Projeto(new UsuarioPadrao("test","test","test",new Localizacao("test")),"test","test",2,(float)2,new Categoria("test"));
		assert(projeto != null);
	}
	
	@Test
	public void criarDoacao() {
		Doacao doacao = new Doacao(new Projeto(new UsuarioPadrao("test","test","test",new Localizacao("test")),"test","test",2,(float)2,new Categoria("test")),1231);
		assert(doacao != null);
	}
	
	@Test
	public void criarLocalizacao() {
		Localizacao localizacao = new Localizacao("test");
		assert(localizacao != null);
	}
	
	@Test
	public void criarMensagens() {
		Mensagens mensagens = new Mensagens(false, "oi pedro", new UsuarioPadrao("test","test","test",new Localizacao("test")), false);
		assert(mensagens != null);
	}
	
	@Test
	public void criarModerador() {
		Moderador moderador = new Moderador("admin","admin","admin");
		assert(moderador != null);
	}
}
