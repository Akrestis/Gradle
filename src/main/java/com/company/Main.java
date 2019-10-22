package com.company;

public class Main {

    static final String FILE_NAME = "test.txt";

    public static void main(String[] args) {

        //3) Написать интерфейс Storage, и класс FileStorage,
        //который в конструкторе принимает имя файла где будут храниться данные.
        //Продемонстрирвоать работу всех методов.
        //Данные должны храниться в тектовом файле в формате JSON.
        //При добавлении метод addUser должен назначить User уникальный id - порядковый номер.


        FileStorage fileStorage = new FileStorage(FILE_NAME);

        fileStorage.addUser(new User("Alex", 11));
        fileStorage.addUser(new User("Ben", 22));
        fileStorage.addUser(new User("Carl", 33));
        fileStorage.addUser(new User("Dan", 44));
        System.out.println(fileStorage.getAllUsers());

        fileStorage.removeUser(2);
        System.out.println(fileStorage.getAllUsers());

        fileStorage.removeUserByName("Ben");
        System.out.println(fileStorage.getAllUsers());

        fileStorage.updateUser(new User("Alex", 55));
        System.out.println(fileStorage.getAllUsers());

        System.out.println(fileStorage.getUser(0));

        fileStorage.removeAll();
        System.out.println(fileStorage.getAllUsers());
    }
}
