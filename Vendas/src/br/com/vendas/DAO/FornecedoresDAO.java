package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Fornecedor;
import br.com.vendas.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvar(Fornecedor fornecedor) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrir a transação
			sessao.save(fornecedor);
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
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Fornecedor> fornecedores = null;

		try {

			org.hibernate.Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		}

		finally {
			sessao.close();
		}
		return fornecedores;
	}

	public Fornecedor buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Fornecedor fornecedor = null;

		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {
			sessao.close();
		}
		return fornecedor;
	}

	public void excluir(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(fornecedor);
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
			Fornecedor fornecedor = buscarPorCodigo(l);
			sessao.delete(fornecedor);
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
	public void editar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
	//		Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
	//		fornecedorEditar.setDescricao(fornecedor.getDescricao());
	//		sessao.update(fornecedorEditar);
			sessao.update(fornecedor);
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