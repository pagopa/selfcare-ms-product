package it.pagopa.selfcare.product.web.model;

import it.pagopa.selfcare.commons.utils.TestUtils;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UpdateSubProductDtoTest {
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
        toCheckMap.put("title", NotBlank.class);
        toCheckMap.put("contractTemplatePath", NotBlank.class);
        toCheckMap.put("contractTemplateVersion", NotBlank.class);
        UpdateSubProductDto updateSubProductDto = new UpdateSubProductDto();
        updateSubProductDto.setTitle(null);
        updateSubProductDto.setContractTemplatePath(null);
        updateSubProductDto.setContractTemplateVersion(null);
        // when
        Set<ConstraintViolation<Object>> violations = validator.validate(updateSubProductDto);
        // then
        assertFalse(violations.isEmpty());
        List<ConstraintViolation<Object>> filteredViolations = violations.stream()
                .filter(violation -> {
                    Class<? extends Annotation> annotationToCheck = toCheckMap.get(violation.getPropertyPath().toString());
                    return !violation.getConstraintDescriptor().getAnnotation().annotationType().equals(annotationToCheck);
                })
                .collect(Collectors.toList());
        assertTrue(filteredViolations.isEmpty());
    }

    @Test
    void validateNotNullFields() {
        //given
        UpdateSubProductDto subProductDto = TestUtils.mockInstance(new UpdateSubProductDto());
        //when
        Set<ConstraintViolation<Object>> violations = validator.validate(subProductDto);
        // then
        assertTrue(violations.isEmpty());
    }
}