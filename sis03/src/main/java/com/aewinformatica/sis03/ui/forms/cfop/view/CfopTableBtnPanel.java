package com.aewinformatica.sis03.ui.forms.cfop.view;

import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class CfopTableBtnPanel extends JPanel {
	


	private static final long serialVersionUID = 1L;
    	
	private JButton addBtn;
    private JButton removeBtn;
    private String BTN_ADD;
    private String BTN_REMOVE;
    private ResourceBundle rb;
    

    public CfopTableBtnPanel() {

    	rb = LocaleUtils.getRb();
    	BTN_ADD = rb.getString("Labels.BTN_ADD");
    	BTN_REMOVE = rb.getString("Labels.BTN_REMOVE");
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(BTN_ADD);
        add(addBtn);

        removeBtn = new JButton(BTN_REMOVE);
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}
