package com.datvutech.answer;

public class Bai18 {

    public static void printRetangle(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        printRetangle(n, m);
    }
}
