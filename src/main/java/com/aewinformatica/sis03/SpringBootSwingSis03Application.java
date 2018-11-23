package com.aewinformatica.sis03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.aewinformatica.sis03.ui.main_menu.controller.MainMenuController;
import com.aewinformatica.sis03.util.LookAndFeelUtils;

@SpringBootApplication
public class SpringBootSwingSis03Application {

	public static void main(String[] args) {
		LookAndFeelUtils.setWindowsLookAndFeel();
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootSwingSis03Application.class,args);
		
        MainMenuController mainMenuController = context.getBean(MainMenuController.class);
        mainMenuController.prepareAndOpenFrame();
	}
}
