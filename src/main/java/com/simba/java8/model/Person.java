package com.simba.java8.model;

public class Person extends EmptyPerson{

  private Long id;
  private String name;
  private Integer age;
  private String address;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void specialObject(final Person person){
    System.out.println("specialObject");
  }

  public void specialClass(){
    System.out.println("specialClass");
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }

  public Person() {
    return;
  }
  public static void staticMethod(Person person){
    System.out.println("静态方法");
  }

  public static void staticMethodString(String string){
    System.out.println("静态方法");
  }
}
