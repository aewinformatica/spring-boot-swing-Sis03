package com.aewinformatica.sis03.ui.forms.cliente.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.ui.forms.cliente.model.ClienteTableModel;

@Component
public class ClienteTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ClienteTableModel clienteTableModel;
    private JTable clienteTable;
    
    @Autowired
	public ClienteTablePanel(ClienteTableModel clienteTableModel) {
		this.clienteTableModel = clienteTableModel;
        setPanelUp();
        initComponents();
	}

	private void initComponents() {
		
		clienteTable = new JTable(clienteTableModel);
        clienteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(clienteTable);
        add(paneWithTable, BorderLayout.CENTER);
		
	}

	private void setPanelUp() {
		setLayout(new BorderLayout());
	}
	
	public JTable getClienteTable() {
		return clienteTable;
	}
    
    
    
    

}
