//package com.codeup.springblog.models;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "dogs")
//public class Dog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "INT(11) UNSIGNED")
//    private Long id;
//
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @Column(nullable = false, length = 100)
//    private int age;
//
//    @Column(nullable = false, length = 100)
//    private String residentState;
//
//
//
//
//    public Dog(){}
//
//
//    public Dog(long id, int age, String name, String residentState){
//        this.id = id;
//        this.age = age;
//        this.name = name;
//        this.residentState = residentState;
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getResidentState() {
//        return residentState;
//    }
//
//    public void setResidentState(String residentState) {
//        this.residentState = residentState;
//    }
//
//
//}
