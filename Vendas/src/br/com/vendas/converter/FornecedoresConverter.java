package br.com.vendas.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.vendas.DAO.FornecedoresDAO;
import br.com.vendas.domain.Fornecedor;


@FacesConverter("fornecedoresConverter")
public class FornecedoresConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent componente, String valor) {
		// TODO Auto-generated method stub
		try {
			
			Long codigo = Long.parseLong(valor);
			FornecedoresDAO dao = new FornecedoresDAO();
			
			
			Fornecedor fornecedor = dao.buscarPorCodigo(codigo);
			
			return fornecedor;
			
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object objeto) {
		// TODO Auto-generated method stub
		
		try {
			
			Fornecedor fornecedor = (Fornecedor) objeto;
			Long codigo = fornecedor.getCodigo();
			return codigo.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
