package br.com.vendas.main;

import org.hibernate.Session;

import br.com.vendas.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();

	}

}