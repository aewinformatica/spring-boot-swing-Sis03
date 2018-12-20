package com.aewinformatica.sis03.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.stereotype.Component;

@Entity
@Table(name="cfop")
//@Component
public class Cfop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	private Long codigo;
	
	@Column
	private Long cfop;
	
	@Column(length=120)
	private String descricao;
	@Column(length=120)
	private String observacao;
	@Column(length=1)
	private String operacao;
	@Column(length=1)//OBS O TAMANHA
    private Long seqcfop;
    
    @Column(columnDefinition="tinyint(1) not null",nullable = false)
    private boolean faturamento;
    
    @Column(columnDefinition="tinyint(1)")
    private boolean financeiro;
    
	public Cfop() {
	}

	public Cfop(Long cfop, String descricao, String observacao, String operacao, Long seqcfop, boolean faturamento,
			boolean financeiro) {
		this.cfop = cfop;
		this.descricao = descricao;
		this.observacao = observacao;
		this.operacao = operacao;
		this.seqcfop = seqcfop;
		this.faturamento = faturamento;
		this.financeiro = financeiro;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getCfop() {
		return cfop;
	}

	public void setCfop(Long cfop) {
		this.cfop = cfop;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Long getSeqcfop() {
		return seqcfop;
	}

	public void setSeqcfop(Long seqcfop) {
		this.seqcfop = seqcfop;
	}

	public boolean isFaturamento() {
		return faturamento;
	}

	public void setFaturamento(boolean faturamento) {
		this.faturamento = faturamento;
	}

	public boolean isFinanceiro() {
		return financeiro;
	}

	public void setFinanceiro(boolean financeiro) {
		this.financeiro = financeiro;
	}

    @SuppressWarnings("unused")
	private String trataString( String wcampo )
    {
	char cpo[] = new char[wcampo.length()];
	int j = 0;
	for ( int i=0; i<wcampo.length(); i++ )
	{
		if ( wcampo.charAt( i ) == '_' )
                    {
                        cpo[j] = ' ';
                        j++;
                    }
                    else if ( wcampo.charAt( i ) == '"' );
                    else if ( wcampo.charAt( i ) == '\'' );
		else
                    {
                        cpo[j] = wcampo.charAt( i );
                        j++;
                    }
	}
	String resultado = "";
	for (int i=0;i<j;i++)
	{
		resultado = resultado + cpo[i];
           }
            return resultado;
    }



	@Override
	public String toString() {
		return "Cfop [codigo=" + codigo + ", cfop=" + cfop + ", descricao=" + descricao + ", observacao=" + observacao
				+ ", operacao=" + operacao + ", seqcfop=" + seqcfop + ", faturamento=" + faturamento + ", financeiro="
				+ financeiro + "]";
	}
    
	

}
