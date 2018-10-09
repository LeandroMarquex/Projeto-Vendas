package br.com.vendas.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		HibernateUtil.getFabricaDeSessoes().openSession();
	}
	
	

}
