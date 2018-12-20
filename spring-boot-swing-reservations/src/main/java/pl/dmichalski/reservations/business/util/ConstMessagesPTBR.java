package pl.dmichalski.reservations.business.util;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ptbr")
@Component
public class ConstMessagesPTBR implements ConstMessages {

	
	public interface DialogTitles {
        String CLIENT_MODAL = "Adicionar cliente";
        String ADDRESS_MODAL = "Adding address";
        String PAYMENT_METHOD_MODAL = "Adding payment methods";
        String PAYMENT_MODAL = "Adding payments";
        String RESERVATION_MODAL = "Adding reservations";
        String ROOM_STATUS_MODAL = "Adding room statuses";
        String ROOM_TYPE_MODAL = "Adding room types";
        String ROOM_MODAL = "Adding rooms";
        String RATE_MODAL = "Adding rates";
        String ROOM_X_RESERVATION_MODAL = "Adding room reservations";
    }

    public interface Messages {
        String WINDOWS_STYLE_LOADING_ERROR_MESSAGE = "There was an error while loading windows look an feel: ";
        String ALERT_TILE = "Alert";
        String NON_ROW_SELECTED = "Non row has been selected";
        String INFORMATION_TITLE = "Information";
        String DELETE_ROW_ERROR = "Could not delete a row. Check if there are any connections between tables.";
    }

    public interface Labels {
        String MAIN_MENU = "Reservas de Hotel";
        String CLIENTS = "Clientes";
        String RESERVATIONS = "Reservas";
        String ADDRESSES = "Endereço";
        String ADD_BTN = "Adicionar";
        String CANCEL_BTN = "Cancelar";
        String REMOVE_BTN = "Remover";
        String NAME = "Nome";
        String SURNAME = "Surname";
        String PESEL = "Pesel";
        String PHONE_NUMBER = "Telefone";
        String EMAIL = "E-mail";
        String ADDRESS = "Endereço";
        String STREET = "Rua";
        String HOUSE_NUMBER = "Numero da Casa";
        String FLAT_NUMBER = "Numero do Apto";
        String CITY = "Cidade";
        String POSTAL_CODE = "CEP";
        String RESERVATION_STATUS = "Status da Reserva";
        String RESERVATION_STATUSES = "Reservation statuses";
        String PAYMENT_METHODS = "Metodo de Pagamento";
        String PAYMENTS = "Pagamentos";
        String PAYMENT_METHOD = "Payment method";
        String VALUE = "Value";
        String DATE_OF_PAYMENT = "Date of payment";
        String PAYMENT = "Payment";
        String CLIENT = "Client";
        String FROM_DATE = "From";
        String TO_DATE = "To";
        String RESERVATION_DATE = "Reservation date";
        String AMOUNT = "Suma";
        String ROOM_STATUS = "Room status";
        String ROOM_STATUSES = "Room statuses";
        String ROOM_STATUS_DESCRIPTION = "Room status description";
        String ROOM_TYPE = "Room type";
        String ROOM_MULTIPLIER = "Multiplier";
        String ROOM_TYPES = "Room types";
        String ROOM_TYPE_DESCRIPTION = "Room type description";
        String ROOM_NUMBER_OF_PEOPLE = "Number of people";
        String ROOM_DESCRIPTION = "Description";
        String ROOMS = "Rooms";
        String ROOM = "Room";
        String BASIC_RATE = "Basic rate";
        String RATES = "Rates";
        String ROOM_X_RESERVATIONS = "Rooms reservations";
        String RESERVATION = "Reservation";
        String PRICE = "Price";
        String FORMS = "Forms";
        String REPORTS = "Raports";
        String PAYMENT_COUNT = "Payment coun";
        String NUMBER_OF_COUNT = "Number of count";
        String NUMBER_OF_RESERVATIONS = "Number of reservations";
        String CLIENT_RESERVATIONS = "Client's reservations";
    }

    public interface ValidationMessages {
        String REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA = "Not all required fields have been filled or filled data is incorrect";
        String PESEL_LENGTH_INCORRECT = "PESEL should contain 11 characters.";
        String DATE_FROM_MUST_BE_EARLIER_THAN_TO_DATE = "Date from must be earlier than date to";
    }
}
