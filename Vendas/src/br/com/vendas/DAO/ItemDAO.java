package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vendas.domain.Item;
import br.com.vendas.domain.Vendas;
import br.com.vendas.util.HibernateUtil;

public class ItemDAO {

	public void salvar(Item item) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrir a transação
			sessao.save(item);
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
	public List<Item> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Item> item = null;

		try {

			org.hibernate.Query consulta = sessao.getNamedQuery("Item.listar");
			item = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		}

		finally {
			sessao.close();
		}
		return item;
	}

	public Item buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Item item = null;

		try {

			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			item = (Item) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {
			sessao.close();
		}
		return item;
	}

	public void excluir(Item item) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(item);
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
			Item item = buscarPorCodigo(l);
			sessao.delete(item);
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

	public void editar(Item item) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			// Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
			// fornecedorEditar.setDescricao(fornecedor.getDescricao());
			// sessao.update(fornecedorEditar);
			sessao.update(item);
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
}
