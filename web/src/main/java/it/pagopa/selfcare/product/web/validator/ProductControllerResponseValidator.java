package it.pagopa.selfcare.product.web.validator;

import it.pagopa.selfcare.commons.web.validator.ControllerResponseValidator;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validator;

@Aspect
@Component
public class ProductControllerResponseValidator extends ControllerResponseValidator {

    @Autowired
    public ProductControllerResponseValidator(Validator validator) {
        super(validator);
    }

    @Override
    @Pointcut("execution(* it.pagopa.selfcare.product.web.controller.*.*(..))")
    public void controllersPointcut() {
        // Do nothing because is a pointcut
    }

}
