package com.huatong.domain;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

public class Student implements Serializable, Comparable<Student> {
    private String name;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    private Integer age;

    private Date birthday;

    private Child child;


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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(){
        System.out.println("========================构造被调用了=====================");
    }
    @Override
    public int compareTo(Student student) {

        int i = this.getAge().compareTo(student.getAge());
        if (i == 0) {
            i = this.getName().compareTo(student.getName());
        }
        return i;
    }


    private static class Child {
        private String tag;
        private String data;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Child(String tag, String data) {
            this.tag = tag;
            this.data = data;
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder("{");
        if (StringUtils.isNotBlank(name)) {
            builder.append("\"name\":\"").append(name).append("\",");
        }
        if (birthday != null) {
            builder.append("\"name\":\"").append(birthday).append("\",");
        }
        builder.append("\"age\":\"").append(age).append("\"");
        builder.append("}");
        return builder.toString();
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {


    }


    public Person getInstance(){
        cc cc = new cc();
        return cc;
    }

    private class cc implements Person{
        @Override
        public Person sing() {
            return new cc();
        }
    }


}
