package pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.modal;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.entity.RoomXReservation;
import pl.dmichalski.reservations.business.entity.RoomXReservationPK;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.model.ReservationsComboBoxModel;
import pl.dmichalski.reservations.business.util.Borders;
import pl.dmichalski.reservations.business.util.ConstMessages;

@Component
public class RoomXReservationFormPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int LAYOUT_ROWS = 3;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JComboBox<Reservation> reservationCB;
    private JComboBox<Room> roomCB;
    private JTextField priceTF;

    private ReservationsComboBoxModel reservationsComboBoxModel;
    private RoomComboBoxModel roomComboBoxModel;

    @Autowired
    public RoomXReservationFormPanel(ReservationsComboBoxModel reservationsComboBoxModel, RoomComboBoxModel roomComboBoxModel) {
        this.reservationsComboBoxModel = reservationsComboBoxModel;
        this.roomComboBoxModel = roomComboBoxModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel reservationLbl = new JLabel(ConstMessages.Labels.RESERVATION);
        JLabel roomLbl = new JLabel(ConstMessages.Labels.ROOM);
        JLabel priceLbl = new JLabel(ConstMessages.Labels.PRICE);

        reservationCB = new JComboBox<>(reservationsComboBoxModel);
        roomCB = new JComboBox<>(roomComboBoxModel);
        priceTF= new JTextField(TEXT_FIELD_COLUMNS);

        add(reservationLbl);
        add(reservationCB);
        add(roomLbl);
        add(roomCB);
        add(priceLbl);
        add(priceTF);
    }

    public RoomXReservation getEntityFromForm() {
        Room room = roomComboBoxModel.getSelectedItem();
        Reservation reservation = reservationsComboBoxModel.getSelectedItem();
        RoomXReservation roomXReservation = new RoomXReservation(new RoomXReservationPK(room, reservation));
        try {
            roomXReservation.setRoomPrice(Long.parseLong(priceTF.getText()));
        } catch (NumberFormatException ignored) {}
        return roomXReservation;
    }

    public void clearForm() {
        priceTF.setText("");
    }

}
