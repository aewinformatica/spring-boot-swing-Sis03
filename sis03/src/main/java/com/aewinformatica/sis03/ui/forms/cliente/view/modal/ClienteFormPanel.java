package com.aewinformatica.sis03.ui.forms.cliente.view.modal;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cliente;
import com.aewinformatica.sis03.util.Borders;
import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class ClienteFormPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;
	
	private JTextField nomeTF;
	private ResourceBundle rb;
	private String LABEL_NAME;
	
	
	@Autowired
    public ClienteFormPanel() {
		rb = LocaleUtils.getRb();
		LABEL_NAME = rb.getString("Labels.NAME");
		
        setPanelUp();
        initComponents();
	}

	private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }
	private void initComponents(){
		JLabel nomeLbl = new JLabel(LABEL_NAME);
		
		nomeTF = new JTextField(TEXT_FIELD_COLUMNS);
		
        add(nomeLbl);
        add(nomeTF);
		
	}
	 public Cliente getClienteFromForm() {
		 
		 Cliente cliente = new Cliente();
		 cliente.setNome(nomeTF.getText());
		 
		 return cliente;
		 
	 }
    
    public void clearForm() {
        nomeTF.setText("");
    }

}
