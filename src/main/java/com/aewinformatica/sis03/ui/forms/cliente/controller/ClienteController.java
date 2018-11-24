package com.aewinformatica.sis03.ui.forms.cliente.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aewinformatica.sis03.entity.Cliente;
import com.aewinformatica.sis03.service.ClienteService;
import com.aewinformatica.sis03.ui.forms.cliente.model.ClienteTableModel;
import com.aewinformatica.sis03.ui.forms.cliente.view.ClienteFrame;
import com.aewinformatica.sis03.ui.forms.cliente.view.TableBtnPanel;
import com.aewinformatica.sis03.ui.forms.cliente.view.modal.AddClienteFrame;
import com.aewinformatica.sis03.ui.forms.cliente.view.modal.FormBtnPanel;
import com.aewinformatica.sis03.ui.forms.cliente.view.modal.FormPanel;
import com.aewinformatica.sis03.ui.shared.controller.AbstractFrameController;
import com.aewinformatica.sis03.util.Notifications;
import com.aewinformatica.sis03.validation.ClienteValidator;
import com.aewinformatica.sis03.validation.ValidationError;


@Controller
public class ClienteController extends AbstractFrameController {
	
	private ClienteFrame clienteFrame;
	private AddClienteFrame addClienteFrame;
	private ClienteTableModel clienteTableModel;
	private ClienteService clienteService;
	private ClienteValidator clienteValidator;
	
	
	@Autowired
	public ClienteController(ClienteFrame clienteFrame, AddClienteFrame addClienteFrame,
			ClienteTableModel clienteTableModel, ClienteService clienteService, ClienteValidator clienteValidator) {
		this.clienteFrame = clienteFrame;
		this.addClienteFrame = addClienteFrame;
		this.clienteTableModel = clienteTableModel;
		this.clienteService = clienteService;
		this.clienteValidator = clienteValidator;
	}

    @PostConstruct
    private void prepareListeners() {
        TableBtnPanel tableBtnPanel = clienteFrame.getTableBtnPanel();
        FormBtnPanel formBtnPanel = addClienteFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddClienteModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeCliente());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveCliente());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }


	@Override
	public void prepareAndOpenFrame() {
		 loadClientes();
		 showClientesFrame();
		
	}
	
    private void loadClientes() {
        List<Cliente> clientes = clienteService.findAll();
        clienteTableModel.clear();
        clienteTableModel.addEntities(clientes);
    }
    
    private void showClientesFrame() {
        clienteFrame.setVisible(true);
    }
    
    private void showAddClienteModal() {
        addClienteFrame.setVisible(true);
    }
    
    private void saveCliente() {
        FormPanel formPanel = addClienteFrame.getFormPanel();
        Cliente cliente = formPanel.getClienteFromForm();
        Optional<ValidationError> errors = clienteValidator.validate(cliente);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            clienteService.salvar(cliente);
            clienteTableModel.addEntity(cliente);
            closeModalWindow();
        }
    }
    
    private void closeModalWindow() {
        addClienteFrame.getFormPanel().clearForm();
        addClienteFrame.dispose();
    }
    
    private void removeCliente() {
        try {
            JTable clientTable = clienteFrame.getTablePanel().getClienteTable();
            int selectedRow = clientTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        "Messages.NON_ROW_SELECTED",
                        "Messages.ALERT_TILE",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Cliente cliente = clienteTableModel.getEntityByRow(selectedRow);
                clienteService.remover(cliente);
                clienteTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}
