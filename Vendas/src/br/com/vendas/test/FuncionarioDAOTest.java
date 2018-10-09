package br.com.vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.vendas.DAO.FuncionariosDAO;

import br.com.vendas.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		Funcionario f1 = new Funcionario();
		
		
		f1.setNome("Lohanny MARQUES");
		f1.setCpf("011.791.379-00");
		f1.setSenha("123");
		f1.setFuncao("Arquiteta");
		
		FuncionariosDAO dao = new FuncionariosDAO();
		dao.salvar(f1);
	
	}
	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO dao = new FuncionariosDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario f1 = dao.buscarPorCodigo(2L);
		
		System.out.println(f1);
	}
	
	@Test
	@Ignore
	public void excluir() {
		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		
		if (funcionario != null) {
			dao.excluir(funcionario);
			
		}
		
	}
	@Test
	@Ignore
	public void excluirPorCodigo() {
		FuncionariosDAO dao = new FuncionariosDAO();

		dao.excluir(5L);
				
	}
	@Test
	@Ignore
	public void editar() {
		Funcionario f = new Funcionario();
		f.setCodigo(2L);
		f.setNome("LEANDRO MARQUES ooooooo");
		f.setCpf("000.111.222-33");
		f.setSenha("222");
		f.setFuncao("Arquiteta Pleno");

		FuncionariosDAO dao = new FuncionariosDAO();
		dao.editar(f);
				
	}
	

}
