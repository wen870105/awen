/**
 * LY.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.test.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author wsy48420
 * @version $Id: Person.java, v 0.1 2017年11月7日 下午3:59:33 wsy48420 Exp $
 */
public class Person implements Serializable {

    private String  name   = null;

    private Integer age    = null;

    private Gender  gender = null;

    private Son     son    = null;

    public Person() {
        System.out.println("none-arg constructor");
    }
    

    public Son getSon() {
        return son;
    }


    public void setSon(Son son) {
        this.son = son;
    }

    public Person(String name, Integer age, Gender gender,Son son) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.son = son;
    }

    public Person(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }

    public static void main(String[] args) throws Exception, IOException {
        File file = new File("d:\\person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Son s = new Son();
        s.setName("1234");
        Person person = new Person("John", 101, Gender.MALE,s);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型  
        oin.close();
        System.out.println(newPerson);
    }
}