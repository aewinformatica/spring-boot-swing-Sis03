package com.aewinformatica.sis03.ui.forms.cfop.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.ui.forms.cfop.model.CfopTableModel;

@Component
public class CfopTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private CfopTableModel cfopTableModel;
    private JTable cfopTable;
    
    @Autowired
	public CfopTablePanel(CfopTableModel cfopTableModel) {
		this.cfopTableModel = cfopTableModel;
        setPanelUp();
        initComponents();
	}

	private void initComponents() {
		
		cfopTable = new JTable(cfopTableModel);
        cfopTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(cfopTable);
        add(paneWithTable, BorderLayout.CENTER);
		
	}

	private void setPanelUp() {
		setLayout(new BorderLayout());
	}


	public JTable getCfopTable() {
		// TODO Auto-generated method stub
		return cfopTable;
	}
    
    
    
    

}
