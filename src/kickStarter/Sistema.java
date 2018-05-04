package kickStarter;

import java.util.ArrayList;

public class Sistema {

	public static void main(String[] args) {
		
		Tela tela = new Tela(); 
		Menu menu = Menu.INICIO;		
		ArrayList<UsuarioPadrao> usuarios = new ArrayList<UsuarioPadrao>();
		ArrayList<Projeto> projetos = new ArrayList<Projeto>();
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		ArrayList<Localizacao> localizacoes = new ArrayList<Localizacao>();
		Moderador moderador = new Moderador("admin","admin","admin");
		UsuarioPadrao usuarioLogado = null;
		
		while(menu != Menu.FIM) {
			switch(menu) {
				case INICIO:
					menu = tela.menuInicial();
					break;
				case LOGIN:
					usuarioLogado = tela.entrar(usuarios);
					if(usuarioLogado == null) 
						menu = Menu.INICIO;
					else if(usuarioLogado.getNome().equals("admin"))
						menu = Menu.MENUMODERADOR;
					else
						menu = Menu.MENUUSUARIO;
					break;
				case CADASTRO:
					usuarios.add(tela.cadastrar(localizacoes));
					menu = Menu.INICIO;
					break;
				case MENUUSUARIO:
					menu = tela.menuUsuario();
					break;
				case CRIACAO:
					tela.criarProjeto(usuarioLogado, categorias, moderador);
					break;
				case DOACAO:
					menu = tela.doacao();
					break;
				case DOACAONOME:
					tela.doacaoPorNome(projetos);
					menu = Menu.MENUUSUARIO;
					break;
				case DOACAOCATEGORIA:
					tela.doacaoPorCategoria(categorias);
					menu = Menu.MENUUSUARIO;
					break;
				case MENUMODERADOR:
					menu = tela.menuModerador(moderador, projetos);
					break;
				case CARTAO:
					tela.menuCartao(usuarioLogado);
					menu = Menu.MENUUSUARIO;
					break;
				default:
					break;
					
			}
		}
	}
	public enum Menu {
		INICIO,
		CADASTRO,
		LOGIN,
		MENUUSUARIO,
		CRIACAO,
		DOACAO,
		MENUMODERADOR,
		CARTAO,
		FIM, DOACAONOME, DOACAOCATEGORIA;
	}
}
