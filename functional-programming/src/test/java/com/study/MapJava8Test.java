package com.study;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapJava8Test {

    private Map<Integer,String> map = new HashMap<>();
    @Before
    public void setUp(){
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
    }

    @Test
    public void forEach(){
        map.forEach((key,value)->{
            System.out.println(key+"->"+value);
        });
    }

    @Test
    public void getOrDefault(){
        int randomKey = new Random().nextInt();
        String  value = map.getOrDefault(randomKey,"random value not exist...");
        System.out.println("randomKey:"+randomKey+",value:"+value);
    }

    @Test
    public void putIfAbsent(){
        map.putIfAbsent(10,"ten");
        printMap();
    }

    @Test
    public void replace(){
        map.replace(5,"five");
        printMap();
    }

    @Test
    public void replaceWithDefault(){
        map.replace(3,"three","3");
        printMap();
    }
    @Test
    public void replaceAll(){
        map.replaceAll((key,value)->key+":"+value);
        printMap();
    }
    @Test
    public void replaceAll2(){
        map.replaceAll((key,value)->value);
        printMap();
    }

    @Test
    public void merge(){
        //map.merge();
    }

    @Test
    public void compute(){
        map.compute(3,(key,value)->key+":"+value);
        printMap();
    }

    @Test
    public void computeIfAbsent(){
        map.computeIfAbsent(6,(key)->key+":six");
        printMap();
    }

    @Test
    public void computeIfPresent(){
        map.computeIfPresent(6,(key,value)->key+":six");
        printMap();
    }
    private void printMap(){
        map.forEach((key,value)->{
            System.out.println(key+"->"+value);
        });
    }
}
