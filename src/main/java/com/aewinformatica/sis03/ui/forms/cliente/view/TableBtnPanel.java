package com.aewinformatica.sis03.ui.forms.cliente.view;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class TableBtnPanel extends JPanel {
	


	private static final long serialVersionUID = 1L;
    
	private Locale locale;
	private ResourceBundle rb;
	
	private JButton addBtn;
    private JButton removeBtn;

    public TableBtnPanel() {
    	locale = new Locale("pt_BR");
    	rb = ResourceBundle.getBundle("com.aewinformatica.sis03.resources.content", locale);
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(rb.getString("Labels.ADD_BTN"));
        add(addBtn);

        removeBtn = new JButton(rb.getString("Labels.REMOVE_BTN"));
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}
