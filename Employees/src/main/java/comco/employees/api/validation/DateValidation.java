package comco.employees.api.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import comco.employees.api.constants.EmployeesConstants;

import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BirthdateValidator.class)
public @interface DateValidation {

    String message() default EmployeesConstants.AGE_NOT_ALLOWED;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
