package com.lihewei.spring.ioc.bean;

/**
 * @author  lihewei
 */
public class User {
    private  String userName;
    private  Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }
   public User(String userName,Integer age){
        this.userName=userName;
        this.age=age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
