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
		UsuarioPadrao usuarioAuxiliar = null;
		Usuario usuario = null;
		Projeto projetoAtual = null;
		localizacoes.add(new Localizacao("Maceio"));
		usuarios.add(new UsuarioPadrao("joao","123","joao", localizacoes.get(0)));

		
		while(menu != Menu.FIM) {
			switch(menu) {
				case INICIO:
					menu = tela.menuInicial();
					break;
				case LOGIN:
					usuario = tela.entrar(usuarios,moderador);
					if(usuario == null) 
						menu = Menu.INICIO;
					else if(usuario.getNome().equals("admin"))
						menu = Menu.MENUMODERADOR;
					else {
						menu = Menu.MENUUSUARIO;
						usuarioLogado = (UsuarioPadrao)usuario;
					}
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
					menu = Menu.MENUUSUARIO;
					break;
				case PROCURARNOME:
					projetoAtual = tela.procurarPorNome(projetos);
					if(projetoAtual == null)
						menu = Menu.MENUUSUARIO;
					else 
						menu = Menu.MENUPROJETO;
					break;
				case PROCURARCATEGORIA:
					projetoAtual = tela.procurarPorCategoria(categorias);
					if(projetoAtual == null) 
						menu = Menu.MENUUSUARIO;
					else 
						menu = Menu.MENUPROJETO;
					break;
				case MENUMODERADOR:
					menu = tela.menuModerador(moderador, projetos);
					break;
				case CARTAO:
					tela.menuCartao(usuarioLogado);
					menu = Menu.MENUUSUARIO;
					break;
				case BUSCAR:
					menu = tela.buscarProjeto();
					break;
				case MENUPROJETO:
					tela.menuProjeto(projetoAtual, usuarioLogado);
					break;
				case RELATORIO:
					tela.relatorio(usuarios, projetos);
					menu = Menu.MENUMODERADOR;
					break;
				case SEGUIR:
					usuarioAuxiliar = tela.buscarUsuario(usuarios);
					if(usuarioAuxiliar != null)
						usuarioLogado.setSeguindo(usuarioAuxiliar);
					else
						System.out.println("Usuario nao encontrado");
					usuarioAuxiliar = null;
					menu = Menu.MENUUSUARIO;
					break;
				case MENSAGEM:
					usuarioAuxiliar = null;
					usuarioAuxiliar = tela.buscarUsuario(usuarios);
					if(usuarioAuxiliar!=null)
						tela.mensagem(usuarioLogado, usuarioAuxiliar);
					menu = Menu.MENUUSUARIO;
					break;
				case ALTERARDADOS:
					tela.alterarDados(usuarioLogado);
					menu = Menu.MENUUSUARIO;
					break;
				case HISTORICODOACAO:
					tela.historicoDoacao(usuarioLogado);
					menu = Menu.MENUUSUARIO;
					break;
				case HISTORICOPROJETO:
					tela.historicoProjeto(usuarioLogado);
					menu = Menu.MENUUSUARIO;
					break;
				case INFOPROJETOS:
					tela.infoProjeto(usuarioLogado);
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
		BUSCAR,
		MENUUSUARIO,
		CRIACAO,
		PROCURARNOME,
		PROCURARCATEGORIA,
		MENUMODERADOR,
		CARTAO,
		MENUPROJETO,
		RELATORIO,
		FIM, 
		SEGUIR, 
		MENSAGEM, 
		ALTERARDADOS, 
		HISTORICODOACAO, 
		HISTORICOPROJETO, 
		INFOPROJETOS;
	}
}
