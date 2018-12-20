package pl.dmichalski.reservations.business.ui.forms.room.view.modal;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class RoomFormBtnPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton saveBtn;
    private JButton cancelBtn;

    public RoomFormBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessages.Labels.ADD_BTN);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessages.Labels.CANCEL_BTN);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

}
