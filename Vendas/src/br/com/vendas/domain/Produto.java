package br.com.vendas.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbprodutos")

@NamedQueries({
	@NamedQuery(name = "Produto.listar", query = "SELECT produto FROM Produto produto"),
	@NamedQuery(name = "Produto.buscarPorCodigo", query = "SELECT produto FROM Produto produto WHERE produto.codigo = :codigo")
})

public class Produto {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="pro_codigo")
	private Long codigo;
	
	@Column(name="pro_descricao", length=50, nullable=false)
	private String descricao;
	
	@Column(name="pro_valor", length=14, nullable=false, scale=2, precision=7)
	private BigDecimal valor;
	
	@Column(name="pro_quantidade", nullable=false)
	private Integer quantidade;
		
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_fornecedores_for_codigo", referencedColumnName="for_codigo", nullable=false)
	private Fornecedor fornecedor;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", valor=" + valor + ", quantidade="
				+ quantidade + ", fornecedor=" + fornecedor + "]";
	}
	
	
	

}
