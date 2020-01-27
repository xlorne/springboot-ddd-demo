package com.alibaba.cola.test.customer.interceptor;

import com.alibaba.cola.executor.ExecutorInterceptorI;
import com.alibaba.cola.executor.PreInterceptor;
import com.alibaba.cola.dto.Command;
import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.validator.ColaMessageInterpolator;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * ValidationInterceptor
 *
 * @author Frank Zhang 2018-01-06 8:27 PM
 */
@PreInterceptor
public class ValidationInterceptor implements ExecutorInterceptorI {

    //Enable fail fast, which will improve performance
    private ValidatorFactory factory = Validation.byProvider(HibernateValidator.class).configure().failFast(true)
            .messageInterpolator(new ColaMessageInterpolator()).buildValidatorFactory();

    @Override
    public void preIntercept(Command command) {
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Command>> constraintViolations = validator.validate(command);
        constraintViolations.forEach(violation -> {
            throw new BizException(violation.getPropertyPath() + " " + violation.getMessage());
        });
    }
}