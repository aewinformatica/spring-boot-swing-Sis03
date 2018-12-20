package pl.dmichalski.reservations.business.ui.forms.payment_method.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.PaymentMethod;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class PaymentMethodTableModel extends DefaultTableModel<PaymentMethod> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentMethod paymentMethod = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return paymentMethod.getName();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.PAYMENT_METHOD};
    }
}
