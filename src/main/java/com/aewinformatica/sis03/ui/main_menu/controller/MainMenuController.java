package com.aewinformatica.sis03.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aewinformatica.sis03.ui.forms.cliente.controller.ClienteController;
import com.aewinformatica.sis03.ui.main_menu.view.MainMenuFrame;
import com.aewinformatica.sis03.ui.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {
	
	private MainMenuFrame mainMenuFrame;
	private ClienteController clienteController;
	
	@Autowired
	public MainMenuController(MainMenuFrame mainMenuFrame, ClienteController clienteController) {
		this.mainMenuFrame = mainMenuFrame;
		this.clienteController = clienteController;
	}

	@Autowired
	public void prepareAndOpenFrame() {
		registerAction(mainMenuFrame.getFormsBtnAdicionar(), (e) -> openFormClienteWindow());
		mainMenuFrame.setVisible(true);		
	}
	
    private void openFormClienteWindow() {
        clienteController.prepareAndOpenFrame();
    }

}