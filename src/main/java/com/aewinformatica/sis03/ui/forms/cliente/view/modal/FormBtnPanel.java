package com.aewinformatica.sis03.ui.forms.cliente.view.modal;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class FormBtnPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JButton saveBtn;
    private JButton cancelBtn;

    public FormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton("Labels.ADD_BTN");
        add(saveBtn);

        cancelBtn = new JButton("Labels.CANCEL_BTN");
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}
