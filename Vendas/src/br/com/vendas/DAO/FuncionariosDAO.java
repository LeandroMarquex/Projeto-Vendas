package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.domain.Funcionario;
import br.com.vendas.util.HibernateUtil;

public class FuncionariosDAO {
	
	public void salvar(Funcionario funcionario) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrir a transação
			sessao.save(funcionario);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Funcionario> funcionario = null;

		try {

			org.hibernate.Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionario = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		}

		finally {
			sessao.close();
		}
		return funcionario;
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Funcionario funcionario = null;

		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(funcionario);
			transacao.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void excluir(long l) {
		// TODO Auto-generated method stub
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Funcionario funcionario = buscarPorCodigo(l);
			sessao.delete(funcionario);
			transacao.commit();

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
	//		Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
	//		fornecedorEditar.setDescricao(fornecedor.getDescricao());
	//		sessao.update(fornecedorEditar);
			sessao.update(funcionario);
			transacao.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (transacao != null ) {
				transacao.rollback();
			}
			
		} finally {
			sessao.close();
		}
	}
}
