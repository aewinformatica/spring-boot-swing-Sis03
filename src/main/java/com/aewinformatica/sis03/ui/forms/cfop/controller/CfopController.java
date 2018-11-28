package com.aewinformatica.sis03.ui.forms.cfop.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.service.CfopService;
import com.aewinformatica.sis03.ui.forms.cfop.model.CfopTableModel;
import com.aewinformatica.sis03.ui.forms.cfop.view.CfopFrame;
import com.aewinformatica.sis03.ui.forms.cfop.view.CfopTableBtnPanel;
import com.aewinformatica.sis03.ui.forms.cfop.view.modal.AddCfopFrame;
import com.aewinformatica.sis03.ui.forms.cfop.view.modal.CfopFormBtnPanel;
import com.aewinformatica.sis03.ui.forms.cfop.view.modal.CfopFormPanel;
import com.aewinformatica.sis03.ui.shared.controller.AbstractFrameController;
import com.aewinformatica.sis03.util.Notifications;
import com.aewinformatica.sis03.validation.CfopValidator;
import com.aewinformatica.sis03.validation.ValidationError;


@Controller
public class CfopController extends AbstractFrameController {
	
	private CfopFrame cfopFrame;
	private AddCfopFrame addCfopFrame;
	private CfopTableModel cfopTableModel;
	private CfopService cfopService;
	private CfopValidator cfopValidator;
	
	
	@Autowired
	public CfopController(CfopFrame cfopFrame, AddCfopFrame addCfopFrame,
			CfopTableModel cfopTableModel, CfopService cfopService, CfopValidator cfopValidator) {
		this.cfopFrame = cfopFrame;
		this.addCfopFrame = addCfopFrame;
		this.cfopTableModel = cfopTableModel;
		this.cfopService = cfopService;
		this.cfopValidator = cfopValidator;
	}

    @PostConstruct
    private void prepareListeners() {
        CfopTableBtnPanel tableBtnPanel = cfopFrame.getTableBtnPanel();
        CfopFormBtnPanel formBtnPanel = addCfopFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddCfopModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeCfop());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveCfop());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }


	@Override
	public void prepareAndOpenFrame() {
		 loadCfops();
		 showCfopsFrame();
		
	}
	
    private void loadCfops() {
        List<Cfop> cfops = cfopService.findAll();
        cfopTableModel.clear();
        cfopTableModel.addEntities(cfops);
    }
    
    private void showCfopsFrame() {
        cfopFrame.setVisible(true);
    }
    
    private void showAddCfopModal() {
        addCfopFrame.setVisible(true);
    }
    
    private void saveCfop() {
        CfopFormPanel formPanel = addCfopFrame.getFormPanel();
        Cfop cfop = formPanel.getCfopFromForm();
        Optional<ValidationError> errors = cfopValidator.validate(cfop);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            cfopService.salvar(cfop);
            cfopTableModel.addEntity(cfop);
            closeModalWindow();
        }
    }
    
    private void closeModalWindow() {
        addCfopFrame.getFormPanel().clearForm();
        addCfopFrame.dispose();
    }
    
    private void removeCfop() {
        try {
            JTable cfopTable = cfopFrame.getTablePanel().getCfopTable();
            int selectedRow = cfopTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        "Messages.NON_ROW_SELECTED",
                        "Messages.ALERT_TILE",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Cfop cfop = cfopTableModel.getEntityByRow(selectedRow);
                cfopService.remover(cfop);
                cfopTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}