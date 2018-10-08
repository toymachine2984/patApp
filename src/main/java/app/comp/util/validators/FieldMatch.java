package app.comp.util.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(value = {ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(value = RUNTIME)
@Constraint(validatedBy = FieldMatchesValidator.class)
public @interface FieldMatch {

    String message() default "Password don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    String first();
    String second();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List
    {
        FieldMatch[] value();
    }
}
