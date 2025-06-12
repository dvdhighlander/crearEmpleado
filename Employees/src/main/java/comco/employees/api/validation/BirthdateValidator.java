package comco.employees.api.validation;

import java.time.LocalDate;
import java.time.Period;

import comco.employees.api.constants.EmployeesConstants;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BirthdateValidator implements ConstraintValidator<DateValidation, LocalDate>{


    @Override
    public void initialize(DateValidation constraintAnnotation) {

    }
    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) {
            return true; 
        }
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(date, currentDate);

        if (period.getYears() >= 18) {
        	return true;
        }else {
        	 throw new IllegalArgumentException(EmployeesConstants.AGE_NOT_ALLOWED);
        }
}
}
