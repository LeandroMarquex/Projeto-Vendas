package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.DAO.ItemDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Item;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Vendas;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {

		ProdutosDAO daoProduto = new ProdutosDAO();
		Produto produto = daoProduto.buscarPorCodigo(3L);

		VendasDAO daoVendas = new VendasDAO();
		Vendas vendas = daoVendas.buscarPorCodigo(4L);
		
		Item item = new Item();
		
		item.setQuantidade(100);
		item.setValor_parcial(new BigDecimal(500.00D));
		item.setProduto(produto);
		item.setVenda(vendas);
		
	    ItemDAO itemDAO = new ItemDAO();
	    itemDAO.salvar(item);

	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO dao = new ItemDAO();
		List<Item> item = dao.listar();

//		for (Produto produto : produtos) {
		System.out.println(item);
//		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO dao = new ItemDAO();
		Item f1 = dao.buscarPorCodigo(1L);

		System.out.println(f1);
	}

	@Test
	@Ignore
	public void excluir() {
		ItemDAO dao = new ItemDAO();
		Item item = dao.buscarPorCodigo(1L);

		if (item != null) {
			dao.excluir(item);

		}
	}

	@Test
	@Ignore
	public void editar() {

		ProdutosDAO daoProduto = new ProdutosDAO();
		Produto produto = daoProduto.buscarPorCodigo(3L);

		VendasDAO daoVendas = new VendasDAO();
		Vendas vendas = daoVendas.buscarPorCodigo(4L);
		
		ItemDAO itemDAO = new ItemDAO();
		Item item = new Item();

		item = itemDAO.buscarPorCodigo(2L);
		item.setQuantidade(1000);
		item.setValor_parcial(new BigDecimal(1000.00));
		item.setProduto(produto);
		item.setVenda(vendas);

		itemDAO.editar(item);

	}

}
