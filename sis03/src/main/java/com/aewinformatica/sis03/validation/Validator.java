package com.aewinformatica.sis03.validation;

import java.util.Optional;

interface Validator <K> {

    Optional<ValidationError> validate(K k);

}
