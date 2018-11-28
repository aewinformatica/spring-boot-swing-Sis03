package com.aewinformatica.sis03.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aewinformatica.sis03.ui.forms.cfop.controller.CfopController;
import com.aewinformatica.sis03.ui.forms.cliente.controller.ClienteController;
import com.aewinformatica.sis03.ui.main_menu.view.MainMenuFrame;
import com.aewinformatica.sis03.ui.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {
	
	private MainMenuFrame mainMenuFrame;
	private ClienteController clienteController;
	private CfopController cfopController;
	
	@Autowired
	public MainMenuController(MainMenuFrame mainMenuFrame, ClienteController clienteController, CfopController cfopController) {
		this.mainMenuFrame = mainMenuFrame;
		this.clienteController = clienteController;
		this.cfopController = cfopController;
	}

	@Autowired
	public void prepareAndOpenFrame() {
		registerAction(mainMenuFrame.getBotao_adicionar(), (e) -> openFormClienteWindow());
		registerAction(mainMenuFrame.getBotao_cfops(), (e) -> openFormCfopWindow());
		mainMenuFrame.setVisible(true);		
	}
	
    private void openFormClienteWindow() {
        clienteController.prepareAndOpenFrame();
    }
    private void openFormCfopWindow() {
        cfopController.prepareAndOpenFrame();
    }

}