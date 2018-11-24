package com.aewinformatica.sis03.ui.forms.cliente.view.modal;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddClienteFrame extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private FormPanel formPanel;
    private FormBtnPanel formBtnPanel;
    
    
    @Autowired
    public AddClienteFrame(FormPanel formPanel,FormBtnPanel formBtnPanel) {
		this.formPanel = formPanel;
		this.formBtnPanel = formBtnPanel;
		
        setFrameUp();
        initComponents();
        pack();
	}

	private void setFrameUp() {
        setTitle("DialogTitles.CLIENT_MODAL");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }
    
    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }
	
    public FormPanel getFormPanel() {
        return formPanel;
    }

    public FormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }

}
