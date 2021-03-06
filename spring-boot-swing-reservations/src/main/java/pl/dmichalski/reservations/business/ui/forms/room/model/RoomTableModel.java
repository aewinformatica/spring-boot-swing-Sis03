package pl.dmichalski.reservations.business.ui.forms.room.model;

import org.springframework.stereotype.Component;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.ui.shared.model.DefaultTableModel;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.ConstMessagesEN;

@Component
public class RoomTableModel extends DefaultTableModel<Room> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room room = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return room.getRoomStatus();
            case 1:
                return room.getNumberOfPeople();
            case 2:
                return room.getDescription();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessages.Labels.ROOM_STATUS,
                ConstMessages.Labels.ROOM_NUMBER_OF_PEOPLE,
                ConstMessages.Labels.ROOM_DESCRIPTION};
    }
}
