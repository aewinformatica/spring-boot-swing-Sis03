package com.aewinformatica.sis03.ui.forms.cliente.view.modal;

import java.awt.BorderLayout;
import java.util.ResourceBundle;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class AddClienteFrame extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private ClienteFormPanel formPanel;
    private ClienteFormBtnPanel formBtnPanel;
    private ResourceBundle rb;
    private String TITLE;
    
    
    @Autowired
    public AddClienteFrame(ClienteFormPanel formPanel,ClienteFormBtnPanel formBtnPanel) {
		this.formPanel = formPanel;
		this.formBtnPanel = formBtnPanel;
		
		rb = LocaleUtils.getRb();
		TITLE = rb.getString("DialogTitles.CLIENT_MODAL");
		
        setFrameUp();
        initComponents();
        pack();
	}

	private void setFrameUp() {
        setTitle(TITLE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(50,50);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }
    
    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }
	
    public ClienteFormPanel getFormPanel() {
        return formPanel;
    }

    public ClienteFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }

}
