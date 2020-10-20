package com.lihewei.spring.ioc.reflect;

import lombok.Data;


public class Person {
    private  int age;
    private  String name;

    public Person(){

    }

    public Person(int age,String name){
        this.name=name;
        this.age=age;
    }

    public  void function1(){
        System.out.println ("function1");
    }

    public  void function2(){
        System.out.println ("function2");
    }

    public  String function3(String name){
        return  name;
    }



    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
