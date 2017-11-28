package com.zc.myboot.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author: zc
 * @date: 2017/11/29
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    String values();
    String message() default "flag 不存在";


    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
