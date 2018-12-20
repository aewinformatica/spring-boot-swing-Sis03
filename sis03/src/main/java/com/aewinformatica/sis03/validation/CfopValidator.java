package com.aewinformatica.sis03.validation;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cfop;

@Component
public class CfopValidator extends ValidationSupport implements Validator<Cfop> {


		
    @Override
    public Optional<ValidationError> validate(Cfop cfop) {
        if (    
        		isNullValue(cfop.getCfop())||
                
        		isNullOrEmptyString(cfop.getDescricao())||
//                isNullOrEmptyString(cfop.getObservacao())||
                
                isNullValue(cfop.isFaturamento())||
                isNullValue(cfop.isFinanceiro())||
                isNullValue(cfop.getSeqcfop())||
                
                isNullOrEmptyString(cfop.getOperacao())
        	
        		) {
//TODO            return Optional.of(new ValidationError(REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA)); 
            return Optional.of(new ValidationError("REQUIRED_DATA_NOT_FILLED_OR_BAD_DATA"));
        }

        return Optional.empty();
    }



}