package com.estudos.repositories;

import javax.validation.Validation;
import javax.validation.Validator;

public class EntityValidator {

	public void validate(Object obj) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		//UserNotBlank user = new UserNotBlank(" ");
		validator.validate(obj).stream().forEach(violation -> System.out.println(violation.getMessage()));
	}
}
