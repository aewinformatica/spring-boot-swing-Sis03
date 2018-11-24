package com.aewinformatica.sis03.util;

import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class LookAndFeelUtils {


	public static void setWindowsLookAndFeel() {
		ResourceBundle rb = LocaleUtils.getRb();
		
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    rb.getString("WINDOWS_STYLE_LOADING_ERROR_MESSAGE") + e,
                    rb.getString("ALERT_TILE"),
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
