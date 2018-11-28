package com.aewinformatica.sis03.ui.forms.cfop.model;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.ui.shared.view.DefaultTableModel;

@Component
public class CfopTableModel extends DefaultTableModel<Cfop> {

	private static final long serialVersionUID = 1L;
	private String constCodigo = "Codigo";
	private String constCfop = "Cfop";
	private String constDescricao = "Descricao";
	private String constObservaçao = "Observação";
	private String constFaturamento = "Faturamento";
	private String constFinanceiro = "Financeiro";
	private String constSeqCfop = "SeqCfop";
	private String constOperacao = "Operacao";

	@Override
    public String[] getColumnLabels() {
        return new String[]{
        		constCodigo,
        		constCfop,
        		constDescricao,
        		constObservaçao,
        		constFaturamento,
        		constFinanceiro,
        		constSeqCfop,
        		constOperacao
                };
    }


	 @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Cfop cfop = entities.get(rowIndex);

	        switch (columnIndex) {
                case 0:
                return cfop.getCodigo();
                case 1:
                	return cfop.getCfop();
	            case 2:
	                return cfop.getDescricao();
	            case 3: 
	            	return cfop.getObservacao();
	            case 4:
	            	return cfop.isFaturamento();
	            case 5: 
	            	return cfop.isFinanceiro();
	            case 6:
	            	return cfop.getSeqcfop();
	            case 7:
	            	return cfop.getOperacao();
	            
	              
	            default:
	                return "";
	        }
	    }

}
