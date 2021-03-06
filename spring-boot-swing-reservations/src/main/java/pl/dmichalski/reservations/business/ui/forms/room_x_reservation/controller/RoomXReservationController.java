package pl.dmichalski.reservations.business.ui.forms.room_x_reservation.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pl.dmichalski.reservations.business.entity.Reservation;
import pl.dmichalski.reservations.business.entity.Room;
import pl.dmichalski.reservations.business.entity.RoomXReservation;
import pl.dmichalski.reservations.business.service.ReservationService;
import pl.dmichalski.reservations.business.service.RoomService;
import pl.dmichalski.reservations.business.service.RoomXReservationService;
import pl.dmichalski.reservations.business.ui.forms.rate.model.RoomComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.model.ReservationsComboBoxModel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.model.RoomXReservationTableModel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.RoomXReservationTableBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.RoomXReservationTableFrame;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.modal.AddRoomXReservationFame;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.modal.RoomXReservationFormBtnPanel;
import pl.dmichalski.reservations.business.ui.forms.room_x_reservation.view.modal.RoomXReservationFormPanel;
import pl.dmichalski.reservations.business.ui.shared.controller.AbstractFrameController;
import pl.dmichalski.reservations.business.util.ConstMessages;
import pl.dmichalski.reservations.business.util.Notifications;
import pl.dmichalski.reservations.business.validation.RoomXReservationValidator;
import pl.dmichalski.reservations.business.validation.ValidationError;

@Controller
public class RoomXReservationController extends AbstractFrameController {

    private RoomXReservationTableFrame tableFrame;
    private AddRoomXReservationFame addFrame;
    private RoomXReservationTableModel tableModel;
    private RoomXReservationService roomXReservationService;
    private ReservationService reservationService;
    private RoomService roomService;
    private ReservationsComboBoxModel reservationsComboBoxModel;
    private RoomComboBoxModel roomComboBoxModel;
    private RoomXReservationValidator validator;

    @Autowired
    public RoomXReservationController(RoomXReservationTableFrame tableFrame,
                                      AddRoomXReservationFame addFrame,
                                      RoomXReservationTableModel tableModel,
                                      RoomXReservationService roomXReservationService,
                                      ReservationService reservationService,
                                      RoomService roomService,
                                      ReservationsComboBoxModel reservationsComboBoxModel,
                                      RoomComboBoxModel roomComboBoxModel,
                                      RoomXReservationValidator validator) {
        this.tableFrame = tableFrame;
        this.addFrame = addFrame;
        this.tableModel = tableModel;
        this.roomXReservationService = roomXReservationService;
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.reservationsComboBoxModel = reservationsComboBoxModel;
        this.roomComboBoxModel = roomComboBoxModel;
        this.validator = validator;
    }

    @PostConstruct
    private void prepareListeners() {
        RoomXReservationTableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        RoomXReservationFormBtnPanel formBtnPanel = addFrame.getFormBtnPanel();

        registerAction(tableBtnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(formBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(formBtnPanel.getCancelBtn(), (e) -> closeModalWindow());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadReservations();
        loadRooms();
        showTableFrame();
    }

    private void loadEntities() {
        List<RoomXReservation> entities = roomXReservationService.findAll();
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void loadRooms() {
        List<Room> entities = roomService.findAll();
        roomComboBoxModel.clear();
        roomComboBoxModel.addElements(entities);
    }

    private void loadReservations() {
        List<Reservation> entities = reservationService.findAll();
        reservationsComboBoxModel.clear();
        reservationsComboBoxModel.addElements(entities);
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void showAddModal() {
        addFrame.setVisible(true);
    }

    private void saveEntity() {
        RoomXReservationFormPanel formPanel = addFrame.getFormPanel();
        RoomXReservation entity = formPanel.getEntityFromForm();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showFormValidationAlert(validationError.getMessage());
        } else {
            roomXReservationService.save(entity);
            tableModel.addEntity(entity);
            closeModalWindow();
        }
    }

    private void closeModalWindow() {
        addFrame.getFormPanel().clearForm();
        addFrame.dispose();
    }

    private void removeEntity() {
        try {
            JTable table = tableFrame.getTablePanel().getTable();
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        ConstMessages.Messages.NON_ROW_SELECTED,
                        ConstMessages.Messages.ALERT_TILE,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                RoomXReservation entity = tableModel.getEntityByRow(selectedRow);
                roomXReservationService.remove(entity);
                tableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

}
