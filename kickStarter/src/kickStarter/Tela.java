package kickStarter;

import kickStarter.Sistema.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Tela {
	Scanner input = new Scanner(System.in);
	private int resposta;
	private String email;
	private String senha;
	private String nome;
	private String local;
	private String numero;
	private String codigo;
	private String texto;
	private float valor;
	private String descricao;
	private Categoria categoria = null;
	private int tempoLimite;
	private String nomeDaCategoria;
	private Projeto projetoAtual = null;
	private Localizacao localizacao = null;
	private Cartao cartao = null;
	private Mensagens mensagemEnviada = null;
	private Mensagens mensagemRecebida = null;
	private Doacao doacao = null;
	
	
	public Menu menuInicial() {
		System.out.println("[1]Entrar");
		System.out.println("[2]Se cadastrar");
		System.out.println("[0]Sair");
		this.resposta = input.nextInt();
		switch(this.resposta) {
			case 1:
				return Menu.LOGIN;
			case 2:
				return Menu.CADASTRO;
			default:
				return Menu.FIM;
		}
	}
	
	public Usuario entrar(ArrayList<UsuarioPadrao> usuarios, Moderador moderador) {
		System.out.println("Digite seu email:");
		this.email = input.next();
		System.out.println("Digite sua senha:");
		this.senha = input.next();
		
		if(email.equals(moderador.getNome())) {
			if(senha.equals(moderador.getSenha())) {
				return moderador;
			}
		}
		for(UsuarioPadrao u: usuarios) {
			if(u.getEmail().equals(this.email)) {
				if(u.getSenha().equals(this.senha)) {
					System.out.println("Ola " + u.getNome()+", seja bem vindo!");
					return u;
				}
			}
		}
		System.out.println("Usuario nao encontrado");
		return null;
	}
	
	public UsuarioPadrao buscarUsuario(ArrayList<UsuarioPadrao> usuarios) {
		System.out.println("Qual o nome do usuario procurado?");
		input = new Scanner(System.in);
		nome = input.nextLine();
		for(UsuarioPadrao u: usuarios)
			if(nome.equals(u.getNome()))
				return u;
		
		System.out.println("Usuario nao encontrado");
		return null;
	}
	
	public void mensagem(UsuarioPadrao usuarioLogado,UsuarioPadrao usuarioAuxiliar){
		System.out.println("Digite a mensagem que voce quer enviar para " + usuarioAuxiliar.getNome());
		input = new Scanner(System.in);
		texto = input.nextLine();
		mensagemEnviada = new Mensagens(true, texto, usuarioAuxiliar, true);
		mensagemRecebida = new Mensagens(false, texto, usuarioLogado, false);
		usuarioLogado.setMensagens(mensagemEnviada);
		usuarioAuxiliar.setMensagens(mensagemRecebida);
		mensagemEnviada = null;
		mensagemRecebida = null;
	}
	
	public UsuarioPadrao cadastrar(ArrayList<Localizacao> localizacoes) {
		this.localizacao = null; //localizacao usuario anterior
		System.out.println("Digite seu nome:");
		input = new Scanner(System.in);
		this.nome = input.nextLine();
		System.out.println("Digite seu email:");
		this.email = input.next();
		System.out.println("Digite sua senha:");
		this.senha = input.next();
		System.out.println("Repita sua senha:");
		while(!this.senha.equals(input.next())) {
			System.out.println("Senhas incompativeis");
			System.out.println("Digite sua senha:");
			this.senha = input.next();
			System.out.println("Repita sua senha:");
		}
		System.out.println("Digite o estado em que voce mora:");
		input = new Scanner(System.in);
		this.local = input.nextLine();
		for(Localizacao l:  localizacoes) {
			if(l.getNomeDoLocal().equals(this.local)) {
				this.localizacao = l;
				break;
			}
		}
		if(this.localizacao == null)
		{
			this.localizacao = new Localizacao(this.local);
			localizacoes.add(this.localizacao);
		}
		
		return new UsuarioPadrao(this.nome,this.senha,this.email,this.localizacao);
	}
	
	public void alterarDados(UsuarioPadrao usuario) {
		System.out.println("Qual dado voce gostaria de mudar?");
		System.out.println("[1]Nome");
		System.out.println("[2]Senha");
		System.out.println("[3]Email");
		resposta = input.nextInt();
		input = new Scanner(System.in);
		switch(resposta) {
			case 1:
				System.out.println("Digite o nome para o qual voce gostaria de mudar");
				usuario.setNome(input.nextLine());
				break;
			case 2:
				System.out.println("Digite a senha para a qual voce gostaria de mudar");
				usuario.setSenha(input.next());
				break;
			case 3:
				System.out.println("Digite o email para o qual voce gostaria de mudar");
				usuario.setEmail(input.next());
				break;
			default:
			System.out.println("Opcao invalida, voce sera redirecionado para o menu de usuario");
		}
	}
	public Menu buscarProjeto() {
		System.out.println("[1]Procurar por nome");
		System.out.println("[2]Procurar por categoria");
		System.out.println("[0]Voltar para o menu do usuario");
		resposta = input.nextInt();
		switch(resposta) {
			case 1:
				return Menu.PROCURARNOME;
			case 2:
				return Menu.PROCURARCATEGORIA;
			default:
				return Menu.MENUUSUARIO;
		}
		
	}
	
	public Menu menuUsuario() {
		System.out.println("[1]Gostaria de buscar por algum projeto");
		System.out.println("[2]Gostaria de criar um projeto");
		System.out.println("[3]Gostaria de cadastrar um cartao");
		System.out.println("[4]Gostaria de seguir alguem");
		System.out.println("[5]Gostaria de mandar uma mensagem");
		System.out.println("[6]Gostaria de alterar dados pessoais");
		System.out.println("[7]Gostaria de ver historico de doacoes");
		System.out.println("[8]Gostaria de ver historico de projetos criados");//aq
		System.out.println("[9]Gerenciar informacoes do seu projeto");
		System.out.println("[0]Sair");
		this.resposta = input.nextInt();
		switch(resposta) {
			case 1:
				return Menu.BUSCAR;
			case 2:
				return Menu.CRIACAO;
			case 3:
				return Menu.CARTAO;
			case 4:
				return Menu.SEGUIR;
			case 5:
				return Menu.MENSAGEM;
			case 6:
				return Menu.ALTERARDADOS;
			case 7:
				return Menu.HISTORICODOACAO;
			case 8:
				return Menu.HISTORICOPROJETO;
			case 9:
				return Menu.INFOPROJETOS;
			default:
				return Menu.INICIO;
		}
	}

	public void criarProjeto(UsuarioPadrao usuario, ArrayList<Categoria> categorias, Moderador moderador) {
		System.out.println("Nome:");
		input = new Scanner(System.in);
		nome = input.nextLine();
		System.out.println("Descricao:");
		input = new Scanner(System.in);
		descricao = input.nextLine();
		System.out.println("Tempo limite (em dias):");
		tempoLimite = input.nextInt();
		if(tempoLimite > 60) {
			System.out.println("Tempo limite maximo permitido eh de 60 dias");
			System.out.println("Seu tempo limite foi configurado para 60 dias");
			tempoLimite = 60;
		}
		System.out.println("Valor minimo:");
		valor = input.nextFloat();
		System.out.println("Categoria:");
		input = new Scanner(System.in);
		nomeDaCategoria = input.nextLine();
		for(Categoria c:  categorias) {
			if(c.getNomeDaCategoria().equals(nomeDaCategoria)) {
				this.categoria = c;
				break;
			}
		}
		if(this.categoria == null)
		{
			categoria = new Categoria(nomeDaCategoria);
			categorias.add(categoria);
		}
		moderador.setAutenticarProjetos(new Projeto(usuario, nome, descricao, tempoLimite,valor,categoria));
		this.categoria = null;
	}
	
	public Projeto procurarPorNome(ArrayList<Projeto> projetos) {
		if(projetos == null) {
			System.out.println("Ainda nao existe projetos cadastradas!");
		}
		System.out.println("Qual o nome do projeto o qual voce quer visualizar?");
		input = new Scanner(System.in);
		nome = input.nextLine();
		
		for(Projeto p: projetos) {
			if(p.getNome().equals(nome)) {
				 return p;
			}
		}
		return null;
	}
	
	public void historicoDoacao(UsuarioPadrao usuario) {
		try {
			for(Doacao d: usuario.getDoacoes()) {
				System.out.println("Voce doou " + d.getValorDoado() + "para o projeto " + d.getProjeto().getNome());
			}	
		}
		catch(NullPointerException exception) {
			System.out.println("Voce ainda nao fez a primeira doacao!");
		}
	}
	
	public void doacao(Projeto projeto, UsuarioPadrao usuario) {
		System.out.println("Quanto voce gostaria de doar para o projeto "+ projeto.getNome() +"?");
		valor = input.nextFloat();
		projeto.setValorAtual(valor);
		System.out.println("Voce doou "+valor+" reais para o projeto");
		doacao = new Doacao(projeto, valor);
		usuario.setDoacoes(doacao);
		doacao = null;
	}
	
	public void infoProjeto(UsuarioPadrao usuario) {
		System.out.println("Digite o nome do seu projeto que voce quer alterar infos:");
		projetoAtual = null;
		input = new Scanner(System.in);
		nome = input.nextLine();
		
		try {
			for(Projeto p: usuario.getProjetosCriados()) {
				if(p.getNome().equals(nome)) {
					projetoAtual = p;
					break;
				}				
			}
		}
		catch(NullPointerException exception) {
			System.out.println("Voce nao tem projeto criado com esse nome");
			return;
		}
		
		System.out.println("Qual das seguintes informacoes voce gostaria de alterar?");
		System.out.println("[1]Nome");
		System.out.println("[2]Descricao");
		System.out.println("[3]Valor minimo");
		resposta = input.nextInt();
		input = new Scanner(System.in);
		switch(resposta) {
		case 1:
			System.out.println("Digite o novo nome escolhido:");
			projetoAtual.setNome(input.nextLine());
			break;
		case 2:
			System.out.println("Digite a nova descricao:");
			projetoAtual.setDescricao(input.nextLine());
			break;
		case 3:
			System.out.println("Digite o novo valor minimo escolhido:");
			projetoAtual.setValorMinimo(input.nextFloat());
			break;
		default:
			System.out.println("Opcao invalida! Voce sera redirecionado pro menu do usuario");
		}
		
	}
	public Menu menuProjeto(Projeto projeto, UsuarioPadrao usuario) {
		System.out.println("[1]Ver dados sobre o Projeto");
		System.out.println("[2]Favoritar o Projeto");
		System.out.println("[3]Doar para o Projeto");
		System.out.println("[0]Sair");
		resposta = input.nextInt();
		
		switch(resposta) {
			case 1:
				projeto.getAllInfos();
				menuProjeto(projeto, usuario);
				break;
			case 2:
				usuario.setProjetosFavoritos(projeto);
				menuProjeto(projeto, usuario);
			case 3:
				doacao(projeto, usuario);
				menuProjeto(projeto, usuario);
			default:	
		}
		return Menu.MENUUSUARIO;
	}
	
	public void menuCartao(UsuarioPadrao usuario) {
		this.numero = input.next();
		this.codigo = input.next();
		cartao = new Cartao(numero,codigo);
		usuario.setCartao(cartao);
		cartao = null;
	}
	
	public Projeto procurarPorCategoria(ArrayList<Categoria> categorias) {
		
		if(categorias == null) {
			System.out.println("Ainda nao existe categorias cadastradas!");
		}
		System.out.println("Qual a categoria de projeto para qual voce quer buscar um projeto?");
		input = new Scanner(System.in);
		nome = input.nextLine();
		
		for(Categoria c: categorias) {
			if(c.getNomeDaCategoria().equals(nome)) {
				 this.categoria = c;
				 break;
			}
		}
		if(categoria == null) {
			System.out.println("Nao existe nenhum categoria com esse nome!");
			return null;
		}
		System.out.println("Essa eh a lista de projetos nessa categoria:");
		for(Projeto p: this.categoria.getProjetos()) {
			System.out.println("Voce gostaria de visualizar o projeto "+p.getNome());
			System.out.println("[1]Sim");
			System.out.println("[2]Ir para o proximo");
			resposta = input.nextInt();
			if(resposta == 1) {
				this.categoria = null;
				return p;
			}
				
		}
		
		System.out.println("Voce nao escolheu nenhum dos projetos!");
		return null;


	}
	
	public Menu menuModerador(Moderador moderador, ArrayList<Projeto> projetos) {
		System.out.println("Voce gostaria de:");
		System.out.println("[1]Autenticar projetos");
		System.out.println("[2]Relatorio do Sistema");
		System.out.println("[0]Sair");
		
		resposta = input.nextInt();
		if(resposta == 1) {
			autenticarProjeto(moderador, projetos);
			return Menu.MENUMODERADOR;
		}
		else if(resposta == 2) {
			return Menu.RELATORIO;
		}
		return Menu.INICIO;
	}
	
	public void relatorio(ArrayList<UsuarioPadrao> usuarios, ArrayList<Projeto> projetos) {
		System.out.println("Quantidade de usuarios cadastrados: " + usuarios.size());
		int jaFinanciado = 0;
		for(Projeto p: projetos) {
			if(p.jaFinanciado())
				++jaFinanciado;
		}
		System.out.println("Projetos em aberto: " + (projetos.size() - jaFinanciado));
		System.out.println("Projetos ja financiados: " + jaFinanciado);
	}
	
	public void historicoProjeto(UsuarioPadrao usuario) {
		try {
			for(Projeto p: usuario.getProjetosCriados()) {
				System.out.println(p.getNome());
			}
		}
		catch(NullPointerException exception) {
			System.out.println("Voce ainda nao criou nenhum projeto");
			
		}
		
		
	}
	
	public void autenticarProjeto(Moderador moderador, ArrayList<Projeto> projetos) {
		System.out.println("Voce tem " + moderador.quantidadeDeProjetos() + " para ser autenticados!");
		while(moderador.quantidadeDeProjetos()>0) {
			projetoAtual = moderador.getProjeto();
			projetoAtual.getAllInfos();
			System.out.println("Voce gostaria de autenticar esse projeto?");
			System.out.println("[1]Sim");
			System.out.println("[2]Nao");
			resposta = input.nextInt();
			if(resposta == 1) {
				projetos.add(projetoAtual);
				projetoAtual.getCriador().setProjetosCriados(projetoAtual);
			}
			moderador.deleteProjeto();
		}
		System.out.println("Todos os projetos jah foram analizados!");
		projetoAtual = null;
	}
}
