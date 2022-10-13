package com.study.design.pattern.combinator;

public class ValidatorExample {

    public static void main(String[] args) {
        Customer customer = new Customer("tom","tom@gmail.com","15824135598");
        CustomerValidator.Result result = CustomerValidator
            .emailValidator()
            .and(CustomerValidator.phoneValidator())
            .apply(customer);
        System.out.println(result);

        customer = new Customer("tom ","tom@gmail.com","15824135598");
        result = CustomerValidator
            .emailValidator()
            .and(CustomerValidator.phoneValidator())
            .and(CustomerValidator.nameValidator())
            .apply(customer);
        System.out.println(result);
    }
}
