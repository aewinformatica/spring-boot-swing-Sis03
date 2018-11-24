package com.aewinformatica.sis03.ui.forms.cliente.view.modal;

import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class FormBtnPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton saveBtn;
    private JButton cancelBtn;
    private String BTN_ADD;
    private String BTN_CANCEL;
    
    private ResourceBundle rb;

    public FormBtnPanel() {
    	rb = LocaleUtils.getRb();
    	BTN_ADD = rb.getString("Labels.BTN_ADD");
    	BTN_CANCEL = rb.getString("Labels.BTN_CANCEL");
    	
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(BTN_ADD);
        add(saveBtn);

        cancelBtn = new JButton(BTN_CANCEL);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}
