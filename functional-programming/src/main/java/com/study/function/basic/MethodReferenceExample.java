package com.study.function.basic;

import lombok.Data;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Anonymous Class -> Lambda expression -> Method Reference
 *
 */
public class MethodReferenceExample {
    public void test(int a){

    }
    public static void anonymousClassPrint(List<String> list){
        System.out.println("------anonymousClassPrint------");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });
        System.out.println();
    }

    public static void lambdaExpressionPrint(List<String> list){
        System.out.println("------lambdaExpressionPrint------");
        list.forEach(x-> System.out.print(x+" "));
        System.out.println();
    }
    public static void methodReferencePrint(List<String> list){
        System.out.println("------methodReferencePrint------");
        list = list.stream().map(x->x+" ").collect(Collectors.toList());
        list.forEach(System.out::print);
        System.out.println();
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("node", "java", "python", "ruby");
        anonymousClassPrint(list);
        lambdaExpressionPrint(list);
        methodReferencePrint(list);
        ComparatorProvider comparatorProvider = new ComparatorProvider();

        List<Employee> employees = Arrays.asList(
            new Employee("mkyong", 38, BigDecimal.valueOf(3800)),
            new Employee("zilap", 5, BigDecimal.valueOf(10000)),
            new Employee("ali", 25, BigDecimal.valueOf(2500)),
            new Employee("unknown", 99, BigDecimal.valueOf(9999)));
        employees.sort(comparatorProvider::compareByAge);
        System.out.println(employees);
        employees.sort(comparatorProvider::compareBySalary);
        System.out.println(employees);
    }
}

@Data
@AllArgsConstructor
class Employee {
    String name;
    Integer age;
    BigDecimal salary;
}

class ComparatorProvider {

    public int compareByAge(Employee o1, Employee o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
    public int compareByName(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public int compareBySalary(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }

}