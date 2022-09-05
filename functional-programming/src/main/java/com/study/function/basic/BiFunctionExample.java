package com.study.function.basic;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static <R> R factory(String latitude,String longitude, BiFunction<String,String,R> func){
        return func.apply(latitude,longitude);
    }

    public static void main(String[] args) {
        //BiFunction<String,String,GPS> newGpsFunc = (x,y)->new GPS(x,y);
        GPS gps = factory("40.741895", "-73.989308",GPS::new);
        System.out.println("gps:"+gps);

    }
}

class GPS{
    String Latitude;
    String Longitude;

    public GPS(String latitude, String longitude) {
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    @Override
    public String toString() {
        return "GPS{" +
            "Latitude='" + Latitude + '\'' +
            ", Longitude='" + Longitude + '\'' +
            '}';
    }
}
