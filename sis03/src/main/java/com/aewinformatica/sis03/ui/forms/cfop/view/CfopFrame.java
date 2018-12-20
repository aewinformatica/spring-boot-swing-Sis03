package com.aewinformatica.sis03.ui.forms.cfop.view;

import java.awt.BorderLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class CfopFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private ResourceBundle rb;

	private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;
    
    private CfopTablePanel cfopTablePanel;
    private CfopTableBtnPanel tableBtnPanel;
    
    @Autowired
	public CfopFrame(CfopTablePanel cfopTablePanel, CfopTableBtnPanel tableBtnPanel) {
		this.cfopTablePanel = cfopTablePanel;
		this.tableBtnPanel = tableBtnPanel;
		
    	rb = LocaleUtils.getRb();
		
		setFrameUp();
		initComponents();
	}
    
    
    private void setFrameUp() {
        setTitle(rb.getString("title.CFOP"));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(cfopTablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }
    
    public CfopTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public CfopTablePanel getTablePanel() {
        return cfopTablePanel;
    }
    
    

}
