package pl.dmichalski.reservations.business.ui.forms.client.view.modal;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class AddClientFrame extends JDialog {

	private static final long serialVersionUID = 1L;

	private FormPanel formPanel;
    private FormBtnPanel formBtnPanel;

    @Autowired
    public AddClientFrame(FormPanel formPanel, FormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessages.DialogTitles.CLIENT_MODAL);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public FormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}
