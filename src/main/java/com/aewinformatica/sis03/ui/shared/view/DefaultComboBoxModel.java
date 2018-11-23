package com.aewinformatica.sis03.ui.shared.view;

import java.util.List;

public abstract class DefaultComboBoxModel<T> extends javax.swing.DefaultComboBoxModel<T> {


	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
    public T getSelectedItem() {
        return (T) super.getSelectedItem();
    }

    public void addElements(List<T> elements) {
        elements.forEach(this::addElement);
    }

    public void clear() {
        removeAllElements();
    }

}
