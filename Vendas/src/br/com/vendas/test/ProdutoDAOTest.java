package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;



public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(4L);
		
		Produto p1 = new Produto();
		
		p1.setDescricao("Feijão");
		p1.setValor(new BigDecimal(15.99D));
		p1.setQuantidade(15);
		p1.setFornecedor(fornecedor);
		
		ProdutosDAO daoProdutos = new ProdutosDAO();
		daoProdutos.salvar(p1);
		
	}
	@Test
	@Ignore
	public void listar() {
		ProdutosDAO dao = new ProdutosDAO();
		List<Produto> produtos = dao.listar();
		
//		for (Produto produto : produtos) {
			System.out.println(produtos);
//		}
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutosDAO dao = new ProdutosDAO();
		Produto f1 = dao.buscarPorCodigo(1L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ProdutosDAO dao = new ProdutosDAO();
		Produto produto = dao.buscarPorCodigo(1L);
		
		if (produto != null) {
			dao.excluir(produto);
			
		}
	}
	@Test
	//@Ignore
	public void editar() {
		
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(4L);
		
		
		ProdutosDAO daoProdutos = new ProdutosDAO();
		Produto produto = new Produto();
		
		produto = daoProdutos.buscarPorCodigo(2L);
		produto.setDescricao("Feijão PRETO");
		produto.setValor(new BigDecimal(100.99D));
		produto.setQuantidade(100);
		produto.setFornecedor(fornecedor);
		
		
		daoProdutos.editar(produto);
				
	}
	
}
