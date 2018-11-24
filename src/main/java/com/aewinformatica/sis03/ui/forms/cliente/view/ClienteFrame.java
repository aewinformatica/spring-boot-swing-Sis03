package com.aewinformatica.sis03.ui.forms.cliente.view;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Locale locale;
	private ResourceBundle rb;

	private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 340;
    
    private ClienteTablePanel clienteTablePanel;
    private TableBtnPanel tableBtnPanel;
    
    @Autowired
	public ClienteFrame(ClienteTablePanel clienteTablePanel, TableBtnPanel tableBtnPanel) {
		this.clienteTablePanel = clienteTablePanel;
		this.tableBtnPanel = tableBtnPanel;
		
		locale = new Locale("pt_BR");
    	rb = ResourceBundle.getBundle("com.aewinformatica.sis03.resources.content", locale);
		
		setFrameUp();
		initComponents();
	}
    
    
    private void setFrameUp() {
        setTitle(rb.getString("Labels.CLIENTS"));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(clienteTablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }
    
    public TableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public ClienteTablePanel getTablePanel() {
        return clienteTablePanel;
    }
    
    

}
