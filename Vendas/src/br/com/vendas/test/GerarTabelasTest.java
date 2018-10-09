package br.com.vendas.test;

import org.hibernate.Session;
import org.junit.Test;

import br.com.vendas.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();

	}

}
