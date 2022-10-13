package com.study.design.pattern.combinator;

import java.util.function.Function;

public interface CustomerValidator extends Function<Customer, CustomerValidator.Result>{
    static CustomerValidator emailValidator(){
        System.out.println("emailValidator...");
        return customer-> customer.getEmail().contains("@")?Result.SUCCESS:Result.EMAIL_NOT_VALID;
    }

    static CustomerValidator phoneValidator(){
        System.out.println("phoneValidator...");
        return customer -> customer.getPhone().length()==11?Result.SUCCESS:Result.PHONE_NOT_VALID;
    }

    static CustomerValidator nameValidator(){
        System.out.println("nameValidator...");
        return customer -> !customer.getName().contains(" ")?Result.SUCCESS:Result.NAME_NOT_VALID;
    }

    default CustomerValidator and(CustomerValidator other){
        return customer -> {
            Result result = this.apply(customer);
            return result.equals(Result.SUCCESS) ? other.apply(customer):result;
        };
    }

    enum Result{
        SUCCESS,
        EMAIL_NOT_VALID,
        PHONE_NOT_VALID,
        NAME_NOT_VALID;
    }

}
