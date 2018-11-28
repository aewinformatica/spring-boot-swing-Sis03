package com.aewinformatica.sis03.ui.forms.cfop.view.modal;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.util.Borders;
import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class CfopFormPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int LAYOUT_ROWS = 7;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
	
    private JTextField codigoTF;
    private JTextField cfopTF;
    private JTextField descricaoTF;
    private JTextField observacaoTF;
    private JTextField faturamentoTF;
    private JTextField financeiroTF;
    private JTextField seqcfopTF;
    private JTextField operacaoTF;
    
    private ResourceBundle rb;
	
	private String LABEL_CODIGO;
	private String LABEL_CFOP;
	private String LABEL_DESCRICAO;
	private String LABEL_OBSERVACAO;
	private String LABEL_FATURAMENTO;
	private String LABEL_FINANCEIRO;
	private String LABEL_SEQCFOP;
	private String LABEL_OPERACAO;
	
	
	@Autowired
    public CfopFormPanel() {
		rb = LocaleUtils.getRb();
		
		LABEL_CODIGO = rb.getString("labels.cfop.codigo");
		LABEL_CFOP = rb.getString("labels.cfop.cfop");
		LABEL_DESCRICAO = rb.getString("labels.cfop.descricao");
		LABEL_OBSERVACAO = rb.getString("labels.cfop.observacao");
		LABEL_FATURAMENTO = rb.getString("labels.cfop.faturamento");
		LABEL_FINANCEIRO = rb.getString("labels.cfop.financeiro");
		LABEL_SEQCFOP = rb.getString("labels.cfop.seqcfop");
		LABEL_OPERACAO = rb.getString("labels.cfop.operacao");
		
		
		
        setPanelUp();
        initComponents();
	}

	private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }
	private void initComponents(){
		
		JLabel codigoLbl = new JLabel(LABEL_CODIGO);
		JLabel cfopLbl = new JLabel(LABEL_CFOP);
		JLabel descricaoLbl = new JLabel(LABEL_DESCRICAO);
		JLabel observacaoLbl = new JLabel(LABEL_OBSERVACAO);
		JLabel faturamentoLbl = new JLabel(LABEL_FATURAMENTO);
		JLabel financeiroLbl = new JLabel(LABEL_FINANCEIRO);
		JLabel seqcfopLbl = new JLabel(LABEL_SEQCFOP);
		JLabel operacaoLbl = new JLabel(LABEL_OPERACAO);
		
		codigoTF      = new JTextField(TEXT_FIELD_COLUMNS);
		cfopTF        = new JTextField(TEXT_FIELD_COLUMNS);
		descricaoTF   = new JTextField(TEXT_FIELD_COLUMNS);
		observacaoTF   = new JTextField(TEXT_FIELD_COLUMNS);
		faturamentoTF = new JTextField(TEXT_FIELD_COLUMNS);
		financeiroTF  = new JTextField(TEXT_FIELD_COLUMNS);
		seqcfopTF     = new JTextField(TEXT_FIELD_COLUMNS);
		operacaoTF    = new JTextField(TEXT_FIELD_COLUMNS);
		
		//LABELS
//		add(codigoLbl);
//		add(codigoTF);
		
		add(cfopLbl);
		add(cfopTF);
		
		add(descricaoLbl);
        add(descricaoTF);
        
		add(observacaoLbl);
        add(observacaoTF);
        
        add(faturamentoLbl);
        add(faturamentoTF);
        
        add(financeiroLbl);
        add(financeiroTF);
        
        add(seqcfopLbl);
        add(seqcfopTF);
        
        add(operacaoLbl);
        add(operacaoTF);
        
        
		
	}
	 public Cfop getCfopFromForm() {
		 
		 Cfop cfop = new Cfop();
		 cfop.setCfop(Integer.valueOf(cfopTF.getText()));
		 cfop.setDescricao(descricaoTF.getText());
		 cfop.setObservacao(observacaoTF.getText());
		 cfop.setFaturamento(Boolean.valueOf(faturamentoTF.getText()));
		 cfop.setFinanceiro(Boolean.valueOf(financeiroTF.getText()));
		 cfop.setSeqcfop(Integer.valueOf(seqcfopTF.getText()));
		 cfop.setOperacao(operacaoTF.getText());
		 
		 return cfop;
		 
	 }
    
    public void clearForm() {
        descricaoTF.setText("");
    }

}
