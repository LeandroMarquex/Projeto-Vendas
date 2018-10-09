package br.com.vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;

public class FornecedorDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("DESCRICAO 6");
		
		FornecedoresDAO dao = new FornecedoresDAO();
		dao.salvar(f1);
	}
	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO dao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = dao.listar();
		
		for(Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor f1 = dao.buscarPorCodigo(7L);
		
		System.out.println(f1);
	}
	
	@Test
	//@Ignore
	public void excluir() {
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(6L);
		
		if (fornecedor != null) {
			dao.excluir(fornecedor);
			
		}
		
	}
	@Test
	@Ignore
	public void excluirPorCodigo() {
		FornecedoresDAO dao = new FornecedoresDAO();

		dao.excluir(5L);
				
	}
	@Test
	//@Ignore
	public void editar() {
		Fornecedor f = new Fornecedor();
		f.setCodigo(2L);
		f.setDescricao("LEANDRO MARQUES ooooooo");

		FornecedoresDAO dao = new FornecedoresDAO();
		dao.editar(f);
				
	}
	
}
