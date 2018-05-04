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
	private float valor;
	private String descricao;
	private Categoria categoria = null;
	private int tempoLimite;
	private String nomeDaCategoria;
	private Projeto projetoAtual = null;
	private Localizacao localizacao = null;
	private Cartao cartao = null;
	
	
	
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
	
	public UsuarioPadrao entrar(ArrayList<UsuarioPadrao> usuarios) {
		System.out.println("Digite seu email:");
		this.email = input.next();
		System.out.println("Digite sua senha:");
		this.senha = input.next();
		
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
	
	public UsuarioPadrao cadastrar(ArrayList<Localizacao> localizacoes) {
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
	
	public Menu menuUsuario() {
		System.out.println("[1]Gostaria de doar para algum projeto");
		System.out.println("[2]Gostaria de criar um projeto");
		System.out.println("[3]Gostaria de cadastrar um cartao");
		System.out.println("[0]Sair");
		this.resposta = input.nextInt();
		switch(resposta) {
			case 1:
				return Menu.DOACAO;
			case 2:
				return Menu.CRIACAO;
			case 3:
				return Menu.CARTAO;
			default:
				return Menu.INICIO;
		}
	}
	
	public Menu doacao() {
		System.out.println("[1]Procurar por nome");
		System.out.println("[2]Procurar por categoria");
		System.out.println("[0]Voltar para o menu do usuario");
		resposta = input.nextInt();
		switch(resposta) {
			case 1:
				return Menu.DOACAONOME;
			case 2:
				return Menu.DOACAOCATEGORIA;
			default:
				return Menu.MENUUSUARIO;
		}
		
	}
	
	public void criarProjeto(Usuario usuario, ArrayList<Categoria> categorias, Moderador moderador) {
		System.out.println("Nome:");
		input = new Scanner(System.in);
		nome = input.nextLine();
		System.out.println("Descricao:");
		input = new Scanner(System.in);
		descricao = input.nextLine();
		System.out.println("Tempo limite (em dias):");
		tempoLimite = input.nextInt();
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
	
	public void doacaoPorNome(ArrayList<Projeto> projetos) {
		if(projetos == null) {
			System.out.println("Ainda nao existe projetos cadastradas!");
		}
		System.out.println("Qual o nome do projeto para qual voce quer fazer uma doacao?");
		input = new Scanner(System.in);
		nome = input.nextLine();
		
		for(Projeto p: projetos) {
			if(p.getNome().equals(nome)) {
				 projetoAtual = p;
				 break;
			}
		}
		if(projetoAtual == null) {
			System.out.println("Nao existe nenhum projeto com esse nome!");
			return;
		}
		
		System.out.println("Quanto voce gostaria de doar?");
		valor = input.nextFloat();
		projetoAtual.setValorAtual(valor);
		System.out.println("Voce depositou "+valor+" reais no projeto "+projetoAtual.getNome());
		this.projetoAtual = null;
	}
	
	public void menuCartao(UsuarioPadrao usuario) {
		this.numero = input.next();
		this.codigo = input.next();
		cartao = new Cartao(numero,codigo);
		usuario.setCartao(cartao);
		cartao = null;
	}
	
	public void doacaoPorCategoria(ArrayList<Categoria> categorias) {
		
		if(categorias == null) {
			System.out.println("Ainda nao existe categorias cadastradas!");
		}
		System.out.println("Qual a categoria de projeto para qual voce quer fazer uma doacao?");
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
			return;
		}
		System.out.println("Essa eh a lista de projetos nessa categoria:");
		for(Projeto p: this.categoria.getProjetos()) {
			System.out.println("Voce gostaria de doar para o projeto "+p.getNome());
			System.out.println("[1]Sim");
			System.out.println("[2]Ir para o proximo");
			resposta = input.nextInt();
			if(resposta == 1) {
				projetoAtual = p;
				break;
			}
				
		}
		if(projetoAtual == null) {
			System.out.println("Voce nao escolheu nenhum dos projetos!");
			return;
		}
		System.out.println("Quanto voce gostaria de doar?");
		valor = input.nextFloat();
		projetoAtual.setValorAtual(valor);
		System.out.println("Voce depositou "+valor+" reais no projeto "+projetoAtual.getNome());
		this.projetoAtual = null;
		this.categoria = null;
	}
	
	public Menu menuModerador(Moderador moderador, ArrayList<Projeto> projetos) {
		System.out.println("Voce gostaria de:");
		System.out.println("[1]Autenticar projetos");
		System.out.println("[0]Sair");
		
		resposta = input.nextInt();
		if(resposta == 1) {
			autenticarProjeto(moderador, projetos);
			return Menu.MENUMODERADOR;
		}
		return Menu.INICIO;
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
			}
			moderador.deleteProjeto();
		}
		System.out.println("Todos os projetos jah foram analizados!");
		projetoAtual = null;
	}
}
