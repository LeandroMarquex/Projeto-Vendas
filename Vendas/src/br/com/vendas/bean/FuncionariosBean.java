package br.com.vendas.bean;


import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean {

	private Funcionario funcionario;

	 private ArrayList<Funcionario>itens;
	 private ArrayList<Funcionario>itensFiltrados;
	 private String acao;
	 private Long codigo;
	 
	 
	 public Long getCodigo() {
		return codigo;
	}
	 
	 
	 public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	 
	 
	 public String getAcao() {
		return acao;
	}
	 
	 
	 public void setAcao(String acao) {
		this.acao = acao;
	}
	/*
	public Fornecedor getFornecedores() {
		
		if(fornecedores == null) {
			fornecedores = new Fornecedor();
		}
		return fornecedores;
	}*/

	//
	

	// @PostConstruct
	 public void prepararPesquisa(){
		
	 try {
	 FuncionariosDAO fdao = new FuncionariosDAO();
	 itens = (ArrayList<Funcionario>) fdao.listar();
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("ex.getMessage()");
	 e.printStackTrace();
	 }
	
	 }
	 
	 
	 public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public ArrayList<Funcionario> getItens() {
		return itens;
	}


	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}


	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}


	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}


	public void carregarCadastro(){

		 try {
		     
//			 acao = JSFUtil.getParam("foracao");
//			 
//			 String valor = JSFUtil.getParam("forcod");
//			 
//			 if(valor != null) {
//				 Long codigo = Long.parseLong(valor);
//				 
//				 FornecedoresDAO fdao = new FornecedoresDAO();	
//					
//		     	fornecedores = fdao.buscarPorCodigo(codigo);
//			 } else 
//				 fornecedores = new Fornecedor();
//			 
			
			 if(codigo != null){
				
				 
			FuncionariosDAO fdao = new FuncionariosDAO();	
	
    		funcionario = fdao.buscarPorCodigo(codigo);
				 
			 }
			 else
				 {
				funcionario = new Funcionario();
				
			 }
			 
		
		 } catch (RuntimeException e) {
		 JSFUtil.adicionarMensagemErro("ex.getMessage()");
		 e.printStackTrace();
		 }
		
		 } 
	 

	 public void novo(){
	 funcionario = new Funcionario();
	 }

	public void salvar() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.salvar(funcionario);
			
			funcionario = new Funcionario();

			// itens = fdao.listar();

			JSFUtil.adicionarMensagemSucesso("Funcionario salvo com sucesso!");

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	
	
	 public void excluir(){
	 try {
	 FuncionariosDAO fdao = new FuncionariosDAO();
	 fdao.excluir(funcionario);
	
	
	
	 JSFUtil.adicionarMensagemSucesso("Funcionario excluido com sucesso!");
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("Não é possível excluir um funcionario que tenha um venda associado!");
	 e.printStackTrace();
	 }
	 }
	
	
	
	
	
	 public void editar(){
	 try {
	 FuncionariosDAO fdao = new FuncionariosDAO();
	 fdao.editar(funcionario);
	
	
	 JSFUtil.adicionarMensagemSucesso("Funcionario editado com sucesso!");
	
	 } catch (RuntimeException e) {
	 JSFUtil.adicionarMensagemErro("ex.getMessage()");
	 e.printStackTrace();
	 }
	 }
	
}
