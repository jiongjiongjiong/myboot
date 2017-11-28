package com.zc.myboot.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: zc
 * @date: 2017/11/29
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator,Object> {

    //临时变量保存flag值列表
    private String values;

    //初始化values的值
    @Override
    public void initialize(FlagValidator flagValidator) {
        this.values = flagValidator.values();
    }

    //实现验证
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String[] value_array = values.split(",");
        boolean isFlag = false;
        for (int i = 0; i < value_array.length; i++) {
            if ( value_array[i].equals(value)){
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }
}
