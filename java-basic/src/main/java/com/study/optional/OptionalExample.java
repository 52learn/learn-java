package com.study.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

/**
 * @see {https://mkyong.com/java8/java-8-optional-in-depth/}
 */
public class OptionalExample {

    public static void  map(){
        System.out.println(Optional.of("male").map(String::toUpperCase));
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.map(String::toUpperCase));
    }

    public static void filter(){
        Optional<String> optional = Optional.of("male");
        Optional<String> filterOptional = optional.filter(value->value.equals("MALE"));
        System.out.println(filterOptional);
    }

    public static void flatMap(){
        MobileService mobileService = new MobileService();
        Mobile emptySizeMobile = new Mobile("apple","Iphone 14",Optional.empty(),null);
        int size = mobileService.getMobileSize(Optional.of(emptySizeMobile));
        System.out.println(" mobile size: "+size+",madePlaceCountry:"+ mobileService.getMadePlaceCountry(Optional.of(emptySizeMobile)));
        Mobile withSizeMobile = new Mobile("apple","Iphone 14",Optional.of(new DisplayFeatures(15)),new MadePlace("China"));
        System.out.println(" mobile size: "+mobileService.getMobileSize(Optional.of(withSizeMobile))
            +",madePlaceCountry:"+ mobileService.getMadePlaceCountry(Optional.of(withSizeMobile)));

    }



    public static void main(String[] args) {
        map();
        filter();
        flatMap();
    }

    static class MobileService{
        public int getMobileSize(Optional<Mobile> mobile){
             return mobile.flatMap(Mobile::getDisplayFeatures).map(DisplayFeatures::getSize).orElse(0);
        }

        public String getMadePlaceCountry(Optional<Mobile> mobile){
            return mobile.map(Mobile::getMadePlace).map(MadePlace::getCountry).orElse("");
        }
    }
    @Data
    @AllArgsConstructor
    static class Mobile {
        private String brand;
        private String name;
        private Optional<DisplayFeatures> displayFeatures;
        private MadePlace madePlace;

    }
    @Data
    @AllArgsConstructor
    static class DisplayFeatures{
       private int size;
    }

    @Data
    @AllArgsConstructor
    static class MadePlace{
        private String country;
    }
}
