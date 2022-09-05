package com.study.function.basic;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @see {https://mkyong.com/java8/java-8-binaryoperator-examples/}
 */
public class BinaryOperatorExample {
    public static <T> T calc(List<T> list,T init, BinaryOperator<T> operator){
        T result = init;
        for(T item : list){
            result = operator.apply(result,item);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryOperator<Integer> accumulator = (a,b)->a+b;
        Integer sumResult = calc(Arrays.asList(1,2,3),0,accumulator);
        System.out.println("1,2,3 sumResult:"+sumResult);
        System.out.println("1,2,3 sumResult:"+calc(Arrays.asList(1,2,3),0,Integer::sum));

        BinaryOperator<Integer> multiply = (a,b)->a*b;
        Integer multiplyResult = calc(Arrays.asList(1,2,3),1,multiply);
        System.out.println("1,2,3 multiplyResult:"+multiplyResult);


        Developer tom = new Developer("Tom",BigDecimal.valueOf(15000.00));
        Developer martin = new Developer("Martin",BigDecimal.valueOf(38000.00));
        Developer jack = new Developer("Jack",BigDecimal.valueOf(25000.00));
        List<Developer> developers = Arrays.asList(tom,martin,jack);
        BinaryOperator<Developer> findMaxOperator = (x,y)->{
            if(x == null){
                if(y != null){
                    return y;
                }
            }
            if(x.salary.compareTo(y.salary)>0){
                return x;
            }
            return y;
        };

        Developer highestDeveloper = find(developers,findMaxOperator);
        System.out.println("highestDeveloper : "+highestDeveloper);
        highestDeveloper = find(developers,BinaryOperator.minBy(Comparator.comparing(Developer::getSalary)));
        System.out.println("lowestDeveloper : "+highestDeveloper);
    }

    public static <T> T find(List<T> list,BinaryOperator<T> operator){
        T result = null;
        for(T item:list){
            if(result == null){
                result = item;
            }else{
                result = operator.apply(result,item);
            }
        }
        return result;
    }

}
class Developer {
    String name;
    BigDecimal salary;

    public Developer(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }
    public BigDecimal getSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return "Developer{" +
            "name='" + name + '\'' +
            ", salary='" + salary + '\'' +
            '}';
    }
}
