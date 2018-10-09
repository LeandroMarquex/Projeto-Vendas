package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Produto;
import br.com.vendas.domain.Vendas;
import br.com.vendas.util.HibernateUtil;

public class VendasDAO {
	
	public void salvar(Vendas vendas) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrir a transação
			sessao.save(vendas);
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
	public List<Vendas> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Vendas> vendas = null;

		try {

			org.hibernate.Query consulta = sessao.getNamedQuery("Produto.listar");
			vendas = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		}

		finally {
			sessao.close();
		}
		return vendas;
	}

	public Vendas buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Vendas vendas = null;

		try {

			Query consulta = sessao.getNamedQuery("Vendas.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			vendas = (Vendas) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {
			sessao.close();
		}
		return vendas;
	}

	public void excluir(Vendas vendas) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(vendas);
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
			Vendas vendas = buscarPorCodigo(l);
			sessao.delete(vendas);
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
	public void editar(Vendas vendas) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
	//		Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
	//		fornecedorEditar.setDescricao(fornecedor.getDescricao());
	//		sessao.update(fornecedorEditar);
			sessao.update(vendas);
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
