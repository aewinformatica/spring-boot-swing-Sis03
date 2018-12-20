package pl.dmichalski.reservations.business.ui.forms.room_type.view.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

import javax.swing.*;
import java.awt.*;

@Component
public class AddRoomTypeFrame extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RoomTypeFormPanel formPanel;
    private RoomTypeFormBtnPanel formBtnPanel;

    @Autowired
    public AddRoomTypeFrame(RoomTypeFormPanel formPanel, RoomTypeFormBtnPanel formBtnPanel) {
        this.formPanel = formPanel;
        this.formBtnPanel = formBtnPanel;
        setFrameUp();
        initComponents();
        pack();
    }

    private void setFrameUp() {
        setTitle(ConstMessages.DialogTitles.ROOM_TYPE_MODAL);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(formPanel, BorderLayout.CENTER);
        add(formBtnPanel, BorderLayout.SOUTH);
    }

    public RoomTypeFormPanel getFormPanel() {
        return formPanel;
    }

    public RoomTypeFormBtnPanel getFormBtnPanel() {
        return formBtnPanel;
    }
}
