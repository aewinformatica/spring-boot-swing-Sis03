package pl.dmichalski.reservations.business.ui.forms.address.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class AddressTableBtnPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addBtn;
    private JButton removeBtn;

    public AddressTableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        addBtn = new JButton(ConstMessages.Labels.ADD_BTN);
        add(addBtn);

        removeBtn = new JButton(ConstMessages.Labels.REMOVE_BTN);
        add(removeBtn);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}