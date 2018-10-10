package br.com.vendas.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.util.JSFUtil;

@ManagedBean(name = "MBVendas")
@ViewScoped
public class VendasBean {

	private Produto produto;
	private List<Item> itens;
	private List<Item> itensFiltrados;
	
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	
	
	
	

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Item> getItens() {
		if(itens == null){
			itens = new ArrayList<Item>();
		}
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	public List<Item> getItensFiltrados() {
		return itensFiltrados;
	}
	public void setItensFiltrados(List<Item> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}
	public void carregarProdutos() {

		try {
			ProdutosDAO fdao = new ProdutosDAO();
			produtos = (ArrayList<Produto>) fdao.listar();

		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
		public void adicionar(Produto produto) {
		
			Item item = new Item();
			item.setProduto(produto);
			item.setQuantidade(1);
			item.setValor_parcial(produto.getValor());
			itens.add(item);
	}
}
