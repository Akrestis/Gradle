package com.company;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main3 {

    public static void main(String[] args) {

        //3*. Подсчитать количество файлов в src.zip который находится в директории JDK.

        try {
            ZipFile zipFile = new ZipFile("C:\\Program Files\\Java\\jdk1.8.0_192\\src.zip");
            final Enumeration<? extends ZipEntry> entries = zipFile.entries();
            int num  = 0;
            while (entries.hasMoreElements()) {
                if (! entries.nextElement().isDirectory()) {
                    ++num;
                }
            }
            System.out.println(num + " files in this archive");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
