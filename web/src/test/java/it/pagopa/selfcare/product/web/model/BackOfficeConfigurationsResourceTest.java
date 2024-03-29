package it.pagopa.selfcare.product.web.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static it.pagopa.selfcare.commons.utils.TestUtils.mockInstance;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackOfficeConfigurationsResourceTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void validateNullFields() {
        // given
        HashMap<String, Class<? extends Annotation>> toCheckMap = new HashMap<>();
        toCheckMap.put("url", NotBlank.class);
        toCheckMap.put("identityTokenAudience", NotBlank.class);
        BackOfficeConfigurationsResource productResource = new BackOfficeConfigurationsResource();
        // when
        Set<ConstraintViolation<Object>> violations = validator.validate(productResource);
        // then
        List<ConstraintViolation<Object>> filteredViolations = violations.stream()
                .filter(violation -> {
                    Class<? extends Annotation> annotationToCheck = toCheckMap.get(violation.getPropertyPath().toString());
                    return !violation.getConstraintDescriptor().getAnnotation().annotationType().equals(annotationToCheck);
                })
                .collect(Collectors.toList());
        assertTrue(filteredViolations.isEmpty(), filteredViolations.toString());
    }

    @Test
    void validateNotNullFields() {
        // given
        BackOfficeConfigurationsResource resource = mockInstance(new BackOfficeConfigurationsResource());
        // when
        Set<ConstraintViolation<Object>> violations = validator.validate(resource);
        // then
        assertTrue(violations.isEmpty(), violations.toString());
    }

}