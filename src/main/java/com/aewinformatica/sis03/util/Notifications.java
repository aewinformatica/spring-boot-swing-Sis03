package com.aewinformatica.sis03.util;

import java.util.ResourceBundle;

import javax.swing.*;

public class Notifications {
	
	private static ResourceBundle rb;

	
	

    public static void showFormValidationAlert(String message) {
    	rb = LocaleUtils.getRb();
        JOptionPane.showMessageDialog(null,
                message,
                rb.getString("Messages.INFORMATION_TITLE"),
                JOptionPane.INFORMATION_MESSAGE );
    }

    public static void showTableRowNotSelectedAlert() {
    	rb = LocaleUtils.getRb();
        JOptionPane.showMessageDialog(null,
        		rb.getString("Messages.NON_ROW_SELECTED"),
        		rb.getString("Messages.ALERT_TILE"),
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
    	rb = LocaleUtils.getRb();
        JOptionPane.showMessageDialog(null,
        		rb.getString("Messages.DELETE_ROW_ERROR"),
        		rb.getString("Messages.ALERT_TILE"),
                JOptionPane.ERROR_MESSAGE);
    }
}
