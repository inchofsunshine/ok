package com.alu.test.okletusgo.kotlin.java;

import com.alu.test.okletusgo.kotlin.data.Person;

/**
 * Created by Alu on 2017/5/26.
 * 版本：V1.0
 */

public class PersonMain {
    public static void main(String ... args){
        Person person = new Person("alu",27);
        System.out.print(person.getName()+"is"+person.age);
        person.setName("zhx");
        person.age = 18;
        System.out.print(person.getName()+"is"+person.age);

    }
}
