package com.aewinformatica.sis03.ui.forms.cliente.view;

import java.awt.BorderLayout;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.util.LocaleUtils;

@Component
public class ClienteFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private ResourceBundle rb;

	private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;
    
    private ClienteTablePanel clienteTablePanel;
    private ClienteTableBtnPanel tableBtnPanel;
    
    @Autowired
	public ClienteFrame(ClienteTablePanel clienteTablePanel, ClienteTableBtnPanel tableBtnPanel) {
		this.clienteTablePanel = clienteTablePanel;
		this.tableBtnPanel = tableBtnPanel;
		
    	rb = LocaleUtils.getRb();
		
		setFrameUp();
		initComponents();
	}
    
    
    private void setFrameUp() {
        setTitle(rb.getString("title.CLIENTS"));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(clienteTablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }
    
    public ClienteTableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public ClienteTablePanel getTablePanel() {
        return clienteTablePanel;
    }
    
    

}
