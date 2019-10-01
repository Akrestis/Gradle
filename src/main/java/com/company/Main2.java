package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        //2*. Вывести список файлов текущей директории рекурсивно (только файлов без директорий)

        File fileDir = new File(".");
        List<String> names = new ArrayList<>();
        getFileNames(names,fileDir.toPath());
        System.out.println();
    }

    private static void getFileNames(List<String> fileNames, Path dir) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path path : stream) {
                if(path.toFile().isDirectory()) {
                    getFileNames(fileNames, path);
                } else {
                    fileNames.add(path.toAbsolutePath().toString());
                    System.out.println(path.getFileName());
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
