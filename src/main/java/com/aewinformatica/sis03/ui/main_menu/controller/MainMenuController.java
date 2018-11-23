package com.aewinformatica.sis03.ui.main_menu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aewinformatica.sis03.ui.main_menu.view.MainMenuFrame;
import com.aewinformatica.sis03.ui.shared.controller.AbstractFrameController;

@Controller
public class MainMenuController extends AbstractFrameController {
	
	private MainMenuFrame mainMenuFrame;
	
	@Autowired
	public MainMenuController(MainMenuFrame mainMenuFrame) {
		this.mainMenuFrame = mainMenuFrame;
	}

	@Autowired
	public void prepareAndOpenFrame() {
		mainMenuFrame.setVisible(true);		
	}

}