package com.aewinformatica.sis03.util;

import javax.swing.*;

public class Notifications {

    public static void showFormValidationAlert(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                "Messages.INFORMATION_TITLE",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                "rb Messages.NON_ROW_SELECTED",
                "rb ALERT_TILE",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                "rb Messages.DELETE_ROW_ERROR",
                "rb Messages.ALERT_TILE",
                JOptionPane.ERROR_MESSAGE);
    }
}
