package br.com.vendas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbFornecedores")
@NamedQueries({
	@NamedQuery(name = "Fornecedor.listar", query = "SELECT fornecedor FROM Fornecedor fornecedor"),
	@NamedQuery(name = "Fornecedor.buscarPorCodigo", query = "SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.codigo = :codigo")
			
			})
public class Fornecedor {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="for_codigo")
	private Long codigo;
	
	@Column(name="for_descricao", length=50, nullable=false)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

	
}
