package com.lyx.io.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileWriteDemo {

    public static String UNLOAD_FILE = "C:\\Users\\LyxWin\\IdeaProjects\\own\\lastwhisperWork\\src\\main\\java\\com\\lyx\\io\\file\\test.txt";

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Files.write(Paths.get(UNLOAD_FILE), list, StandardOpenOption.APPEND);
//        Files.write(Paths.get(UNLOAD_FILE), list);
    }

//    public static void main(String[] args) throws IOException {
//        Files.write(Paths.get(UNLOAD_FILE), "abc123".getBytes(StandardCharsets.UTF_8));
//    }

}
