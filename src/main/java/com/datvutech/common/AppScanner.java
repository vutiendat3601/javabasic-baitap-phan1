package com.datvutech.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppScanner {
    private static Scanner SYSTEM_SCANNER;
    private static Scanner FILE_SCANNER;

    public static Scanner getSystemScanner() {
        if (SYSTEM_SCANNER == null) {
            SYSTEM_SCANNER = new Scanner(System.in);
        }
        return SYSTEM_SCANNER;
    }

    public static Scanner getFileScanner(String filePath) {
        if (FILE_SCANNER == null) {
            try {
                FILE_SCANNER = new Scanner(Files
                        .newInputStream(Paths.get(filePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return FILE_SCANNER;
    }

}
