package com.aewinformatica.sis03.ui.forms.cfop.view.modal;

import java.awt.BorderLayout;
import java.util.ResourceBundle;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class AddCfopFrame extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private CfopFormPanel formPanel;
    private CfopFormBtnPanel formBtnPanel;
    private ResourceBundle rb;
    private String TITLE;
    
    
    @Autowired
    public AddCfopFrame(CfopFormPanel formPanel,CfopFormBtnPanel formBtnPanel) {
		this.formPanel = formPanel;
		this.formBtnPanel = formBtnPanel;
		
		rb = LocaleUtils.getRb();
		TITLE = rb.getString("DialogTitles.CFOP_MODAL");
		
        setFrameUp();
        initComponents();
        pack();
	}

	private void setFrameUp() {
        setTitle(TITLE);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
//        setSize(50,50);
//        setLocationRelativeTo(null);
        setBounds(50,50,50,50);
        setResizable(false);
        setModal(true);
    }
    
    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }
	
    public CfopFormPanel getFormPanel() {
        return formPanel;
    }

    public CfopFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }

}
