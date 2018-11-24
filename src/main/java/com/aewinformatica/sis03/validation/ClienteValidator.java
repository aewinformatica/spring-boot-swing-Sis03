package com.aewinformatica.sis03.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cliente;

@Component
public class ClienteValidator extends ValidationSupport implements Validator<Cliente> {


		
    @Override
    public Optional<ValidationError> validate(Cliente client) {
        if (isNullOrEmptyString(client.getNome())
        	
        		) {
//TODO            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA)); 
            return Optional.of(new ValidationError("REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA"));
        }

        return Optional.empty();
    }

}
