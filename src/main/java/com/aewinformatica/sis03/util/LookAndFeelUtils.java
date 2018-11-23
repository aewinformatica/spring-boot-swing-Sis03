package com.aewinformatica.sis03.util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class LookAndFeelUtils {

static String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "Ocorreu um erro ao carregar a aparência e a sensação do Windows:";
static String ALERT_TILE = "Alerta";
	
	
	
	public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    WINDOWS_STYLE_LOADING_ERROR_MESSAGE + e,
                    ALERT_TILE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
