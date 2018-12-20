package com.aewinformatica.sis03.ui.forms.cliente.model;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cliente;
import com.aewinformatica.sis03.ui.shared.view.DefaultTableModel;

@Component
public class ClienteTableModel extends DefaultTableModel<Cliente> {

	private static final long serialVersionUID = 1L;
	private String constNome = "Nome";

	@Override
    public String[] getColumnLabels() {
        return new String[]{
        		constNome
                };
    }


	 @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        Cliente cliente = entities.get(rowIndex);

	        switch (columnIndex) {
	            case 0:
	                return cliente.getNome();
	            default:
	                return "";
	        }
	    }

}
