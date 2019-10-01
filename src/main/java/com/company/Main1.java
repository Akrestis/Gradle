package com.company;

import java.io.File;
import java.util.Arrays;

public class Main1 {

    public static void main(String[] args) {

        //1. Вывести список файлов текущей директории

        File fileDir = new File(".");
        System.out.println(Arrays.toString(fileDir.listFiles()));
    }
}
