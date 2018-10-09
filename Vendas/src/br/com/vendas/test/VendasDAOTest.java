package br.com.vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.DAO.FuncionariosDAO;
import br.com.vendas.DAO.ProdutosDAO;
import br.com.vendas.DAO.VendasDAO;
import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Vendas;

public class VendasDAOTest {

	@Test
	@Ignore
	public void salvar() {

		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(4L);

		Vendas p1 = new Vendas();

		p1.setHorario(new Date());
		p1.setValor_total( new BigDecimal(80.00));
		p1.setFuncionario(funcionario);

		VendasDAO vendas = new VendasDAO();
		vendas.salvar(p1);

	}

	@Test
	@Ignore
	public void listar() {
		VendasDAO dao = new VendasDAO();
		List<Vendas> vendas = dao.listar();

//		for (Produto produto : produtos) {
		System.out.println(vendas);
//		}

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO dao = new VendasDAO();
		Vendas f1 = dao.buscarPorCodigo(1L);

		System.out.println(f1);
	}

	@Test
	@Ignore
	public void excluir() {
		VendasDAO dao = new VendasDAO();
		Vendas vendas = dao.buscarPorCodigo(1L);

		if (vendas != null) {
			dao.excluir(vendas);

		}
	}

	@Test
	@Ignore
	public void editar() {
		
		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(2L);

		VendasDAO vendasDAO = new VendasDAO();
		Vendas vendas = new Vendas();
		
		vendas = vendasDAO.buscarPorCodigo(2L);
		vendas.setHorario(new Date());
		vendas.setValor_total( new BigDecimal(100.00));
		vendas.setFuncionario(funcionario);

		
		vendasDAO.editar(vendas);

	}

}
