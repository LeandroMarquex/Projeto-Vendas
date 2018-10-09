package br.com.vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.vendas.domain.Produto;
import br.com.vendas.util.HibernateUtil;

public class ProdutosDAO {
	
	public void salvar(Produto produto) {

		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction(); // abrir a transação
			sessao.save(produto);
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
	public List<Produto> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		List<Produto> produto = null;

		try {

			org.hibernate.Query consulta = sessao.getNamedQuery("Produto.listar");
			produto = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		}

		finally {
			sessao.close();
		}
		return produto;
	}

	public Produto buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Produto produto = null;

		try {

			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto = (Produto) consulta.uniqueResult();

		} catch (RuntimeException e) {
			// TODO: handle exception
			throw e;
		} finally {
			sessao.close();
		}
		return produto;
	}

	public void excluir(Produto produto) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
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
			Produto produto = buscarPorCodigo(l);
			sessao.delete(produto);
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
	public void editar(Produto funcionario) {
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


