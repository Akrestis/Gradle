package com.company;

class User {

    private int id;
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
        setId(UsersList.getId());
    }

    void setId(int id) {
        this.id = id;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" + "id: " + id + ", name: " + name + ", age: " + age + '}';
    }
}
